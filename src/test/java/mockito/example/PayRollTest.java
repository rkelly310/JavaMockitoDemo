package mockito.example;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InOrder;

public class PayRollTest {

	private PayRoll payRoll;

	private EmployeeDB employeeDB;

	private BankService bankService;

	private List<Employee> employees;

	@Before
	public void init() {
		employees = new ArrayList<Employee>();

		employeeDB = mock(EmployeeDB.class);
		bankService = mock(BankService.class);

		when(employeeDB.getAllEmployees()).thenReturn(employees);

		payRoll = new PayRoll(employeeDB, bankService);
	}

	@Test
	public void testNoEmployees() {
		assertNumberOfPayments(0);
	}

	@Test
	public void testSingleEmployee() {
		employees.add(createTestEmployee("Test Employee", "ID1", 1000));

		assertNumberOfPayments(1);
	}

	@Test
	public void testOnlyOneInteractionWithDB() {
		payRoll.monthlyPayment();
		verify(employeeDB, times(1)).getAllEmployees();
	}

	@Test
	public void testEmployeeIsPaid() {
		String employeeId = "ID1";
		int salary = 1000;

		employees.add(createTestEmployee("Test Employee", employeeId, salary));

		assertNumberOfPayments(1);

		verify(bankService, times(1)).makePayment(employeeId, salary);
	}

	@Test
	public void testAllEmployeesArePaid() {
		employees.add(createTestEmployee("Test Employee1", "ID1", 1000));
		employees.add(createTestEmployee("Test Employee2", "ID2", 2000));

		assertNumberOfPayments(2);

		ArgumentCaptor<String> idCaptor = ArgumentCaptor.forClass(String.class);
		ArgumentCaptor<Integer> salaryCaptor = ArgumentCaptor.forClass(Integer.class);

		verify(bankService, times(2)).makePayment(idCaptor.capture(), salaryCaptor.capture());

		assertEquals("ID1", idCaptor.getAllValues().get(0));
		assertEquals("ID2", idCaptor.getAllValues().get(1));
		assertEquals(1000, salaryCaptor.getAllValues().get(0).intValue());
		assertEquals(2000, salaryCaptor.getAllValues().get(1).intValue());
	}

	@Test
	public void testInteractionOrder() {
		String employeeId = "ID1";
		int salary = 1000;

		employees.add(createTestEmployee("Test Employee", employeeId, salary));

		assertNumberOfPayments(1);
		
		InOrder inOrder = inOrder(employeeDB, bankService);
		inOrder.verify(employeeDB).getAllEmployees();
		inOrder.verify(bankService).makePayment(employeeId, salary);
	}

	private void assertNumberOfPayments(int expected) {
		int numberOfPayments = payRoll.monthlyPayment();
		assertEquals(expected, numberOfPayments);
	}

	private Employee createTestEmployee(String name, String id, int salary) {
		return new Employee(name, id, salary);
	}

}

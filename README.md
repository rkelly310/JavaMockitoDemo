<!-- PROJECT LOGO -->
<br />
<p align="center">
  <a href="https://github.com/rkelly310/JavaMockitoDemo/">
    <img src="images/mockito.png" alt="Logo">
  </a>

  <h2 align="center">Creating and Testing a Mockito example using TDD and BDD frameworks</h2>

  <p align="center">
    A demo lab instructing users on construct BDD test projects, feature files, step definitions and test runners to complete a BDD test iteration.
    <br />
    <a href="https://github.com/rkelly310/JavaMockitoDemo/"><strong>Explore the docs �</strong></a>
    <br />
    <br />
    <a href="https://github.com/rkelly310/JavaMockitoDemo/">View Demo</a>
    �
    <a href="https://github.com/rkelly310/JavaMockitoDemo/issues">Report Bug</a>
    �
    <a href="https://github.com/rkelly310/JavaMockitoDemo/issues">Request Feature</a>
  </p>
</p>



<!-- TABLE OF CONTENTS -->
<details open="open">
  <summary>Table of Contents</summary>
  <ol>
    <li>
      <a href="#about-the-project">About The Project</a>
      <ul>
        <li><a href="#built-with">Built With</a></li>
      </ul>
    </li>
    <li>
      <a href="#getting-started">Getting Started</a>
      <ul>
        <li><a href="#prerequisites">Prerequisites</a></li>
        <li><a href="#installation">Installation</a></li>
        </ul>
        <li><a href="#instructions">Instructions</a></li>
      </ul>
    </li>
<!--
    <li><a href="#roadmap">Roadmap</a></li>
    <li><a href="#contributing">Contributing</a></li>
-->
    <li><a href="#license">License</a></li>
    <li><a href="#contact">Contact</a></li>
<!--
    <li><a href="#acknowledgements">Acknowledgements</a></li>
-->
  </ol>
</details>



<!-- ABOUT THE PROJECT -->
### About The Project

This project is designed for a lab environment within a Test Automation and Behavior-Driven Development course. Students will build out a feature file, a series of step definitions, a Cucumber-JVM test runner class to test a basic webdriver application that searches a google page for a specific phrase and passes only if the search results match the phrase.
To view individual requirement solutions, review the steps below.

### Built With

* [Eclipse IDE] Version: 2021-03 (4.19.0) (https://www.eclipse.org/downloads/)
* [Java Development Kit v.11.28](https://openjdk.java.net/projects/jdk/11/)
* Chromedriver.exe (or another browser equivalent) existing in your System PATH) https://chromedriver.chromium.org/downloads
<br>
**Please ensure you also download the following plugins if you do not have them already:**

* [Junit 5] Testing Framework
* [Cucumber Eclipse Plugin]
* [Maven Integration for Eclipse]
<br>

You can download these plugins in the Eclipse Marketplace.You should also add the following dependencies to your project:
```java
    <dependencies>
        <!-- AssertJ -->
        <dependency>
            <groupId>org.assertj</groupId>
            <artifactId>assertj-core</artifactId>
            <version>3.8.0</version>
            <scope>test</scope>
        </dependency>

        <!-- Cucumber -->
        <dependency>
            <groupId>io.cucumber</groupId>
            <artifactId>cucumber-java</artifactId>
            <version>2.0.1</version>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>io.cucumber</groupId>
            <artifactId>cucumber-junit</artifactId>
            <version>2.0.1</version>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>io.cucumber</groupId>
            <artifactId>cucumber-picocontainer</artifactId>
            <version>2.0.1</version>
            <scope>test</scope>
        </dependency>

        <!-- JUnit -->
        <dependency>
            <groupId>junit</groupId>
            <artifactId>junit</artifactId>
            <version>4.12</version>
            <scope>test</scope>
        </dependency>

        <!-- Selenium WebDriver -->
        <dependency>
            <groupId>org.seleniumhq.selenium</groupId>
            <artifactId>selenium-java</artifactId>
            <version>3.6.0</version>
        </dependency>
```

<!-- GETTING STARTED -->
## Getting Started

### Prerequisites

None, other than a a Java IDE (preferred Eclipse), and either Gradle or Maven.

### Installation

Simply clone the repo to see the full solution:
   ```sh
   git clone https://github.com/rkelly310/JavaMockitoDemo.git
   ```
<!-- Instructions -->
## Instructions
### Task 1: Review the currently existing .java files
Once the application has been cloned, take a look at the four primary .java files that are packaged into the application within the **src/test/java** classpath.  
<br>
**framework/AbstractWFPage.java**  
This file imports our selenium webdriver and sets up the Webpage's base class. It also initializes the methods that each webpage object can utilize (getDriver, driverWait). The class will be instantiated once our webpage is opened. Since we are employing chromedriver.exe, this class is inherited by our next 'GooglePage.java' file.  
**pages/GooglePage.java**  
This file extends our webpage class to create a Google Webpage-specific child class. It sets the constructor and calls the 'super' keyword to refer to the instant parent class. It also declares specific actions that can be taken by the Google webpage.  
**runners/WFCucumberTest.java**  
This is our runner class that points our Junit framework plugin to our feature and glue files that contain our Cucumber steps and step definitions respectively.  
**stepdefs/GoogleSearchSteps.java**  
This file elaborates on the Gherkin scenario to give each statement a corresponding method test within our Google webpage. It also defines a few 'hooks' to run before and after the sample test.  
<br>
**GoogleSearch.Feature**  
This is our feature file, which can be found in the **src/test/resources** path. It's contents are shown here:  
```
Feature: Google Searching
  As a web developer,
  I want to search Google,
  So that I can learn new solutions to current software problems.

  @automated @web @google
  Scenario: Simple Google search
    Given a web browser is on the Google page
    When the search phrase "examplephrase" is entered
    Then results for "examplephrase" are shown
```
<br>

### Task 2: Run the Test  
Once the project has been built successfully, this project can be tested using the  
```
mvn clean test
```
command within the cmd directory of the project, or with gradle using the command:  
```
gradlew bootRun
```
You should see the webdriver initialize and open your browser, auto-search the phrase, scan the search results and close the browser successfully. This simple example provides the scaffolding to perform Selenium automated non-function testing on various components of your web applications, and can be extended for cross-browser testing as well.  
<br>

### Task 3: Extend Test Functionality  
To practice BDD and automation, try the following exercises:  
<br>
1. The assertion for the "results for ___ are shown" step checks only the page title. Add more comprehensive assertions to strengthen the test.  
2. Add a new scenario to search Google for images.  
3. Add a new scenario to perform Google searches directly using URL query parameters.  
4. Add a new feature for basic tests against Wikipedia using a new page object class, a new step definition class, and dependency injection.  
5. Picking a language from the home page.  
6. Searching for articles.  
7. Verifying that embedded links navigate to the correct articles.  
8. Viewing page history.  
9. Make it possible to choose the web browser using a properties file. Classes to read the properties file and construct the appropriate web driver should be put in the framework package.  
10. Write a new feature for basic service-level testing. Use REST Assured to hit a few endpoints from JSONPlaceholder.  
11. Create separate test runners that partition the set of features using tags.  
12. Add logging to the tests with SLF4J or Extent Reports. 
<br>
<!-- LICENSE -->
## License

Distributed under the MIT License. See `LICENSE` for more information.

<!-- CONTACT -->
## Contact

Project Link: [https://github.com/rkelly310/JavaMockitoDemo/](https://github.com/rkelly310/JavaMockitoDemo/)



<!-- MARKDOWN LINKS & IMAGES -->
<!-- https://www.markdownguide.org/basic-syntax/#reference-style-links -->
[contributors-shield]: https://img.shields.io/github/contributors/othneildrew/Best-README-Template.svg?style=for-the-badge
[contributors-url]: https://github.com/othneildrew/Best-README-Template/graphs/contributors
[forks-shield]: https://img.shields.io/github/forks/othneildrew/Best-README-Template.svg?style=for-the-badge
[forks-url]: https://github.com/othneildrew/Best-README-Template/network/members
[stars-shield]: https://img.shields.io/github/stars/othneildrew/Best-README-Template.svg?style=for-the-badge
[stars-url]: https://github.com/othneildrew/Best-README-Template/stargazers
[issues-shield]: https://img.shields.io/github/issues/othneildrew/Best-README-Template.svg?style=for-the-badge
[issues-url]: https://github.com/othneildrew/Best-README-Template/issues
[license-shield]: https://img.shields.io/github/license/othneildrew/Best-README-Template.svg?style=for-the-badge
[license-url]: https://github.com/othneildrew/Best-README-Template/blob/master/LICENSE.txt
[linkedin-shield]: https://img.shields.io/badge/-LinkedIn-black.svg?style=for-the-badge&logo=linkedin&colorB=555
[linkedin-url]: https://linkedin.com/in/othneildrew
[product-screenshot]: images/screenshot.png

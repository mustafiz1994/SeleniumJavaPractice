Selenium Java Automation Framework

A Maven-based Selenium WebDriver automation framework using Java,
TestNG, Page Object Model, explicit waits, configuration management, and
Selenium Manager.

This project is currently being built as a hands-on Selenium practice
framework using the Let's Kode It Practice Page.

Application under test:

https://www.letskodeit.com/practice

1. Purpose of the Project

The purpose of this project is to build a clean, maintainable, and
interview-ready Selenium automation framework while practicing common
Selenium scenarios.

The framework is designed so that:

Test cases contain test logic only.

Page-specific locators and actions stay inside Page Object classes.

WebDriver creation is centralized.

Browser selection is controlled through config.properties.

Explicit waits are reusable.

Selenium Manager handles browser driver management.

Maven is used to build and execute the tests.

TestNG is used as the test execution framework.

2. Technology Stack

Technology                  Version / Approach

Java                        17 LTS
Selenium WebDriver          4.48.0
TestNG                      7.12.0
Maven                       3.9.2
Maven Compiler Plugin       3.16.0
Maven Surefire Plugin       3.6.0
Browser Driver Management   Selenium Manager
Build Tool                  Maven
Test Framework              TestNG
Design Pattern              Page Object Model

WebDriverManager is intentionally not used. Modern Selenium uses
Selenium Manager to manage browser drivers automatically.

3. Project Structure

SeleniumJavaPractice
│
├── pom.xml
│
├── src
│   │
│   ├── main
│   │   └── java
│   │       └── com.automation
│   │           │
│   │           ├── base
│   │           │   └── BasePage.java
│   │           │
│   │           ├── driver
│   │           │   └── DriverFactory.java
│   │           │
│   │           ├── pages
│   │           │   └── PracticePage.java
│   │           │
│   │           └── utils
│   │               ├── ConfigReader.java
│   │               └── WaitUtils.java
│   │
│   └── test
│       │
│       ├── java
│       │   └── com.automation.tests
│       │       │
│       │       ├── BaseTest.java
│       │       └── PracticePageTests.java
│       │
│       └── resources
│           │
│           ├── config
│           │   └── config.properties
│           │
│           └── testng.xml
│
├── target
└── .gitignore

4. Framework Components

4.1 pom.xml

Location:

SeleniumJavaPractice/pom.xml

The pom.xml manages project dependencies and Maven plugins.

Main dependencies:

Selenium Java

TestNG

Main Maven plugins:

Maven Compiler Plugin

Maven Surefire Plugin

Java 17 is configured through:

<maven.compiler.release>17</maven.compiler.release>

5. Configuration Management

config.properties

Location:

src/test/resources/config/config.properties

Current configuration:

base.url=https://www.letskodeit.com/practice
browser=chrome
explicit.wait=10

Configuration values

Property          Purpose

base.url        Application URL
browser         Browser to execute the tests
explicit.wait   Default explicit wait timeout in seconds

The test code does not hardcode the application URL or wait timeout.

6. Supported Browsers

The framework supports:

chrome
edge
firefox

Change only the browser property.

Chrome

browser=chrome

Edge

browser=edge

Firefox

browser=firefox

No test class needs to be modified when changing browsers.

7. DriverFactory

Location:

src/main/java/com/automation/driver/DriverFactory.java

DriverFactory is responsible for:

Reading the browser from configuration

Creating the appropriate WebDriver

Maximizing the browser

Providing the driver to the framework

Closing the browser

Conceptually:

config.properties
|
v
ConfigReader
|
v
DriverFactory
/   |   \
/    |    \
Chrome Edge Firefox

Selenium Manager automatically manages the required browser driver.

8. BaseTest

Location:

src/test/java/com/automation/tests/BaseTest.java

BaseTest manages the common test lifecycle.

Before each test

Create WebDriver
↓
Maximize browser
↓
Open base URL

After each test

Quit WebDriver

Test classes extend BaseTest so they do not need to duplicate browser
setup and teardown code.

Example:

public class PracticePageTests extends BaseTest {

    @Test
    public void sampleTest() {
        // Test logic
    }
}

9. ConfigReader

Location:

src/main/java/com/automation/utils/ConfigReader.java

ConfigReader loads:

src/test/resources/config/config.properties

Tests and framework classes can retrieve values using:

ConfigReader.getProperty("browser");

or:

ConfigReader.getProperty("base.url");

This keeps configuration outside the Java code.

10. WaitUtils

Location:

src/main/java/com/automation/utils/WaitUtils.java

WaitUtils provides reusable explicit wait methods.

Examples include:

wait.waitForVisibility(locator);

wait.waitForClickable(locator);

wait.waitForElementToDisappear(locator);

wait.waitForTitle("Google");

The framework avoids unnecessary:

Thread.sleep(...)

Explicit waits are preferred for synchronization with web elements.

11. BasePage

Location:

src/main/java/com/automation/base/BasePage.java

BasePage contains common Selenium operations that can be reused by
different Page Object classes.

Examples:

click(locator);

enterText(locator, text);

getText(locator);

isDisplayed(locator);

selectByVisibleText(locator, text);

Individual page classes extend BasePage.

Conceptually:

BasePage
|
+---- PracticePage
|
+---- FuturePage
|
+---- FuturePage

12. PracticePage

Location:

src/main/java/com/automation/pages/PracticePage.java

This is the Page Object for:

https://www.letskodeit.com/practice

The page object contains:

Web element locators

Page-specific actions

Page-specific state/verification methods

Example:

practicePage.selectBMWRadioButton();

The test should not directly interact with the locator whenever a page
method can represent the action.

13. PracticePageTests

Location:

src/test/java/com/automation/tests/PracticePageTests.java

This class contains TestNG test scenarios for the Practice Page.

The current practice work starts with radio button scenarios.

Example:

@Test
public void verifyBMWRadioButtonSelection() {

    practicePage.selectBMWRadioButton();

    Assert.assertTrue(
            practicePage.isBMWRadioSelected(),
            "BMW radio button should be selected");
}

The test focuses on:

Action
↓
Verification
↓
Assertion

rather than WebDriver implementation details.

14. TestNG

TestNG is used for:

@Test

@BeforeMethod

@AfterMethod

Test organization

Assertions

Test suite execution

The TestNG suite is located at:

src/test/resources/testng.xml

15. Running the Tests

Open a terminal in the project root:

C:\Users\musta\Documents\SeleniumJavaPractice

Run:

mvn clean test

This will:

Clean the previous target directory.

Compile the Java source code.

Compile the test code.

Execute the TestNG suite.

Generate Maven test results.

16. Run a Specific Test Class

Example:

mvn -Dtest=PracticePageTests test

17. Run a Specific Test Method

Example:

mvn -Dtest=PracticePageTests#verifyBMWRadioButtonSelection test

18. Browser Selection

Currently, browser selection is controlled by:

browser=chrome

For Edge:

browser=edge

For Firefox:

browser=firefox

Then execute:

mvn clean test

The same tests run against the selected browser.

19. Current Selenium Practice Plan

The Let's Kode It Practice Page is being used to practice Selenium
features scenario by scenario.

Phase 1: Basic Elements

Radio buttons

Checkboxes

Select dropdown

Multiple select

Phase 2: Browser Context

Multiple windows

Multiple tabs

Phase 3: Dynamic Elements

Auto suggestion

Phase 4: Element State

Enable / Disable

Hide / Show

Phase 5: JavaScript Dialogs

Alert

Confirm

Accept

Dismiss

Phase 6: Advanced User Interactions

Mouse hover

Actions API

Phase 7: Web Tables

Read table headers

Count rows

Count columns

Find a specific record

Validate table data

Phase 8: Frames

Locate iframe

Switch to iframe

Interact with elements inside iframe

Switch back to default content

20. Framework Execution Flow

Maven
|
v
TestNG
|
v
BaseTest
|
v
DriverFactory
|
v
ConfigReader
|
v
config.properties
|
+---- browser
|
+---- base.url
|
+---- explicit.wait
|
v
WebDriver
|
v
PracticePageTests
|
v
PracticePage
|
v
BasePage
|
v
WaitUtils
|
v
Selenium WebDriver

21. Design Principles

This framework follows a few important principles.

Keep tests readable

Tests should describe what is being tested, not how Selenium performs
every low-level operation.

Keep locators in Page Objects

Locators should generally stay inside the relevant page class.

Centralize WebDriver creation

Browser initialization belongs in DriverFactory.

Keep configuration external

Browser, URL, and timeout values belong in config.properties.

Prefer explicit waits

Use reusable explicit waits instead of unnecessary hard waits.

Avoid duplicate code

Common Selenium operations belong in BasePage or utility classes.

22. Current Status

Completed

Java 17 environment configured

Maven configured and working

Selenium Java dependency configured

TestNG dependency configured

Maven Surefire configured

Selenium Manager used for browser driver management

Chrome execution configured

Edge execution supported

Firefox execution supported

Browser selection through config.properties

Base test structure

Driver Factory

Configuration reader

Wait utility

Base Page

Practice Page Object

Initial TestNG practice scenarios

Maven command-line execution

In Progress

Building and automating the Let's Kode It Practice Page scenario by
scenario.

23. Future Framework Enhancements

The framework can be enhanced gradually after the basic Selenium
scenarios are complete.

Planned areas:

TestNG DataProvider
↓
TestNG Listeners
↓
Automatic screenshots on failure
↓
Logging
↓
Test reports
↓
Data-driven testing
↓
Parallel execution
↓
Cross-browser execution
↓
Maven profiles
↓
CI/CD with GitHub Actions

The framework should be kept simple until each feature is actually
needed.

24. Quick Start

Step 1: Clone/Open the project

Open the project in IntelliJ IDEA.

Step 2: Verify Java

java -version

Expected:

Java 17

Step 3: Verify Maven

mvn -version

Expected:

Java version: 17.x.x

Step 4: Select Browser

Edit:

src/test/resources/config/config.properties

Example:

browser=chrome

Step 5: Run Tests

mvn clean test

25. Learning Objective

This project is not only intended to execute Selenium tests. It is being
developed to understand how a real automation framework is structured.

The main learning path is:

Selenium WebDriver
↓
TestNG
↓
Page Object Model
↓
Reusable Framework Components
↓
Configuration Management
↓
Cross-Browser Testing
↓
Advanced Selenium
↓
Test Data Management
↓
Reporting
↓
CI/CD

The end goal is a maintainable Selenium Java framework suitable for real
project work and SDET interviews.
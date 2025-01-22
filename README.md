# Bank Automation Testing Framework

This project automates Bank Account scenarios using **Selenium**, **TestNG**, and **Maven**. The framework also integrates **Allure** for test reporting.

---

## Prerequisites

### Software Requirements

1. **Java Development Kit (JDK)**: Version 8 or later.
2. **Maven**: For managing dependencies and running the tests.
3. **Google Chrome** and **ChromeDriver**: Ensure ChromeDriver matches your browser version.
4. **Allure**: For generating test reports.

### Dependencies
The project uses the following libraries:

- **Selenium**: For web automation.
- **TestNG**: For test execution.
- **Allure**: For test reporting.

All dependencies are managed via Maven.

---

## Installation

1. **Clone the Repository**:
   ```bash
   git clone https://github.com/michaelwaheb/BankAutomationTask.git
   cd BankAutomationTask
   ```

2. **Open in IDE**:
   - Import the project as a Maven project in your IDE.

3. **Install Dependencies**:
   - Maven will automatically resolve the dependencies when you load the `pom.xml` file. To force download:
     ```bash
     mvn clean install
     ```

---

## Configuration

 **Allure Reporting**:
   - Ensure Allure is installed:
     ```bash
     brew install allure # For macOS
     choco install allure # For Windows
     ```

---

## Running the Tests



1. **From IDE**:
   - Right-click on the test class or package and select `Run`.

2. **From Command Line**:
   ```bash
   mvn clean test
   ```
3. **Allure Report generating automatically after run**



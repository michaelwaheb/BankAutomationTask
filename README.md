# STC TV Subscription WebSite Automation

This project automates the validation of subscription packages for the STC TV website for three different countries (
Egypt, UAE, Iraq).
It uses Selenium WebDriver to navigate the subscription home page, extract subscription & country details, and validate
the packages based on type, price, and currency.
Allure is used for generating detailed test reports.

## Data Validation

- The test cases validate the subscription package types, prices, and currencies by comparing them against expected
  values defined in the CountrySubscriptionData class.
- If any discrepancies are found, the tests will fail, and the details will be logged in the Allure test report.

## Project Structure

- *HomePage.java*: Handles locators & interactions with the subscription Homepage.
- *CountrySubscriptionData*: Supplies Packages details (type,price currency) for each country for testing.
- *SubscriptionPackagesTest.java*: Executes tests for subscription validation.

## Prerequisites

- *Java 8+*
- *Maven* (for dependency management)
- *Selenium WebDriver*
- *TestNG* (for running tests)
- *Allure installtion (for generating reports)
- *ChromeDriver* (ensure the correct path is set in the tests)

## Setup and Installation

1. *Clone the Repository*

   bash
   git clone https://github.com/your-username/stc-tv-subscription-automation.git
   cd stc-tv-subscription-automation

2. *Install Allure Commandline*

   To generate Allure reports, you need to install the Allure command-line tool:

    - *For Windows:*

        - Download the Allure Commandline [from GitHub](https://github.com/allure-framework/allure2/releases) and add it
          to your system's PATH.
        - Open CMD and run the following command (allure serve "Path\allure-results") or open execute Mavn goal from
          intellji ide and run (mvn allure:serve)

## Running the Tests

### 1. Directly from the IDE

- Open the project in IntelliJ IDEA (or your preferred IDE).
- Right-click on the SubscriptionPackagesTest.java class.
- Select "Run SubscriptionPackagesTest".

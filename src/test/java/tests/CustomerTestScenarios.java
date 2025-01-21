package tests;

import models.CustomerData;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import resources.TestData;

public class CustomerTestScenarios extends BaseTest {

    @Test(dataProvider = "CustomerData", dataProviderClass = TestData.class)
    public void AddNewCustomerDetails(CustomerData customerData) {
        new HomePage(driver)
                .openBankingPage()
                .clickBankManagerloginbutton()
                .clickAddCustomertab()
                .fillCustomerForm(customerData.getFirstName(),
                        customerData.getSecondName(),
                        customerData.getPostalCode())
                .submitCustomerForm();

        String CustomerSubmittedData = new AddCustomerPage(driver).SubmittedCustomerData(customerData);
        new BankManagerLoginPage(driver).openCustomersPage();
        String LastCustomerDataRegistered = new CustomersPage(driver).LastCustomerDataRegistered();
//      Assert that the user order in the list is the same as the value retrieved from the alert
//      Assert that the user details are precisely the same as entered in the form
        Assert.assertEquals(CustomerSubmittedData, LastCustomerDataRegistered, "The last entered customer data details and order ID does not match the submitted data.");


    }

    @Test(dependsOnMethods = "AddNewCustomerDetails")
    public void AddNewAccount() {
        String customername = new CustomersPage(driver).LastCustomerNameRegistered();
        new BankManagerLoginPage(driver)
                .clickOpenAccountTab()
                .openCustomerDropDownList()
                .selectLastCreateduser(customername)
                .openCurrencyDropDownList()
                .selectRandomCurency()
                .clickProcessButton();
        String CustomerSubmittedAccount = new CreateAccountPage(driver).getCustomerAccountFromAlert();
        new BankManagerLoginPage(driver).openCustomersPage();
        String LastCustomerAccountRegistered = new CustomersPage(driver).LastCustomerAccountRegistered();
//      Assert that the Account Number retrieved from the alert is displayed in its cell for the created customer
        Assert.assertEquals(CustomerSubmittedAccount, LastCustomerAccountRegistered, "The last entered customer Account does not match the submitted Account.");

    }

    @Test(dependsOnMethods = "AddNewAccount")
    public void DeleteCreatedCustomer() {
        String customeraccount = new CustomersPage(driver).LastCustomerAccountRegistered();
        new CustomersPage(driver)
                .deleteCustomerRecord(customeraccount)
                .assertRecordDeletedByAccountnumber(customeraccount);
    }

}

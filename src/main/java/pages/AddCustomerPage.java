package pages;

import io.qameta.allure.Step;
import models.CustomerData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddCustomerPage extends BasePage {

    //Locators
    private final By FirstName = By.xpath("//input[@type=\"text\" and @ng-model=\"fName\" and @placeholder=\"First Name\"]");
    private final By SecondName = By.xpath("//input[@type=\"text\" and @ng-model=\"lName\" and @placeholder=\"Last Name\"]");
    private final By PostalCode = By.xpath("//input[@type=\"text\" and @ng-model=\"postCd\" and @placeholder=\"Post Code\"]");
    private final By AddNewCustomerbtn = By.cssSelector(".btn.btn-default");

//Methods to interact

    public AddCustomerPage(WebDriver driver) {
        super(driver);
    }

    @Step("Fill Customer Form")
    public AddCustomerPage fillCustomerForm(String firstname, String secondname, String postalcode) {
        bot.filldata(FirstName, firstname);
        bot.filldata(SecondName, secondname);
        bot.filldata(PostalCode, postalcode);

        return new AddCustomerPage(driver);
    }

    @Step("Submit new Customer Form")
    public AddCustomerPage submitCustomerForm() {
        bot.click(AddNewCustomerbtn);
        return new AddCustomerPage(driver);
    }

    @Step("Get Customer ID from the Alert")
    public String getCustomerIDFromAlert() {

        String alertText = bot.waitForAlert().getTextFromAlert();
        // Split the message to extract the ID
        String prefix = "Customer added successfully with customer id :";
        String customerId = null;

        if (alertText.startsWith(prefix)) {
            customerId = alertText.substring(prefix.length()).trim();
            System.out.println("Extracted User ID from Alert: " + customerId);
        } else {
            System.err.println("Customer ID not found in the alert message!");
        }

        // Accept the alert
        bot.acceptAlert();
        return customerId;
    }


    @Step("Submitted Customer data")
    public String SubmittedCustomerData(CustomerData customerData) {
        AddCustomerPage addcustomer = new AddCustomerPage(driver);
        String ID = addcustomer.getCustomerIDFromAlert();
        String firstname = customerData.getFirstName();
        String secondname = customerData.getSecondName();
        String postalcode = customerData.getPostalCode();
        String submittedData = ID + " FirstName: " + firstname + " SecondName: " + secondname + " PostalCode: " + postalcode;
        System.out.println("Actual Result: " + submittedData);
        return submittedData;
    }


}
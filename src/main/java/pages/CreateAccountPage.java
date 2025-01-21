package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class CreateAccountPage extends BasePage {
    //Locators
    private final By CustmerDropDown = By.id("userSelect");
    private final By CurrencyDropDown = By.id("currency");
    private final By Processbtn = By.xpath("//button[text()=\"Process\"]");

    //Methods to interact
    public CreateAccountPage(WebDriver driver) {
        super(driver);
    }

    @Step("Open Customer DropDown List")
    public CreateAccountPage openCustomerDropDownList() {
        bot.clickElementUsingJavaScript(CustmerDropDown);
        return new CreateAccountPage(driver);
    }

    @Step("Select last created User from dropdown list")
    public CreateAccountPage selectLastCreateduser(String CustomerName) {
        bot.click(By.xpath("//option[contains(@class, 'ng-binding') and contains(text(), '" + CustomerName + "')]"));
        return new CreateAccountPage(driver);
    }

    @Step("Open Currency DropDown List")
    public CreateAccountPage openCurrencyDropDownList() {
        bot.clickElementUsingJavaScript(CurrencyDropDown);
        return new CreateAccountPage(driver);
    }

    @Step("Select Random Currency from dropdown list")
    public CreateAccountPage selectRandomCurency() {
        WebElement currencyDropdownElement = driver.findElement(CurrencyDropDown); // Locate the dropdown
        bot.selectRandomOption(currencyDropdownElement); // Select a random option using the utility

        return new CreateAccountPage(driver);
    }

    @Step("Click Process to create the account")
    public CreateAccountPage clickProcessButton() {
        bot.clickElementUsingJavaScript(Processbtn);
        return new CreateAccountPage(driver);
    }

    @Step("Get Customer Account from the Alert")
    public String getCustomerAccountFromAlert() {

        String alertText = bot.waitForAlert().getTextFromAlert();
        // Split the message to extract the ID
        String prefix = "Account created successfully with account Number :";
        String customerAccount = null;

        if (alertText.startsWith(prefix)) {
            customerAccount = alertText.substring(prefix.length()).trim();
            System.out.println("Extracted User Account from Alert: " + customerAccount);
        } else {
            System.err.println("Customer Account not found in the alert message!");
        }

        // Accept the alert
        bot.acceptAlert();
        System.out.println("Actual Account Result: " + customerAccount);
        return customerAccount;
    }


}

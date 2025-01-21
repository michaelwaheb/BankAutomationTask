package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class BankManagerLoginPage extends BasePage {

    //Locators
    private final By AddCustmertab = By.xpath("//button[@ng-click=\"addCust()\"]");
    private final By Bankmanagerloginbtn = By.xpath("//button[contains(text(), \"Manager\")]");
    private final By OpenAccounttab = By.xpath("//button[@ng-click=\"openAccount()\"]");
    private final By Customersbtn = By.xpath("//button[@ng-click=\"showCust()\"]");

    //Methods to interact
    public BankManagerLoginPage(WebDriver driver) {
        super(driver);
    }


    @Step("Open Bank Manager Login Page")
    public BankManagerLoginPage clickBankManagerloginbutton() {
        bot.clickElementUsingJavaScript(Bankmanagerloginbtn);
        return new BankManagerLoginPage(driver);
    }

    @Step("Open Add Customer Page")
    public AddCustomerPage clickAddCustomertab() {
        bot.clickElementUsingJavaScript(AddCustmertab);
        return new AddCustomerPage(driver);
    }

    @Step("Open Create account Page")
    public CreateAccountPage clickOpenAccountTab() {
        bot.clickElementUsingJavaScript(OpenAccounttab);
        return new CreateAccountPage(driver);
    }

    @Step("Open Customers Page")
    public CustomersPage openCustomersPage() {
        bot.click(Customersbtn);
        return new CustomersPage(driver);
    }


}

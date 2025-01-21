package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    //Locators
    private final By BankingPage = By.xpath("//a[@href=\"https://www.way2automation.com/angularjs-protractor/banking\"]//h2[text()=\"Banking\"]");


//Methods to interact

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Step("Open Banking Page")
    public BankManagerLoginPage openBankingPage() {
        bot.click(BankingPage);
        bot.switchToNewTab();
        return new BankManagerLoginPage(driver);
    }

}

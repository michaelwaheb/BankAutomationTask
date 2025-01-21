package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import utils.Functions;

import java.io.IOException;

public class BaseTest {
    WebDriver driver;


    @BeforeClass
    public void setup() {
        driver = new ChromeDriver();
        // Navigate to a website
        driver.navigate().to("https://www.way2automation.com/protractor-angularjs-practice-website.html");
        //Mazimize current window
        driver.manage().window().maximize();
    }

    @AfterClass
    public void terminate() {

        driver.quit();

//Start then stop Allure serve after test finish
        try {
            Functions.startAndStopAllureServe();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }


}


package engine;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;

import java.util.List;
import java.util.Random;

public class Bot {
    private final WebDriver driver;
    private final Wait<WebDriver> wait;
    private Alert alert;

    public Bot(WebDriver driver, Wait<WebDriver> wait) {
        this.driver = driver;
        this.wait = wait;
    }

    // Method to select a random option from the dropdown
    public static void selectRandomOption(WebElement dropdownElement) {
        Select select = new Select(dropdownElement); // Create Select object
        List<WebElement> options = select.getOptions(); // Get all options in the dropdown
        int randomIndex = new Random().nextInt(options.size() - 1) + 1; // Get random index (skip the first empty option)
        select.selectByIndex(randomIndex); // Select the option by random index
    }

    public void click(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator));
        driver.findElement(locator).click();

    }

    public void switchToNewTab() {
        // Store the current window handle
        String currentWindow = driver.getWindowHandle();

        // Switch to the new tab
        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(currentWindow)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
    }

    // Wait for the alert to be present
    public Bot waitForAlert() {
        wait.until(ExpectedConditions.alertIsPresent());
        this.alert = driver.switchTo().alert();
        return this;
    }

    // Get the text from the alert
    public String getTextFromAlert() {
        String alertText = alert.getText();
        System.out.println("Alert text: " + alertText);
        return alertText;
    }

    // Accept the alert
    public void acceptAlert() {
        alert.accept();
    }

    public void clickElementUsingJavaScript(By locator) {
        WebElement elemnet = wait.until(ExpectedConditions.elementToBeClickable(locator));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", elemnet);
    }

    public String gettext(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return driver.findElement(locator).getText();


    }

    public void filldata(By locator, String data) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        driver.findElement(locator).sendKeys(data);
    }

    public boolean isElementPresent(By locator) {
        try {
            driver.findElement(locator);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void simpleWait(int waitTimeInSeconds) {
        try {
            Thread.sleep(waitTimeInSeconds * 1000); // Convert seconds to milliseconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

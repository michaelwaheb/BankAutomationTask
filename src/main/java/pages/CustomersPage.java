package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.util.List;


public class CustomersPage extends BasePage {

    //Locators
    private final By CustomersTablerow = By.xpath("//tr[contains(@ng-repeat,\"cust in Customers\")]");
    private final By CustomersTablecloumn = By.tagName("td");
    private final By Deletebtn = By.xpath("//button[text()=\"Delete\"]");


    //Methods to interact
    public CustomersPage(WebDriver driver) {
        super(driver);
    }

    // Shared method to retrieve the last row and its data
    private List<WebElement> getLastRowColumns() {
        // Wait for the table rows to be visible
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(CustomersTablerow));
        // Extract all rows of the table
        List<WebElement> rows = driver.findElements(CustomersTablerow);

        if (rows.isEmpty()) {
            throw new NoSuchElementException("No rows found in the Customers table.");
        }

        // Get the last row
        WebElement lastRow = rows.get(rows.size() - 1);

        // Return all columns of the last row
        return lastRow.findElements(CustomersTablecloumn);
    }

    public String LastCustomerDataRegistered() {

        // The last row should contain the last entered customer
        List<WebElement> columns = getLastRowColumns();


        int lastRowIndex = driver.findElements(CustomersTablerow).size();
        String ID = String.valueOf(lastRowIndex);
        System.out.println("User Order from the list: " + ID);

        // Concatenate the first and second names from the last row into a single string
        String lastRowData = ID + " FirstName: " + columns.get(0).getText() + " SecondName: " + columns.get(1).getText() + " PostalCode: " + columns.get(2).getText();
        System.out.println("Expected Result: " + lastRowData);
        return lastRowData;
    }

    public String LastCustomerNameRegistered() {
        // The last row should contain the last entered customer
        List<WebElement> columns = getLastRowColumns();

        // Concatenate the first and second names from the last row into a single string
        String CustomerName = columns.get(0).getText() + " " + columns.get(1).getText();

        return CustomerName;
    }

    public String LastCustomerAccountRegistered() {
        // The last row should contain the last entered customer
        List<WebElement> columns = getLastRowColumns();

        // Concatenate the first and second names from the last row into a single string
        String CustomerAccount = columns.get(3).getText();
        System.out.println("Expected Account Result: " + CustomerAccount);
        return CustomerAccount;
    }

    @Step("Delete Customer record")
    public CustomersPage deleteCustomerRecord(String CustomerAccount) {
        // Wait for the table rows to be visible
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(CustomersTablerow));
        // Extract all rows of the table
        List<WebElement> rows = driver.findElements(CustomersTablerow);
        // Iterate through the rows to find the matching data
        for (WebElement row : rows) {
            // Find all columns in the current row
            List<WebElement> columns = row.findElements(CustomersTablecloumn);

            // Check if the row contains the specified first and last name
            if (columns.get(3).getText().equals(CustomerAccount)) {
                // Locate the delete button in the matching row
                WebElement deleteButton = row.findElement(By.xpath(".//button[@ng-click='deleteCust(cust)']"));

                // Click the delete button
                deleteButton.click();
            }
        }
        return new CustomersPage(driver);
    }

    @Step("Assert that Customer record deleted")
    public void assertRecordDeletedByAccountnumber(String customeraccount) {
        // Locate all rows in the customers' table
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(CustomersTablerow));
        List<WebElement> rows = driver.findElements(CustomersTablerow);

        // Flag to indicate if the customer is found
        boolean isCustomerFound = false;

        // Loop through each row and check if the customer is present
        for (WebElement row : rows) {
            List<WebElement> columns = row.findElements(CustomersTablecloumn);
            String Account = columns.get(3).getText();

            if (Account.equals(customeraccount)) {
                isCustomerFound = true;
                break;
            }
        }

        // Assert that the customer is not found
        Assert.assertFalse(isCustomerFound, "Customer with Account number " + customeraccount + " is still present in the table!");
    }


}

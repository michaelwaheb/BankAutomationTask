package resources;

import models.CustomerData;
import org.testng.annotations.DataProvider;

public class TestData {
    //Customer details
    @DataProvider(name = "CustomerData")
    public Object[][] Customerdetails() {
        return new Object[][]{
                {new CustomerData("Michael", "Waheb", "119")}
        };


    }
}



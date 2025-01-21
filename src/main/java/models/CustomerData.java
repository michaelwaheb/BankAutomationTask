package models;

public class CustomerData {
    private String firstName;
    private String secondName;
    private String postalCode;


    //Constructor
    public CustomerData(String firstName, String secondName, String postalCode) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.postalCode = postalCode;

    }

    //Getters
    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public String getPostalCode() {
        return postalCode;
    }

}

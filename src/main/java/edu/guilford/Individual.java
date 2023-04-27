package edu.guilford;

public class Individual {
    // three attributes for name, email, and phone
    private String name;
    private String email;
    private String phone;
    private String address;
    private String date;

    // constructor
    public Individual() {
        // set name to "John Doe"
        name = "";
        // set email to "jdoe@guilford"
        email = "";
        // set phone to "555-555-5555"
        phone = "";
        // set address
        address = "";
        // set date
        date = "";
    }

    // Constructor that takes three String parameters
    public Individual(String name, String email, String phone, String address, String date) {
        // set name to the name parameter
        this.name = name;
        // set email to the email parameter
        this.email = email;
        // set phone to the phone parameter
        this.phone = phone;
        // set address to the address parameter
        this.address = address;
        // set date to the date parameter
        this.date = date;
    }

    // getters and setters
    // getName
    public String getName() {
        // return name
        return name;
    }

    // setName
    public void setName(String name) {
        // set name to the name parameter
        this.name = name;
    }

    // getEmail
    public String getEmail() {
        // return email
        return email;
    }

    // setEmail
    public void setEmail(String email) {
        // set email to the email parameter
        this.email = email;
    }

    // getPhone
    public String getPhone() {
        // return phone
        return phone;
    }

    // setPhone
    public void setPhone(String phone) {
        // set phone to the phone parameter
        this.phone = phone;
    }

    // getAddress
    public String getAddress() {
        // return address
        return address;
    }

    // setAddress
    public void setAddress(String address) {
        // set address to the address parameter
        this.address = address;
    }

    // getDate
    public String getDate() {
        // return date
        return date;
    }

    // setDate
    public void setDate(String date) {
        // set date to the date parameter
        this.date = date;
    }

    // toString
    @Override
    public String toString() {
        // return a String representation of the object
        return "Name: " + name + "\nEmail: " + email + "\nPhone: " + phone + "\nAddress: " + address;
    }
}

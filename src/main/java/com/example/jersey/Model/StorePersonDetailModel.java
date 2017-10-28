package com.example.jersey.Model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class StorePersonDetailModel {

    private long id;
    private String firstName;
    private String lastName;
    private String gender;
    private String address;
    private String pincode;
    private String contactNumber;

    public StorePersonDetailModel() {

    }

    public StorePersonDetailModel(long id, String firstName, String lastName,
                                  String gender, String address, String pincode, String contactNumber) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.address = address;
        this.pincode = pincode;
        this.contactNumber = contactNumber;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    @Override
    public String toString() {
        return "StorePersonDetailModel [id=" + id + ", firstname=" + firstName + ", lastname=" + lastName +
                ", gender=" + gender + ", address=" + address + ", pincode=" + pincode + ", contact number=" + contactNumber + "]";
    }
}

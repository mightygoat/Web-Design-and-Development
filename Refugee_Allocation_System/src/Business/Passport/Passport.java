/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Passport;

import Business.Country.Country;
import Business.Person.Gender;
import java.util.Date;

/**
 *
 * @author Rohan
 */
public class Passport {
    private String firstName;
    private String lastName;
    private String passportNumber;
    
    private String addressLine1;
    private String addressLine2;
    private String cityName;
    private String pincode;
    
    private Country countryOfIssue;
    
    private Date dateofIssue;
    private int duration;
    
    private Gender gender;

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

    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public Country getCountryOfIssue() {
        return countryOfIssue;
    }

    public void setCountryOfIssue(Country countryOfIssue) {
        this.countryOfIssue = countryOfIssue;
    }

    public Date getDateofIssue() {
        return dateofIssue;
    }

    public void setDateofIssue(Date dateofIssue) {
        this.dateofIssue = dateofIssue;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }
}

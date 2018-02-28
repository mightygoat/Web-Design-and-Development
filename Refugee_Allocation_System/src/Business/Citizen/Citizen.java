/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Citizen;


import Business.Country.Country;
import Business.Passport.Passport;
import Business.Person.Gender;
import Business.Person.Person;
import Business.VitalSigns.VitalSignsHistory;
import java.util.Date;

/**
 *
 * @author Manish
 */
public class Citizen extends Person{
    private String firstName;
    private String lastName;
    private Date dateOfBirth;
    private String address1;
    private String address2;
    private VitalSignsHistory vitalSignsHistory;
    private Passport passport;
    private Gender gender;
    private Country countryOfBirth;
    
    @Override
    public String getFirstName() {
        return firstName;
    }

    @Override
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public String getLastName() {
        return lastName;
    }

    @Override
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    @Override
    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public String getAddress1() {
        return address1;
    }

    @Override
    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    @Override
    public String getAddress2() {
        return address2;
    }

    @Override
    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    @Override
    public Passport getPassport() {
        return passport;
    }

    @Override
    public void setPassport(Passport passport) {
        this.passport = passport;
    }

    @Override
    public Gender getGender() {
        return gender;
    }

    @Override
    public void setGender(Gender gender) {
        this.gender = gender;
    }
    
    @Override
    public Country getCountryOfBirth() {
        return countryOfBirth;
    }
    
    @Override
    public void setCountryOfBirth(Country countryOfBirth){
        this.countryOfBirth = countryOfBirth;
    }
    
    public VitalSignsHistory getVitalSignsHistory() {
        return vitalSignsHistory;
    }

    
    public void setVitalSignsHistory(VitalSignsHistory vitalSignsHistory) {
        this.vitalSignsHistory = vitalSignsHistory;
    }
}

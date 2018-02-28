/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.EcoSystem;

import Business.Citizen.Citizen;
import Business.Citizen.CitizenDirectory;
import Business.Country.Country;
import Business.Passport.Passport;
import Business.Person.Gender;
import Business.Person.Person;
import Business.Refugee.Refugee;
import Business.Refugee.RefugeeBatch;
import Business.Refugee.RefugeeDirectory;
import java.util.Date;

/**
 *
 * @author Rohan
 */
public class EcoSystemRepresentative extends Person{
    private String firstName;
    private String lastName;
    private Date dateOfBirth;
    private String address1;
    private String address2;
    private Passport passport;
    private Gender gender;
    private Country countryOfBirth;
    
    //private RefugeeDirectory reportCitizenAsRefugee;
    private RefugeeDirectory inwardRefugees;
    private CitizenDirectory citizenDirectory;
    private CitizenDirectory citizensToBeSent;
    
    private EcoSystemRefugeeRegistration unitedNationsRefugeeRegistration;
    
    
    public EcoSystemRepresentative() {
        citizenDirectory = new CitizenDirectory();
        inwardRefugees = new RefugeeDirectory();
        citizensToBeSent = new CitizenDirectory();
        unitedNationsRefugeeRegistration = new EcoSystemRefugeeRegistration();
    }
    
    public Refugee addRefugee() {
        Refugee refugee = new Refugee();
        inwardRefugees.addRefugee(refugee);
        return refugee;
    }
    
    
    public void reportRefugee(Country country, CitizenDirectory citizenDirectory){ 
        for(int i = 0 ; i < 20 ; i++) {
            Citizen citizen = citizenDirectory.addCitizen();
            citizen.setFirstName("FN:" + i);
            citizen.setFirstName("LN:" + i);
            citizen.setAddress1("Add1:" + i);
            citizen.setAddress2("Add2:" + i);
            citizen.setCountryOfBirth(new Country("Syria"));
            Passport passport = new Passport();
            passport.setPassportNumber("Ps" + i);
            citizen.setPassport(passport);
        }
        unitedNationsRefugeeRegistration.registerCitizenAsRefugee(country,
                citizenDirectory);
    }
    
    public RefugeeBatch requestRefugees(int index) {
        //unitedNationsRefugeeRegistration.
        return unitedNationsRefugeeRegistration.requestRefugeeBatchAllocation(index);
    }
    
    
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
}
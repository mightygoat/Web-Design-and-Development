/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.CountryHead;

import Business.Country.Country;
import Business.Passport.Passport;
import Business.Person.Gender;
import Business.Person.Person;
import Business.Refugee.RefugeeBatch;
import Business.Refugee.RefugeeDirectory;
import Business.EcoSystem.EcoSystemRepresentative;
import java.util.Date;


/**
 *
 * @author 
 */
public class CountryHead2 extends Person{
    
    private int id;
    private static int count = 1;
    
    private String firstName;
    private String lastName;
    private Date dateOfBirth;
    private String address1;
    private String address2;
    private Passport passport;
    private Gender gender;
    private Country countryOfBirth;
    private EcoSystemRepresentative unitedNationsRepresentative;

    public CountryHead2() {
        id = count;
        count++;
        electUnitedNationsRepresentative();
    }

    public int getId() {
        return id;
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
    
    @Override
    public String toString(){
        return this.firstName;
    }
    public EcoSystemRepresentative getUnitedNationsRepresentative() {
        return unitedNationsRepresentative;
    }

    public void setUnitedNationsRepresentative(EcoSystemRepresentative 
            unitedNationsRepresentative) {
        this.unitedNationsRepresentative = unitedNationsRepresentative;
    }
    
    public void electUnitedNationsRepresentative() {
        unitedNationsRepresentative = new 
            EcoSystemRepresentative();
        
        unitedNationsRepresentative.setFirstName("UNRep FN");
        unitedNationsRepresentative.setLastName("UNRep LN");
        unitedNationsRepresentative.setPassport(new Passport());
        unitedNationsRepresentative.setAddress1("UNrep Ad1");
        unitedNationsRepresentative.setAddress2("UNrep Ad2");
        unitedNationsRepresentative.setCountryOfBirth(countryOfBirth);
    }
    
    public RefugeeDirectory requestRefugees(int index) {
        RefugeeBatch refugeeBatch = unitedNationsRepresentative.requestRefugees(index);
        return refugeeBatch.getRefugeeDirectory();
        
    }
}

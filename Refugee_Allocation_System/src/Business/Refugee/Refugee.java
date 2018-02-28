/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Refugee;
import Business.Education.Education;
import Business.Finance.Finance;
import Business.Passport.Passport;
import Business.VitalSigns.VitalSignsHistory;
import Business.Citizen.Citizen;
import Business.Country.Country;
import Business.Person.Gender;
import Business.Person.Person;
import java.util.Date;

/**
 *
 * @author 
 */
public class Refugee extends Person{
    private int id;
    private Finance finance;
    private Education education;
    private Citizen citizenship;
    
    private String firstName;
    private String lastName;
    private Date dateOfBirth;
    private String address1;
    private String address2;
    private VitalSignsHistory vitalSignsHistory;
    private Passport passport;
    private Gender gender;
    private Country countryOfBirth;
    
    private static int count = 1;

    public Refugee() {
        id = count;
        count++;
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

    
    public VitalSignsHistory getVitalSignsHistory() {
        return vitalSignsHistory;
    }

    
    public void setVitalSignsHistory(VitalSignsHistory vitalSignsHistory) {
        this.vitalSignsHistory = vitalSignsHistory;
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Person;

import Business.Country.Country;
import Business.Passport.Passport;
import Business.VitalSigns.VitalSignsHistory;
import java.util.Date;

/**
 *
 * @author Rohan
 */
public abstract class Person {
    
    private String firstName;
    private String lastName;
            
    
    public abstract String getFirstName();
    public abstract void setFirstName(String firstName);
    
    public abstract String getLastName();
    public abstract void setLastName(String lastName);
    
    public abstract Date getDateOfBirth();
    public abstract void setDateOfBirth(Date dateOfBirth);
    
    public abstract String getAddress1();
    public abstract void setAddress1(String address1);
    
    public abstract String getAddress2();
    public abstract void setAddress2(String address2);
    
    
    public abstract Passport getPassport();
    public abstract void setPassport(Passport passport);
    
    public abstract Gender getGender();
    public abstract void setGender(Gender gender);
    
    public abstract Country getCountryOfBirth();
    public abstract void setCountryOfBirth(Country country);
    
    public String getName() {
        return firstName + " " + lastName;
    }
}

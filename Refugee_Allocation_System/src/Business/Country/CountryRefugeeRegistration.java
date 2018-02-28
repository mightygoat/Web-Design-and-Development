/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Country;

import Business.Citizen.Citizen;
import Business.Citizen.CitizenDirectory;
import Business.Country.Country;
import Business.Passport.Passport;
import Business.Person.Gender;
import Business.Refugee.Refugee;
import Business.Refugee.RefugeeDirectory;
import Business.VitalSigns.VitalSigns;
import Business.VitalSigns.VitalSignsHistory;
import java.util.Date;

/**
 *
 * @author Rohan
 */
public class CountryRefugeeRegistration {
    
    private RefugeeDirectory refugeeDirectory;
    
    private int id;
    private static int count = 1;
    
    public void initializeRegistration() {
        id = count;
        count++;
    }
    
    public RefugeeDirectory registerCitizenAsRefugee(CitizenDirectory citizens) {
        RefugeeDirectory refugeeDirectory = new RefugeeDirectory();
        
        for(Citizen citizen : citizens.getCitizensList()) {
        //Record the data for the refugees    
            Refugee refugee = new Refugee();
            refugee.setFirstName(citizen.getFirstName());
            refugee.setLastName(citizen.getLastName());
            refugee.setDateOfBirth(citizen.getDateOfBirth());
            refugee.setAddress1(citizen.getAddress1());
            refugee.setAddress2(citizen.getAddress2());
            refugee.setCountryOfBirth(citizen.getCountryOfBirth());
            
            refugee.setVitalSignsHistory(citizen.getVitalSignsHistory());
            refugee.setPassport(citizen.getPassport());
            refugee.setGender(citizen.getGender());
            
            refugeeDirectory.addRefugee(refugee);
        }
        
        return refugeeDirectory;
    }
    
    public VitalSigns conductTest(VitalSignsHistory vitalSignsHistory) {
        VitalSigns vitalSigns = vitalSignsHistory.addVitals();
        
        //
        
        return vitalSigns;
    }
}
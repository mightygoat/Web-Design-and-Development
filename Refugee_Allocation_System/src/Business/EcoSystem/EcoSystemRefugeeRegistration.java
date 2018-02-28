/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.EcoSystem;

import Business.Citizen.Citizen;
import Business.Citizen.CitizenDirectory;
import Business.Country.Country;
import Business.Refugee.Refugee;
import Business.Refugee.RefugeeBatch;
import Business.Refugee.RefugeeDirectory;
import Business.VitalSigns.VitalSigns;
import Business.VitalSigns.VitalSignsHistory;
import java.util.ArrayList;


/**
 *
 * @author Rohan
 */
public class EcoSystemRefugeeRegistration {
    
    private RefugeeDirectory refugeeDirectory;
    
    private int id;
    private static int count = 1;
    
    private ArrayList<RefugeeBatch> refugeeBatches;
    
    public void initializeRegistration() {
        id = count;
        count++;
    }
    
    public RefugeeDirectory registerCitizenAsRefugee(Country country, 
            CitizenDirectory citizens) {
        RefugeeDirectory refugeeDirectory = new RefugeeDirectory();
        for(Citizen citizen : citizens.getCitizensList()) {
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
        
        RefugeeBatch refugeeBatch = new RefugeeBatch();
        refugeeBatch.setCountry(country);
        refugeeBatch.setRefugeeDirectory(refugeeDirectory);
        refugeeBatches.add(refugeeBatch);
        return refugeeDirectory;
    }
    
    
    public CitizenDirectory registerRefugeeAsCitizen(Country country, 
            RefugeeDirectory refugeeDirectory) {
        CitizenDirectory citizenDirectory = new CitizenDirectory();
        for(Refugee refugee : refugeeDirectory.getRefugeeList()) {
            Citizen citizen = new Citizen();   
            
            //Create new passport
            //Create new address
            
            citizen.setFirstName(refugee.getFirstName());
            citizen.setLastName(refugee.getLastName());
            citizen.setDateOfBirth(refugee.getDateOfBirth());
            citizen.setAddress1(refugee.getAddress1());
            citizen.setAddress2(refugee.getAddress2());
            citizen.setCountryOfBirth(refugee.getCountryOfBirth());
            citizen.setVitalSignsHistory(refugee.getVitalSignsHistory());
            citizen.setPassport(refugee.getPassport());
            citizen.setGender(refugee.getGender());    
            
            citizenDirectory.getCitizensList().add(citizen);
        }
        return citizenDirectory;
    }
    
    public ArrayList<RefugeeBatch> requestRefugeeBatch(int index) {
        return refugeeBatches;
    }
    
    public RefugeeBatch requestRefugeeBatchAllocation(int index) {
        RefugeeBatch refugeeBatch = refugeeBatches.get(index);
        return refugeeBatch;
    }
    
    public VitalSigns conductTest(VitalSignsHistory vitalSignsHistory) {
        VitalSigns vitalSigns = vitalSignsHistory.addVitals();
        return vitalSigns;
    }
}
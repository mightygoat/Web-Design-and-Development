/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Business.Continent.Continent;
import Business.Continent.ContinentDirectory;
import Business.Country.Country;
import Business.Country.CountryDirectory;
import Business.EcoSystem.EcoSystem;

/**
 *
 * @author Rohan
 */
public class Initialization {
    
    private static ContinentDirectory continentDirectory = new ContinentDirectory();
    
    public static void createUnitedNations(EcoSystem systems) {
        createContinents(systems);
    }
    
    public static void createContinents(EcoSystem system) {
        for(int i = 0 ; i < 4 ; i++) {
            Continent continent = system.createAndAddContinent();
            continent.setName("Continent: " + i);
            createCountry(continent);
        }
    }
    
    private static void createCountry(Continent continent) {
        for(int i = 0 ; i < 4 ; i++) {
            Country country = continent.addCountry();
            country.setName("Con: " + continent.getName()+ "Country:" + i);
            country.createCabinetMinistry().addDepartments();        
        }
    }
}
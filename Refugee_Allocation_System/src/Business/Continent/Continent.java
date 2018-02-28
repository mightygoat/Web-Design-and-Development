/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Continent;

import Business.Country.Country;
import Business.Country.CountryDirectory;

/**
 *
 * @author 
 */
public class Continent {
    
    private String name;
    private CountryDirectory countryDirectory;

    public Continent() {
        countryDirectory = new CountryDirectory();
    }

    public CountryDirectory getCountryDirectory() {
        return countryDirectory;
    }
    
    public Country addCountry() {
        //Country country = new Country("");
        return countryDirectory.createAndAddCountry("");
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}

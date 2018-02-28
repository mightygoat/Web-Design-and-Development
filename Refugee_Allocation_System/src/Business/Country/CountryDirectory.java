/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Country;

import java.util.ArrayList;

/**
 *
 * @author 
 */
public class CountryDirectory {
    
    private ArrayList<Country> countryList;

    public CountryDirectory() {
        countryList = new ArrayList<>();
    }

    public ArrayList<Country> getCountryList() {
        return countryList;
    }

    public Country createAndAddCountry(String name){
        Country country = new Country(name);
        countryList.add(country);
        return country;
    }
}

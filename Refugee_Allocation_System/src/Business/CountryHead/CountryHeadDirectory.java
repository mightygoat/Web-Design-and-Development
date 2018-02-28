/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.CountryHead;

import java.util.ArrayList;

/**
 *
 * @author 
 */
public class CountryHeadDirectory {
    
    private ArrayList<CountryHead> countryHeadList;

    public CountryHeadDirectory() {
        countryHeadList = new ArrayList<>();
    }

    public ArrayList<CountryHead> getCountryHeadList() {
        return countryHeadList;
    }
    
    public CountryHead createCountryHead(String firstName, String lastName){
        CountryHead countryHead = new CountryHead();
        countryHead.setFirstName(firstName);
        countryHead.setLastName(lastName);
        countryHeadList.add(countryHead);
        return countryHead;
    }
}
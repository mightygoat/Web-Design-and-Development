/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Continent;

import java.util.ArrayList;

/**
 *
 * @author Rohan
 */
public class ContinentDirectory {
    
    private ArrayList<Continent> continents;
    
    public ContinentDirectory() {
        continents = new ArrayList<>();
    }

    public ArrayList<Continent> getContinents() {
        return continents;
    }

    public void setContinents(ArrayList<Continent> continents) {
        this.continents = continents;
    }
    
    public Continent addContinent() {
        Continent continent = new Continent();
        continents.add(continent);
        return continent;
    }
}

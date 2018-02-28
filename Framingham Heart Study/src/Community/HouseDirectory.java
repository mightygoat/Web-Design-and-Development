/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Community;

import java.util.ArrayList;

/**
 *
 * @author Rohan Jahagirdar, Bhanuja Nagore, Manish Patil
 */
public class HouseDirectory {
    
    private ArrayList<House> houses;
    
    public HouseDirectory() {
        houses = new ArrayList<>();
    }

    public ArrayList<House> getHouses() {
        return houses;
    }
    
    public House addHouse() {
        House house = new House();
        houses.add(house);
        return house;
    }
}

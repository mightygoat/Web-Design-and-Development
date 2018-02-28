/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Citizen;

import Business.Refugee.Refugee;
import java.util.ArrayList;

/**
 *
 * @author Rohan
 */
public class CitizenDirectory {
    private ArrayList<Citizen> citizenList;
    
    public CitizenDirectory() {
        citizenList = new ArrayList<>();
    }

    public ArrayList<Citizen> getCitizensList() {
        return citizenList;
    }
    
    public Citizen addCitizen(){
        Citizen citizen = new Citizen();
        citizenList.add(citizen);
        return citizen;
    }
}

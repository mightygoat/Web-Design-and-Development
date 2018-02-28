/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Refugee;

import java.util.ArrayList;

/**
 *
 * @author 
 */
public class RefugeeDirectory {
    
    private ArrayList<Refugee> refugeeList;
    
    public RefugeeDirectory() {
        refugeeList = new ArrayList<>();
    }

    public ArrayList<Refugee> getRefugeeList() {
        return refugeeList;
    }
    
    public Refugee addRefugee(Refugee refugee){
        refugeeList.add(refugee);
        return refugee;
    }
}
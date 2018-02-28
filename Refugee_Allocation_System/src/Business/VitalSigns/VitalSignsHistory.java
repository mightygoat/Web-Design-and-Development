/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.VitalSigns;

import java.util.ArrayList;

/**
 *
 * @author Rohan
 */
public class VitalSignsHistory {
   private ArrayList<VitalSigns> vitalSignHistory;
    
    public VitalSignsHistory() {
        vitalSignHistory = new ArrayList<>();
    }
            

    public ArrayList<VitalSigns> getVitalSignHistory() {
        return vitalSignHistory;
    }

    public void setVitalSignHistory(ArrayList<VitalSigns> vitalSignHistory) {
        this.vitalSignHistory = vitalSignHistory;
    }
  
    public VitalSigns addVitals()
    {
       VitalSigns vs=new VitalSigns();
       vitalSignHistory.add(vs);
       return vs;
    } 
}

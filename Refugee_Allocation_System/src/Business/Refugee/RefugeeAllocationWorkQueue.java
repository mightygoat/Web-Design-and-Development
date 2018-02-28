/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Refugee;

import Business.Citizen.Citizen;
import Business.Citizen.CitizenDirectory;
import Business.Country.Country;
import java.util.ArrayList;

/**
 *
 * @author Rohan
 */
public class RefugeeAllocationWorkQueue {
    private ArrayList<RefugeeWorkRequest> workRequestList;

    public RefugeeAllocationWorkQueue() {
        workRequestList = new ArrayList<>();
    }

    public ArrayList<RefugeeWorkRequest> getRefugeeAllocationWorkQueue() {
        return workRequestList;
    }
    
    public void reportCitizensAvailibility(Country country, CitizenDirectory citizens) {
        RefugeeWorkRequest refugeeWorkRequest = new RefugeeWorkRequest();
        refugeeWorkRequest.setSender(country);
        refugeeWorkRequest.setReceiver(null);
        refugeeWorkRequest.setStatus("Pending");
        refugeeWorkRequest.setCitizenDirectory(citizens);
        workRequestList.add(refugeeWorkRequest);
    }
    
    public void createRefugeeRequest(Country country, RefugeeWorkRequest refugeeWorkRequest) {
        //workRequestList.get
        refugeeWorkRequest.setStatus("Pending");
    }
}

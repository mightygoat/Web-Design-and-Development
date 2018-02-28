/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Patient;

import java.util.ArrayList;

/**
 *
 * @author Rohan Jahagirdar, Bhanuja Nagore, Manish Patil
 */
public class PatientDirectory {
       private ArrayList<Patient> patientDirectory;
    
    public PatientDirectory() {
        patientDirectory = new ArrayList<>();
    }

    public ArrayList<Patient> getPatientDirectory() {
        return patientDirectory;
    }

    public void setPatientDirectory(ArrayList<Patient> patientDirectory) {
        this.patientDirectory = patientDirectory;
    }
    
    public Patient addPatient()
    {
       Patient patient=new Patient();
       patientDirectory.add(patient);
       return patient;
    }
    
    
}

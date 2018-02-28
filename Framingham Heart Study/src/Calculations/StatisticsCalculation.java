/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Calculations;

import Patient.VitalSigns;
import Patient.VitalSignsHistory;
import Person.Gender;
import Person.Person;

/**
 *
 * @author Rohan Jahagirdar, Bhanuja Nagore, Manish Patil
 */
public class StatisticsCalculation {
        
    public StatisticsCalculation() {
    }

    public float getAverageRiskScore(Person person) {
        int age = person.getAge();
        boolean smoker = person.isASmoker();
        Gender gender = person.getGender();
        boolean diabetic = person.isDiabetic();
        boolean heredity = person.hasHeredityHeartDisease();
        
        VitalSignsHistory vitalSignsHistory = person.getVitalSignsHistory();
        
        float totalRiskScore = 0;
        for(VitalSigns vitalSigns : vitalSignsHistory.getVitalSignHistory()){
            double bp = vitalSigns.getBloodPressureHigh();
            
            double cholNCEP = vitalSigns.getCholestrolNCEP();
            double cholLDL = vitalSigns.getCholestrolLDL();
        
            int hered;
            int smo;
            float ratio = 1;
            int diab = 0;
            
            if (smoker == true) { // true(means=1) means smoker
                smo = 1;
            } else {
                smo = 0;
            }
            if (heredity == true) { // true(means=1) means due to Heredity
                hered = 1;
            } else {
                hered = 0;
            }

            if (cholNCEP != 0 && cholLDL != 0) {
                ratio = (float) (cholNCEP / cholLDL);
            }

            if (diabetic == true) { // true(means=1) means diabetic
                diab = 1;
            } else if (diabetic == false) {
                diab = 0;
            }
            float framinghamScore = calcFramingham(smo,hered,gender, ratio, diab, bp); 
            vitalSigns.setRiskScore(framinghamScore);
            totalRiskScore = totalRiskScore + framinghamScore;
        }
        float averageScore = totalRiskScore/vitalSignsHistory.getVitalSignHistory().size();
        return averageScore;
    }
    
    private float calcFramingham(int smo, int hered, 
        Gender gender, float ratio, int diab, double bp) {	
        double u = 0;
        //System.out.println("Ratio: "  + ratio);
        //System.out.println("Gender: " + gender);
        
        if(gender == Gender.MALE) {
            u = (0.3*bp) + (0.2 * smo) + (0.2*ratio) + 
                (0.1 * diab) + (0.1*hered) + 
                (0.1);
        } else if(gender == Gender.FEMALE) {
            u = (0.3*bp) + (0.2 * smo) + (0.2*ratio) + 
                (0.1 * diab) + (0.1*hered);
        }
        float heartRisk = (float) (u /10);
		return (float) heartRisk;
    }
}

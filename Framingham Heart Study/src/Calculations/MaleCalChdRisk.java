/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Calculations;

import Patient.VitalSigns;
import Person.Person;

/**
 *
 * @author Rohan Jahagirdar, Bhanuja Nagore, Manish Patil
 */
public class MaleCalChdRisk {
    static Integer maleLDLRisk= (Integer) 0;
    static Integer maleCholestrolRisk= (Integer) 0;
    static Person person;
    
    
    public MaleCalChdRisk(Person person) {
        this.person = person;
        
    }
    
    public static int calculateTotalLDLRisk() {
        int totalLDLScore = 0;
        VitalSigns vitalSigns = person.getVitalSignsHistory().getVitalSignHistory().get(0);
        
        totalLDLScore = totalLDLScore + getAgePoints(person.getAge());
        totalLDLScore = totalLDLScore + getLDLPoints(vitalSigns.getCholestrolLDL());
        totalLDLScore = totalLDLScore + getHDLcLDLPoints(vitalSigns.getCholestrolHDL());
        totalLDLScore = totalLDLScore + getCholestrol(vitalSigns.getCholestrolNCEP());
        totalLDLScore = totalLDLScore + getSmokingLDLPoints(person.isASmoker());
        totalLDLScore = totalLDLScore + getSmokingLDLPoints(person.isDiabetic());
        totalLDLScore = totalLDLScore + getBloodPressurePoints(vitalSigns.getBloodPressureHigh(), 
                vitalSigns.getBloodPressureLow());
        
        return totalLDLScore;
        
    }
    
    public static int calculateTotalCHOLRisk() {
        int totalCHOLScore = 0;
        VitalSigns vitalSigns = person.getVitalSignsHistory().getVitalSignHistory().get(0);
        totalCHOLScore = totalCHOLScore + getAgePoints(person.getAge());
        totalCHOLScore = totalCHOLScore + getHDLcCHOLPoints(vitalSigns.getCholestrolHDL());
        totalCHOLScore = totalCHOLScore + getSmokingCHOLPoints(person.isASmoker());
        totalCHOLScore = totalCHOLScore + getDiabecticCHOLPoints(person.isDiabetic());
        totalCHOLScore   = totalCHOLScore + getBloodPressurePoints(vitalSigns.getBloodPressureHigh(), 
                vitalSigns.getBloodPressureLow());
        
        return totalCHOLScore;      
    }
    
    public static int convertLDLIntoPercent(int totalLDLScore){
        int totalLDLPercent = 0;
        
        if(totalLDLScore < -3) {
                totalLDLPercent = -1;
        }
        else if(totalLDLScore == -2) {
                totalLDLPercent = 2;
        }
        else if(totalLDLScore == -1) {
                totalLDLPercent = 2;
        }
        else if(totalLDLScore == 0) {
                totalLDLPercent = 3;
        }
        else if(totalLDLScore == 1) {
                totalLDLPercent = 4;
        }
        else if(totalLDLScore == 2) {
                totalLDLPercent = 4;
        }
        else if(totalLDLScore == 3) {
                totalLDLPercent = 6;
        }
        else if(totalLDLScore == 4) {
                totalLDLPercent = 7;
        }
        else if(totalLDLScore == 5) {
                totalLDLPercent = 9;
        }
        else if(totalLDLScore == 6) {
                totalLDLPercent = 11;
        }
        else if(totalLDLScore == 7) {
                totalLDLPercent = 14;
        }
        else if(totalLDLScore == 8) {
                totalLDLPercent = 18;
        }
        else if(totalLDLScore == 9) {
                totalLDLPercent = 22;
        }
        else if(totalLDLScore == 10) {
                totalLDLPercent = 27;
        }
        else if(totalLDLScore == 11) {
                totalLDLPercent = 33;
        }
        else if(totalLDLScore == 12) {
                totalLDLPercent =40;
        }
        else if(totalLDLScore == 13) {
                totalLDLPercent = 47;
        }
        else if(totalLDLScore >= 14) {
                totalLDLPercent = 56;
        }

        return totalLDLPercent;

    }
    
    
    public static int convertCHOLIntoPercent(int totalCHOLScore){
        int totalCHOLPercent = 0;

        if(totalCHOLScore < -1) {
                totalCHOLPercent = 2;
        }
        else if(totalCHOLScore == 0) {
                totalCHOLPercent = 3;
        }
        else if(totalCHOLScore == 1) {
                totalCHOLPercent = 4;
        }
        else if(totalCHOLScore == 2) {
                totalCHOLPercent = 4;
        }
        else if(totalCHOLScore == 3) {
                totalCHOLPercent = 5;
        }
        else if(totalCHOLScore == 4) {
                totalCHOLPercent = 7;
        }
        else if(totalCHOLScore == 5) {
                totalCHOLPercent = 8;
        }
        else if(totalCHOLScore == 6) {
                totalCHOLPercent = 10;
        }
        else if(totalCHOLScore == 7) {
                totalCHOLPercent = 13;
        }
        else if(totalCHOLScore == 8) {
                totalCHOLPercent = 16;
        }
        else if(totalCHOLScore == 9) {
                totalCHOLPercent = 20;
        }
        else if(totalCHOLScore == 10) {
                totalCHOLPercent = 25;
        }
        else if(totalCHOLScore == 11) {
                totalCHOLPercent = 31;
        }
        else if(totalCHOLScore == 12) {
                totalCHOLPercent =37;
        }
        else if(totalCHOLScore == 13) {
                totalCHOLPercent = 45;
        }
        else if(totalCHOLScore >= 14) {
                totalCHOLPercent = 53;
        }
        
        return totalCHOLPercent;
    }   
    
    
    public static int getAgePoints(int age) {
         if( 30<age && age<35) {
            return -1;
        } else if( 35<=age && age<40) {
            return 0;
        } else if( 40<=age && age<45) {
            return 1;
        } else if( 45<=age && age<50) {
            return 2;
        } else if( 50<=age && age<55) {
            return 3;
        } else if( 55<=age && age<60) {
            return 4;
        } else if( 60<=age && age<65) {
            return 5;
        } else if( 65<=age && age<70) {
            return 6;
        } else if( 70<=age && age<75) {
            return 7;
        } else {
            System.out.println("Please enter a valid Age.");
            return 0;
        }
    }
    
    
    public static int getLDLPoints(double ldlc) {
        int score = 0;
        if(ldlc < 2.59) {
            score = -3;
        } else if( 2.6<ldlc && ldlc<4.15) {
            score = 0;
        } else if( 4.15<=ldlc && ldlc<4.93) {
            score =  1;
        } else if( 4.92< ldlc) {
            score =  2;
        } else {
            System.out.println("Please enter a valid LDL.");
            score =  0;
        }
//        System.out.println("LDL Score:" + score);
        return score;
    }
    
    
    
    public static int getHDLcLDLPoints(double hdlc) {
        int score = 0;
        if(hdlc < 0.9) {
            score = 2;
        } else if( 0.9<=hdlc && hdlc<1.17) {
            score = 1;
        } else if( 1.17<=hdlc && hdlc<1.56) {
            score = 0;
        } else if( 1.56<hdlc) {
            score = -1;
        } else {
            System.out.println("Please enter a valid HDLC LDL Points.");
            score = 0;
        }
        return score;
    }
        public static int getHDLcCHOLPoints(double hdlc) {
        int score = 0;
        if(hdlc < 0.9) {
            score = 2;
        } else if( 0.9<=hdlc && hdlc<1.17) {
            score = 1;
        } else if( 1.17<=hdlc && hdlc<1.56) {
            score = 0;
        } else if( 1.56<hdlc) {
            score = -2;
        } else {
            System.out.println("Please enter a valid HDLC CHOL Points.");
            score = 0;
        }
        return score;
    }   
    
    
    public static int getCholestrol(double cholestrol) {
        int score = 0;
        if(cholestrol < 4.14) {
            score = -3;
        } else if( 4.15<=cholestrol && cholestrol<5.18) {
            score = 0;
        } else if( 5.18<=cholestrol && cholestrol<6.22) {
            score = 1;
        } else if( 6.22<=cholestrol && cholestrol<7.25) {
            score = 2;
        } else if( 7.25<=cholestrol) {
            score = 3;
        } else {
            System.out.println("Please enter a Cholestrol.");
            score = 0;
        }
        return score;
    }
    
    public static int getSmokingLDLPoints(boolean smoker) {
        if(smoker) {
         return 2;
        } else {
            return 0;  
        }
    }
       public static int getSmokingCHOLPoints(boolean smoker) {
        if(smoker) {
         return 2;
        } else {
            return 0;  
        }
    }
    
    public static int getDiabecticLDLPoints(boolean diabectic) {
        if(diabectic) {
         return 2;
        } else {
            return 0;  
        }
    }
        public static int getDiabecticCHOLPoints(boolean diabectic) {

        if(diabectic) {
         return 2;
        } else {
            return 0;  
        }
    }
    
    
    
    private static int getBloodPressurePoints(int high, int low) {
        if(high< 120 && low< 80) {
            return 0;
        } else if(high > 120 && high<=129 && 80<=low && low<85) {
            return 0;
        } else if(high > 129 && high<=139 && 85<=low && low<90) {
            return 0;
        } else if (high > 139 && high<=159 && 90<=low && low<100) {
            return 2;
        } else if(high > 159 && low> 99) {
            return 3;
        } else {
            return 0;
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface;

/**
 *
 * @author Rohan Jahagirdar, Bhanuja Nagore, Manish Patil
 */
public class Validations {
    
    public static int ValidateAge(int age){
        if (age < 30 || age > 75){
            System.out.println("Please enter valid age between 30 to 74 ");
            return 0;
        }
        else return 1;  
    }
    
    public static int ValidateCholestrolRange(double tcholestrol){
        if( tcholestrol < 3.06 || tcholestrol > 8.05 ){
            System.out.println("Please enter valid cholestrol between 3.06 to 8.05 ");
            return 0;
        }
        else return 1;
    }
    
    public static int ValidateHDLCholestrolRange(double hdlCholestrol){
        if( hdlCholestrol < 0.40 || hdlCholestrol > 3.06 ){
            System.out.println("Please enter valid HDL cholestrol between 0.40 to 3.06 ");
            return 0;
        }
        else return 1;
    }
    
    public static int ValidateLDLCholestrolRange(double ldlCholestrol){
        if( ldlCholestrol < 1.00 || ldlCholestrol > 5.05 ){
            System.out.println("Please enter valid LDL cholestrol between 1.00 to 5.05 ");
            return 0;
        }
        else return 1;
    }
    
    public static int ValidateSystalicBloodPressure(double systalicBloodPressure){
        if( systalicBloodPressure < 100 || systalicBloodPressure > 180 ){
            System.out.println("Please enter valid systolic blood pressure between 100 to 180 ");
            return 0;
        }
        else return 1;
    }
    
    public static int ValidateDiastolicBloodPressure(double diastolicBloodPressure){
        if( diastolicBloodPressure < 70 || diastolicBloodPressure > 110 ){
            System.out.println("Please enter valid diastolic blood pressure between 70 to 110 ");
            return 0;
        }
        else return 1;
    }
    
}


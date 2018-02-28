/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface;
import Calculations.FemaleCalChdRisk;
import Calculations.MaleCalChdRisk;
import Community.Community;
import Patient.Patient;
import Patient.VitalSigns;
import Person.Gender;
import Person.PersonDirectory;
import Person.Person;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import sun.nio.cs.ext.Big5;


/**
 *
 * @author Rohan Jahagirdar, Bhanuja Nagore, Manish Patil
 */
public class ReportFunctions {
    private static Scanner scanner = new Scanner(System.in);
    private static Patient patient = new Patient();
    private static Person person = new Person();
    
    
    private static PersonDirectory personDirectory;
    public static void calculateRisk() {
        
        System.out.println("**** Enter your details to calculate risk score **** \n ");
        System.out.print(" Enter your age : ");
        int age = scanner.nextInt();
        if (Validations.ValidateAge(age) == 0){
            return;
        }    
        person.setAge(age);
        VitalSigns vitalSigns = person.addVitalSigns();
        System.out.print(" \n Enter your gender (1 for Male and 2 for Female) : ");
        int genderSelection = scanner.nextInt();
        if( genderSelection ==1 || genderSelection== 2 ) {
            switch (genderSelection) {
            case 1:
                    person.setGender(Gender.MALE);
                    break;
            case 2:                        
                   person.setGender(Gender.FEMALE);
                    break;
            default:
                    System.out.println(" Please enter a valid gender");
                    break;
            }
        } else {
            System.out.println(" Please enter a valid gender");
            return;
        }
        System.out.print(" \n Enter total cholestrol [mmol/L] : ");
        double tcholestrol = scanner.nextDouble();
        if (Validations.ValidateCholestrolRange(tcholestrol) == 0){
            return;
        }
        vitalSigns.setCholestrolNCEP(tcholestrol);
        
        System.out.print(" \n Enter HDL Cholestrol [mmol/L] : ");
        double hdlCholestrol = scanner.nextDouble();
        if (Validations.ValidateHDLCholestrolRange(hdlCholestrol) == 0){
            return;
        }
        vitalSigns.setCholestrolHDL(hdlCholestrol);
        
        System.out.print(" \n Enter LDL Cholestrol [mmol/L] : ");
        double ldlCholestrol = scanner.nextDouble();
        if (Validations.ValidateLDLCholestrolRange(ldlCholestrol) == 0){
            return;
        }
        vitalSigns.setCholestrolLDL(ldlCholestrol);
        
        scanner.nextLine();
        
        System.out.print(" \n Select option \n Smoker ( Yes[Y/y] , No[N/n] ) : ");
        String smokes = scanner.nextLine();
        if(!smokes.equalsIgnoreCase("Y") &&  !smokes.equalsIgnoreCase("N")) {
            System.out.println(" Please enter a valid input");
            return;
        }
        switch (smokes) {
            case "Y":
            case "y":                        
               person.setSmoking(true);
                break;
                
            case "N":
            case "n":                        
               person.setSmoking(false);
                break;
                
        default:
                System.out.println(" Please enter a valid option.");
                break;
        }
        
        System.out.print(" \n Select option \n Diabetes ( Yes[Y/y] , No[N/n] ) :");
        String diabetic = scanner.nextLine();
        if(!diabetic.equalsIgnoreCase("Y") &&  !diabetic.equalsIgnoreCase("N")) {
            System.out.println(" Please enter a valid input");
            return;
        }
        switch (diabetic) {
            case "Y":
            case "y":                        
               person.setDiabetes(true);
                break;
                
            case "N":
            case "n":                        
               person.setDiabetes(false);
                break;
                
        default:
                System.out.println("Please enter a valid option.");
                break;
        }
        System.out.print(" \n Enter systolic blood pressure [mm Hg] (Range: ) : ");
        int systalicBloodPressure = scanner.nextInt();
        if (Validations.ValidateSystalicBloodPressure(systalicBloodPressure) == 0){
            return;
        }
        vitalSigns.setBloodPressureHigh(systalicBloodPressure);
        
        System.out.print(" \n Enter diastolic blood pressure [mm Hg] : ");
        int diastolicBloodPressure = scanner.nextInt();
        if (Validations.ValidateDiastolicBloodPressure(diastolicBloodPressure) == 0){
            return;
        }
        vitalSigns.setBloodPressureLow(diastolicBloodPressure);
        
        System.out.print(" \n Is the patient being treated for high blood pressure? ( Yes[Y/y] , No[N/n] ) : ");
        String highBloodPressure = scanner.nextLine();
        
        System.out.println("=============================================================================== \n");
        DisplayCalculatedScore();
    }
    
    public static void DisplayCalculatedScore()
    {
        MaleCalChdRisk maleCalChdRisk = new MaleCalChdRisk(person);
        FemaleCalChdRisk femaleCalChdRisk = new FemaleCalChdRisk(person);
        
        VitalSigns vitalSigns = person.getVitalSignsHistory().getVitalSignHistory().get(0);
        //System.out.println(person.getVitalSignsHistory().getVitalSignHistory().size());
        double cholestrolNCEP = vitalSigns.getCholestrolNCEP();
        double cholestrolHDL = vitalSigns.getCholestrolHDL();
        double cholestrolLDL = vitalSigns.getCholestrolLDL();
        int bloodPresssureHigh = vitalSigns.getBloodPressureHigh();
        int bloodPresssureLow = vitalSigns.getBloodPressureLow();
        int calculatecTotalLDLRiskPercentage = 0;
        int calculatedTotalCHOLRiskPercentage = 0;
        
        System.out.printf("  %-40s| %-20s |\n","Factors","Values");
        System.out.printf("  %-40s| %-20s |\n","Age",person.getAge());
        System.out.printf("  %-40s| %-20s |\n","Gender",person.getGender());
        System.out.printf("  %-40s| %-20s |\n","Total cholestrol [mmol/L]",cholestrolNCEP);
        System.out.printf("  %-40s| %-20s |\n","HDL Cholestrol [mmol/L]",cholestrolHDL);
        System.out.printf("  %-40s| %-20s |\n","LDL Cholestrol [mmol/L]",cholestrolLDL);
        System.out.printf("  %-40s| %-20s |\n","Smoker",(person.isASmoker() == true) ? "Yes" : "No");
        System.out.printf("  %-40s| %-20s |\n","Diabetec",(person.isDiabetic()== true) ? "Yes" : "No");
        System.out.printf("  %-40s| %-20s |\n","Systolic blood pressure [mm Hg]", bloodPresssureHigh);
        System.out.printf("  %-40s| %-20s |\n","Diastolic blood pressure [mm Hg]", bloodPresssureLow);

        if(person.getGender() == Gender.MALE) {
            calculatecTotalLDLRiskPercentage = maleCalChdRisk.convertLDLIntoPercent(
                    maleCalChdRisk.calculateTotalLDLRisk());
            
            calculatedTotalCHOLRiskPercentage = maleCalChdRisk.convertCHOLIntoPercent(
                    maleCalChdRisk.calculateTotalCHOLRisk());
            
        } else if(person.getGender() == Gender.FEMALE){
            calculatecTotalLDLRiskPercentage = femaleCalChdRisk.convertLDLIntoPercent(
            femaleCalChdRisk.calculateTotalLDLRisk());
            
            calculatedTotalCHOLRiskPercentage = femaleCalChdRisk.convertCHOLIntoPercent(
            femaleCalChdRisk.calculateTotalCHOLRisk());
       
        } else {
            System.out.println("Enter a valid gender");
        }
        System.out.printf("  %-40s| %-20s |\n","Calculated LDL Risk Percentage", 
                calculatecTotalLDLRiskPercentage);
        
        System.out.printf("  %-40s| %-20s |\n","Calculated Cholestrol Risk Percentage", 
                calculatedTotalCHOLRiskPercentage);
        System.out.println("\n");
    }
    
    public static void CalculateHeartRiskForCity(ArrayList<Patient> patients)
    {
       System.out.println("Number of people having risk of getting heart disease in city: "
               + patients.size());
    }
    
    public static void PercentageHeartRiskForCity(ArrayList<Patient> patients,ArrayList<Person> persons){
        float percentage = (((float)patients.size())/ persons.size()) * 100;
        System.out.println("Percentage of people having risk of getting heart disease in city: "+
                percentage + "%");
    }
    
    public static void HeartRiskBasedOnAge(ArrayList<Patient> patients){
        int firstAgeGroup = 0;
        int secondAgeGroup = 0;
        int thirdAgeGroup = 0;
        int fourthAgeGroup = 0;
        int fifthAgeGroup = 0;
        int sixthAgeGroup = 0;
        int seventhAgeGroup = 0;
        int eighthAgeGroup = 0;
        int ninthAgeGroup = 0;
        
        
        for(Patient patient : patients) {
            int age = patient.getAge();
            if( 30<age && age<35) {
                firstAgeGroup++;
            } else if( 35<=age && age<40) {
                secondAgeGroup++;
            } else if( 40<=age && age<45) {
                thirdAgeGroup++;
            } else if( 45<=age && age<50) {
                fourthAgeGroup++;
            } else if( 50<=age && age<55) {
                fifthAgeGroup++;
            } else if( 55<=age && age<60) {
                sixthAgeGroup++;
            } else if( 60<=age && age<65) {
                seventhAgeGroup++;
            } else if( 65<=age && age<70) {
                eighthAgeGroup++;
            } else if( 70<=age && age<75) {
                ninthAgeGroup++;
            }
        }
        
        System.out.println("Number of patients from 30-34 years of age having risk of Heart Disease : " +
                firstAgeGroup);
        
        System.out.println("Number of patients from 35-39 years of age having risk of Heart Disease : " +
                secondAgeGroup);
        
        System.out.println("Number of patients from 40-44 years of age having risk of Heart Disease : " +
                thirdAgeGroup);
        
        System.out.println("Number of patients from 45-49 years of age having risk of Heart Disease : " +
                fourthAgeGroup);
        
        System.out.println("Number of patients from 50-54 years of age having risk of Heart Disease : " +
                fifthAgeGroup);
        
        System.out.println("Number of patients from 55-59 years of age having risk of Heart Disease : " +
                sixthAgeGroup);
        
        System.out.println("Number of patients from 60-64 years of age having risk of Heart Disease : " +
                seventhAgeGroup);
        
        System.out.println("Number of patients from 65-69 years of age having risk of Heart Disease : " +
                eighthAgeGroup);
        
        System.out.println("Number of patients from 70-74 years of age having risk of Heart Disease : " +
                ninthAgeGroup);
        
    }
    
    public static void CalculateHeartRiskForCommunity(ArrayList<Patient> patients){
        int c1 = 0;
        int c2 = 0;
        int c3 = 0;
        int c4 = 0;
        int c5 = 0;
        int c6 = 0;
        int c7 = 0;
        int c8 = 0;
        int c9 = 0;
        int c10 = 0;
        
        for(Patient patient : patients) {
            int communityId = patient.getCommunityId();
           switch(communityId) {
               case 0:
                   c1++;
                   break;
                case 1:
                   c2++;
                   break;
                case 2:
                   c3++;
                   break;
                case 3:
                   c4++;
                   break;
                case 4:
                   c5++;
                   break;
                case 5:
                   c6++;
                   break;
                case 6:
                   c7++;
                   break;
                case 7:
                   c8++;
                   break;
                case 8:
                   c9++;
                   break;
                case 9:
                   c10++;
                   break;
                default :
                    break;
           }
        }  
           
           System.out.println("Number of patients from First Community having risk of Heart Disease : " +
                c1);
           
           System.out.println("Number of patients from Second Community having risk of Heart Disease : " +
                c1);
           
           System.out.println("Number of patients from Third Community having risk of Heart Disease : " +
                c2);
           
           System.out.println("Number of patients from Fourth Community having risk of Heart Disease : " +
                c3);
           
           System.out.println("Number of patients from Fifth Community having risk of Heart Disease : " +
                c4);
           
           System.out.println("Number of patients from Sixth Community having risk of Heart Disease : " +
                c5);
           
           System.out.println("Number of patients from Seventh Community having risk of Heart Disease : " +
                c6);
           
           System.out.println("Number of patients from Eighth Community having risk of Heart Disease : " +
                c7);
           
           System.out.println("Number of patients from Ninth Community having risk of Heart Disease : " +
                c8);
           
           System.out.println("Number of patients from Tenth Community having risk of Heart Disease : " +
                c9);
           
        
    }
    
    public static void PercentageHeartRiskForCommunity(ArrayList<Patient> patients) {
        int c1 = 0;
        int c2 = 0;
        int c3 = 0;
        int c4 = 0;
        int c5 = 0;
        int c6 = 0;
        int c7 = 0;
        int c8 = 0;
        int c9 = 0;
        int c10 = 0;
        
        for(Patient patient : patients) {
            int communityId = patient.getCommunityId();
           switch(communityId) {
               case 0:
                   c1++;
                   break;
                case 1:
                   c2++;
                   break;
                case 2:
                   c3++;
                   break;
                case 3:
                   c4++;
                   break;
                case 4:
                   c5++;
                   break;
                case 5:
                   c6++;
                   break;
                case 6:
                   c7++;
                   break;
                case 7:
                   c8++;
                   break;
                case 8:
                   c9++;
                   break;
                case 9:
                   c10++;
                   break;
                default :
                    break;
           }
           
        }  
           
        int totalPatientsCount  = c1 + c2 + c3 + c4 + c5 + c6 + c7 + c8 + c9 + c10;
        
        
        System.out.println("Percentage of patients in First Community to Total Patients:  " + 
                ((float)c1/totalPatientsCount)*100 + "%");
        
        System.out.println("Percentage of patients in Second Community to Total Patients:  " + 
                ((float)c2/totalPatientsCount)*100 + "%");
        
        System.out.println("Percentage of patients in Third Community to Total Patients:  " + 
                ((float)c3/totalPatientsCount)*100 + "%");
        
        System.out.println("Percentage of patients in Fourth Community to Total Patients:  " + 
                ((float)c4/totalPatientsCount)*100 + "%");
        
        System.out.println("Percentage of patients in Fifth Community to Total Patients:  " + 
                ((float)c5/totalPatientsCount)*100 + "%");
        
        System.out.println("Percentage of patients in Sixth Community to Total Patients:  " + 
                ((float)c6/totalPatientsCount)*100 + "%");
        
        System.out.println("Percentage of patients in Seventh Community to Total Patients:  " + 
                ((float)c7/totalPatientsCount)*100 + "%");
        
        System.out.println("Percentage of patients in Eighth Community to Total Patients:  " + 
                ((float)c8/totalPatientsCount)*100 + "%");
        
        System.out.println("Percentage of patients in Ninth Community to Total Patients:  " + 
                ((float)c9/totalPatientsCount)*100 + "%");
        
        System.out.println("Percentage of patients in Tenth Community to Total Patients:  " + 
                ((float)c10/totalPatientsCount)*100 + "%");
        
        
    }
    
    
    
    public static void CalculateHeartRiskForHouse(ArrayList<Patient> patients){
        int[][] housePatients = new int[10][10];
        for(int i = 1 ; i < 10 ; i++) {
            for(int j = 1 ; j < 10 ; j++) {
                housePatients[i][j] = 0;
            }
        }
        
        
        for(Patient patient : patients) {    
            housePatients[patient.getCommunityId()][patient.getHouseId()]++;
        }  
        
        for(int i = 0 ; i < 10 ; i++) {
            System.out.println("Community: " + (int)(i + 1));
            for(int j = 0 ; j < 10 ; j++) {
                System.out.println(" No of patients in House:" + (int)(j + 1)+ 
                        " having heart disease:" + housePatients[i][j]);
            }
        }
        
    }
    
    public static void PercentageHeartRiskForHouse(ArrayList<Patient> patients) {
        int h1 = 0;
        int h2 = 0;
        int h3 = 0;
        int h4 = 0;
        int h5 = 0;
        int h6 = 0;
        int h7 = 0;
        int h8 = 0;
        int h9 = 0;
        int h10 = 0;
        
        
        int[][] housePatients = new int[10][10];
        for(int i = 0 ; i < 10 ; i++) {
            for(int j = 1 ; j < 10 ; j++) {
                housePatients[i][j] = 0;
            }
        }
        
        
        for(Patient patient : patients) {    
            housePatients[patient.getCommunityId()][patient.getFamilyId()]++;
        }  
        
        for(int i = 0 ; i < 10 ; i++) {
            System.out.println("Community:" + i);
            for(int j = 0 ; j < 10 ; j++) {
                System.out.println(" House:" + j+ " Patients:" + housePatients[i][j]);
            }
        }
           
        int totalPatientsCount  = h1 + h2 + h3 + h4 + h5 + h6 + h7 + h8 + h9 + h10;
        
        
        System.out.println("Percentage of patients in First Community to Total Patients:  " + 
                ((float)h1/totalPatientsCount)*100 + "%");
        
        System.out.println("Percentage of patients in Second Community to Total Patients:  " + 
                ((float)h2/totalPatientsCount)*100 + "%");
        
        System.out.println("Percentage of patients in Third Community to Total Patients:  " + 
                ((float)h3/totalPatientsCount)*100 + "%");
        
        System.out.println("Percentage of patients in Fourth Community to Total Patients:  " + 
                ((float)h4/totalPatientsCount)*100 + "%");
        
        System.out.println("Percentage of patients in Fifth Community to Total Patients:  " + 
                ((float)h5/totalPatientsCount)*100 + "%");
        
        System.out.println("Percentage of patients in Sixth Community to Total Patients:  " + 
                ((float)h6/totalPatientsCount)*100 + "%");
        
        System.out.println("Percentage of patients in Seventh Community to Total Patients:  " + 
                ((float)h7/totalPatientsCount)*100 + "%");
        
        System.out.println("Percentage of patients in Eighth Community to Total Patients:  " + 
                ((float)h8/totalPatientsCount)*100 + "%");
        
        System.out.println("Percentage of patients in Ninth Community to Total Patients:  " + 
                ((float)h9/totalPatientsCount)*100 + "%");
        
        System.out.println("Percentage of patients in Tenth Community to Total Patients:  " + 
                ((float)h10/totalPatientsCount)*100 + "%");
        
        
    }
    
    public static void CalculateHeartRiskForFamily(ArrayList<Patient> patients) {
        System.out.println("Please enter a community id:(1-10)");
        int communityOption = scanner.nextInt();
        if(communityOption < 1 || communityOption > 10) {
            System.out.println("Please enter a valid input.");
            
            return;
        }
        
        
        System.out.println("Please enter a House id:(1-10)");
        int houseOption = scanner.nextInt();
        if(houseOption < 1 || houseOption > 10) {
            System.out.println("Please enter a valid input.");
            
            return;
        }
        
        
        System.out.println("Please enter a Family id:(1-6)");
        int familyOption = scanner.nextInt();
        if(familyOption > 6 || familyOption < 1) {
            System.out.println("Please enter a valid input.");
            return;
        } 
        
        
        int[][][] housePatients = new int[10][10][6];
        for(int i = 0 ; i < 10 ; i++) {
            for(int j = 0 ; j < 10 ; j++) {
                for(int k = 0 ; k < 6 ; k++) {
                    housePatients[i][j][k] = 0;
                }
            }
        }
        
        
        for(Patient patient : patients) {    
            housePatients[patient.getCommunityId()][patient.getHouseId()]
                    [patient.getFamilyId()]++;
        } 
        
        System.out.println("No of members of selected family having heart diease is: "
            + housePatients[communityOption-1][houseOption-1][familyOption-1]);
        
        
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface;

import Calculations.MaleCalChdRisk;
import Calculations.StatisticsCalculation;
import Community.Community;
import Community.Family;
import Community.FraminghamTown;
import Community.House;
import Patient.Patient;
import Patient.VitalSigns;
import Patient.VitalSignsHistory;
import Person.Gender;
import Person.Person;
import Person.PersonDirectory;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Rohan Jahagirdar, Bhanuja Nagore, Manish Patil
 */
public class Initialization {
    //private static ArrayList<String> listPersonsNames;
    private static ArrayList<String> listPersonsLastNames;
    private static ArrayList<String> listPersonsFirstNames;
    
    private static Random random = new Random();
    private static FraminghamTown framinghamTown;
    
    private static HashMap<Integer, Patient> personIdToPatientMap;
    private static ArrayList<Person> citizens;
    private static ArrayList<Patient> patients;
    
    private static StatisticsCalculation statisticsCalculation;
    
    private static Scanner scanner = new Scanner(System.in);
    
//    private ReportFunctions reportFunctions;
    
    
    public static void initializeResearch() {
        listPersonsFirstNames = new ArrayList<>();
        listPersonsLastNames =  new ArrayList<>();
        personIdToPatientMap = new HashMap<>();
        
        statisticsCalculation = new StatisticsCalculation();
        
    //    reportFunctions = new ReportFunctions();
                
        patients = new ArrayList<>();
        citizens = new ArrayList<>();
        createCommunityPersons();
        framinghamTown = new FraminghamTown();
        framinghamTown.getCommunityDirectory();  
    
        for(int i = 0 ; i < 10 ; i++) {
            Community community = framinghamTown.addCommunity();
            community.setCommunityName("C-" + i);
            populateCommunity(community);
        }
    //    printInformation();
        populatePatients();
    //    printPatients();
    
        displayReportChoices();
    
    }
    
    
    private static void displayReportChoices() {
        System.out.println("Select Option");
        System.out.println("1. City Level ");
        System.out.println("2. Community Level ");
        System.out.println("3. House Level ");
        System.out.println("4. Family Level ");
        System.out.println("0. Exit \n ");
        System.out.print(" Enter options : ");
        int option = scanner.nextInt();
        if (option < 0 || option > 4) {
                System.out.println(" Please enter valid option \n");
                return;
            }

        if (option == 0)
            {
                return;
            }
        
        switch(option)
        {
            case 1 :    DisplayCityLevelOptions();
                        break;
                        
            case 2 :    DisplayCommunityLevelOptions();
                        break;
            
            case 3 :    DisplayHouseLevelOptions();
                        break;
            
            case 4 :    DisplayFamilyLevelOptions();
                        break;
            default:    break;
        }
    }
    
    public static void populateCommunity(Community community) {
        for(int i = 0 ; i < 10 ; i++) {
            House house = community.getHouses().addHouse();
            house.setAddress1("address1-" + i);
            house.setAddress2("address2-" + i);
            house.setCity("City" + i);
            house.setCountry("Country" + i);
            populateHouse(house, i);
        }
    //    return community;
    }
    
    public static void populateHouse(House house, int communityIdentifier) {
        for(int i = 0 ; i < 3 ; i++) {
            Family family = house.getFamilies().addFamily();
            family.setFamilyName(listPersonsLastNames.get(random.
                                           nextInt(listPersonsLastNames.
                                                   size())));
            populateFamily(family, communityIdentifier, i);
        }
    //    return house;
    }
    
    public static void populateFamily(Family family, int communityIdentifier, 
            int houseIdentifier ) {
        
        boolean heredity =  random.nextInt(10) == 0;
        for(int i = 0 ; i < 6 ; i++) {
            citizens.add(createRandomPerson(family, 
                            family.getPersonDirectory().
                                    addPerson(), heredity, communityIdentifier,
                                    houseIdentifier, i));
        }
    }
    
    public static Person createRandomPerson(Family family, Person person,
        boolean heredity, int communityIdentifier, 
            int houseIdentifier,int familyIndentifier) {
        
        String firstName = listPersonsFirstNames.get(random.
                                           nextInt(listPersonsFirstNames.
                                                   size()));
        
        String lastName = family.getFamilyName();
        int age = random.nextInt(60) + 15;
        Gender gender = (random.nextInt(1) == 0) ?  Gender.MALE : Gender.FEMALE;
        
        person.setFirstName(firstName);
        person.setLastName(lastName);
        person.setDateOfBirth(getDateOfBirth(age));
        person.setId(Person.getCount());
        setGenealogicalStatus(person);
        
        person.setGender(gender);
        person.setAge(age);
        
        person.setDiabetes(random.nextInt(2) == 0);
        person.setSmoking(random.nextInt(2) == 0);
        person.setHasHeartDiease(random.nextInt(10) == 0);
        
        Date currentDate = Calendar.getInstance().getTime();
        int currentYear = 2016;
        
        for(int i = 0 ; i < 6 ; i++) {
            double cholestrolNCEP = (random.nextInt(230) + 120);
            double cholestrolLDL = random.nextInt(170) + 80;
            double cholestrolHDL = random.nextInt(60) + 20;
            
            int bloodPressureHigh = random.nextInt(180) + 30;
            int bloodPressureLow = random.nextInt(80) + 10;
            double temperature = 2*random.nextDouble() + 97;
            int pulse = random.nextInt(40) + 60;
            
            Calendar calendar = Calendar.getInstance();
            
            int testYear = 5 - i;
            calendar.add(Calendar.YEAR, -testYear);
            
            if(i != 5) {
                calendar.add(Calendar.MONTH, random.nextInt(11));
                calendar.add(Calendar.DAY_OF_MONTH, random.nextInt(29));
            }
            Date dateOfTest = calendar.getTime();
        
            VitalSigns vitalSigns = person.addVitalSigns();
            vitalSigns.setBloodPressureHigh(bloodPressureHigh);
            vitalSigns.setBloodPressureLow(bloodPressureLow);
            vitalSigns.setTemperature(temperature);
            vitalSigns.setPulse(pulse);
            vitalSigns.setCholestrolNCEP(cholestrolNCEP);
            vitalSigns.setCholestrolLDL(cholestrolLDL);
            vitalSigns.setCholestrolHDL(cholestrolHDL);
            vitalSigns.setDate(dateOfTest);
        }
        person.setHasHeredityHeartDisease(heredity);
        float averageRiskScore = 
        statisticsCalculation.getAverageRiskScore(person);
        
        person.setAverageRiskScore(averageRiskScore);
        
        person.setFamilyId(familyIndentifier);
        person.setCommunityId(communityIdentifier);
        person.setHouseId(houseIdentifier);
        
        return person;
    }
    
    private static void setGenealogicalStatus(Person person) {
        int age = person.getAge();
        if(0 < age && age< 20) {
            switch(person.getGender()) {
                case MALE:
                    person.setGenealogicalStatus("Grand Son");
                    break;
                case FEMALE:
                    person.setGenealogicalStatus("Grand Daughter");
                    break;
            }
        } else if(20 <= age && age< 50){
            switch(person.getGender()) {
                case MALE:
                    person.setGenealogicalStatus("Son");
                    
                    break;
                case FEMALE:
                    person.setGenealogicalStatus("Daughter");
                    break;
            }
        } else if(50 <= age){
            switch(person.getGender()) {
                case MALE:
                    person.setGenealogicalStatus("Father");
                    break;
                case FEMALE:
                    person.setGenealogicalStatus("Mother");
                    break;
            }
        } else {
            person.setGenealogicalStatus("NA.");
        }
    }
    
    private static String getDateOfBirth(int age) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.YEAR, -age);
        calendar.add(Calendar.MONTH, random.nextInt(11));
        calendar.add(Calendar.DAY_OF_MONTH, random.nextInt(29));
        
        Date yearofBirth = calendar.getTime();
        
        String dateOfBirth = new SimpleDateFormat("MM/dd/yyyy").
                format(yearofBirth);
        return dateOfBirth;
    }
    
    
    private static void populatePatients() {
        int patientCount = 1;
        for(Community community : framinghamTown.
                                    getCommunityDirectory().
                                        getCommunitites()) {
            
            for(House house : community.getHouses().getHouses()) {
                for(Family family : house.getFamilies().getFamilies()) {
                    //boolean heredity = isHeartDiseaseInFamily(family) ;
                    
                    for(Person person : family.getPersonDirectory().
                                        getPersons()) {
                        
                        float averageRiskScore = person.getAverageRiskScore();
                        
                        if(averageRiskScore > 4) {
                            Patient patient = new Patient();
                            patient.setFirstName(person.getFirstName());
                            patient.setLastName(person.getLastName());
                            patient.setAge(person.getAge());
                            patient.setDateOfBirth(person.getDateOfBirth());
                            patient.setGender(person.getGender());
                            patient.setPersonId(person.getId());
                            patient.setGenealogicalStatus(
                                        person.getGenealogicalStatus());

                            patient.setDiabetes(person.isDiabetic());
                            patient.setSmoking(person.isASmoker());
                            patient.setHasHeredityHeartDisease(
                                    person.hasHeredityHeartDisease());
                            
                            VitalSignsHistory vitalSignsHistory = person.getVitalSignsHistory();
                            patient.setVitalSignsHistory(vitalSignsHistory);
                          
                            patient.setPatientId(patientCount);
                            patient.setAverageRiskScore(averageRiskScore);
                            
                            patient.setFamilyId(person.getFamilyId());
                            patient.setCommunityId(person.getCommunityId());
                            patient.setHouseId(person.getHouseId());
                            
                            patients.add(patient);
                            personIdToPatientMap.put(person.getId(), patient);
                            
                            patientCount++;
                        }
                    }
                }
            }
        }
    }
    
    private static boolean isHeartDiseaseInFamily(Family family) {
        System.out.println("------");
        boolean heredityDiease = false;
        for(Person person : family.getPersonDirectory().getPersons()) {
            if(person.hasHeartDiease()) {
                heredityDiease = true;
                break;
            }
        }
        for(Person person : family.getPersonDirectory().getPersons()) {
            person.setHasHeredityHeartDisease(heredityDiease);
        }
        return false;
    }
    
    private static void printPatients() {
        for(Patient patient : patients) {
            System.out.println(patient.getPatientId());
            System.out.print("\t\t\t");
            System.out.println("Patient Name-" + patient.getFullName());

            System.out.print("\t\t\t");
            System.out.println("Patient  DOB-" + patient.getDateOfBirth());

            System.out.print("\t\t\t");
            System.out.println("Patient  Age-" + patient.getAge());

            System.out.print("\t\t\t");
            System.out.println("Patient GenealogicalStatus-" + 
                                patient.getGenealogicalStatus());

            System.out.print("\t\t\t");
            System.out.println("Patient Gender-" + patient.getGender());

            System.out.print("\t\t\t");
            System.out.println("Patient Id-" + patient.getPatientId());
            
            System.out.print("\t\t\t");
            System.out.println("Smoking-" + patient.isASmoker());
            
            System.out.print("\t\t\t");
            System.out.println("Diabetes-" + patient.isDiabetic());
            
            System.out.print("\t\t\t");
            System.out.println("Heredity-" + patient.hasHeredityHeartDisease());
            
            
            System.out.print("\t\t\t");
            System.out.println("Risk Score-" + patient.getAverageRiskScore());
            
            
            System.out.print("\t\t\t");
            System.out.println("---------------------------");
        }
    }
    
    
    private static void printInformation() {
        for(Community community : framinghamTown.
                                    getCommunityDirectory().
                                        getCommunitites()) {
         //-----------------------------------------------//
            System.out.println(community.getCommunityName());
            System.out.println("---------------------------");
            for(House house : community.getHouses().getHouses()) {
                System.out.print("\t");
                System.out.println(house.getAddress1() + house.getAddress2()+
                                   house.getCity() + house.getCountry());
                System.out.print("\t");
                System.out.println("---------------------------");
                
                for(Family family : house.getFamilies().getFamilies()) {
                    System.out.print("\t\t");
                    System.out.println("The " + family.getFamilyName() + "\'s");
                    
                    System.out.print("\t\t");
                    System.out.println("---------------------------");
                    
                    for(Person person : family.getPersonDirectory().
                                        getPersons()) {
                        System.out.print("\t\t\t");
                        System.out.println("Name-" + person.getFullName());
                        
                        System.out.print("\t\t\t");
                        System.out.println("DOB-" + person.getDateOfBirth());
                        
                        System.out.print("\t\t\t");
                        System.out.println("Age-" + person.getAge());
                        
                        System.out.print("\t\t\t");
                        System.out.println("GenealogicalStatus-" + 
                                            person.getGenealogicalStatus());

                        System.out.print("\t\t\t");
                        System.out.println("gender-" + person.getGender());
                        
                        
                        System.out.print("\t\t\t");
                        System.out.println("id-" + person.getId());
                        System.out.print("\t\t\t");
                        
                        System.out.println("Risk Score-" + person.getAverageRiskScore());
                        System.out.print("\t\t\t");
                        
                        
                        VitalSignsHistory vitalSignsHistory = person.getVitalSignsHistory();
                        int counter = 1;
                        for(VitalSigns vitalSigns : vitalSignsHistory.getVitalSignHistory()) {
                            System.out.println("\t");
                            System.out.println(counter+ ": ");
                            System.out.print("\t\t");
                            SimpleDateFormat simpleDateFormat =
                                    new SimpleDateFormat("MM:dd:yyyy");
                            System.out.println( "d-" + simpleDateFormat.
                                    format(vitalSigns.getDate()) + 
                                "-t-" + String.valueOf(
                                        vitalSigns.getTemperature()).
                                        substring(0, 5) +
                                "-p-" + vitalSigns.getPulse() + 
                                "-bph-" + vitalSigns.getBloodPressureHigh() + 
                                "-bpl-" + vitalSigns.getBloodPressureLow() + 
                                "-cholN-" + vitalSigns.getCholestrolNCEP() + 
                                "-cholH-" + vitalSigns.getCholestrolHDL() + 
                               "-cholL-" + vitalSigns.getCholestrolLDL());
                        
                        counter++;
                        }
                        
                        
                        
                        
                        System.out.println("---------------------------");
                        
                        
                    }
                }
            }
        }
    }
    
    private static void printFamilyBasedDetails() {
        ArrayList<Family> familiesWithDiease = new ArrayList<>();
        for(Community community : framinghamTown.
                                    getCommunityDirectory().
                                        getCommunitites()) {
         //-----------------------------------------------//
            for(House house : community.getHouses().getHouses()) {
                for(Family family : house.getFamilies().getFamilies()) {
                    
                    for(Person person : family.getPersonDirectory().
                                        getPersons()) {
                        if(person.hasHeartDiease()) {
                            familiesWithDiease.add(family);
                            break;
                        }
                    }
                }
            }
        }
        System.out.println("Families with Heart Diease are:");
        for(Family family : familiesWithDiease) {
            System.out.println(family.getFamilyName()+ "'s");
        }
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    private static void createCommunityPersons() {
        listPersonsFirstNames.add("Jenny");
        listPersonsFirstNames.add("Raquel");
        listPersonsFirstNames.add("Mike");
        listPersonsFirstNames.add("Ashley");
        listPersonsFirstNames.add("Antonio");
        
        listPersonsFirstNames.add("Christy");
        listPersonsFirstNames.add("Albert");
        listPersonsFirstNames.add("Isaac");
        listPersonsFirstNames.add("Wilson");
        listPersonsFirstNames.add("Vanessa");
        
        listPersonsFirstNames.add("Cassandra");
        listPersonsFirstNames.add("Carol");
        listPersonsFirstNames.add("Connie");
        listPersonsFirstNames.add("Whitney");
        listPersonsFirstNames.add("Ray");
        
        listPersonsFirstNames.add("Lamar");
        listPersonsFirstNames.add("Clara");
        listPersonsFirstNames.add("Salvador");
        listPersonsFirstNames.add("Peggy");
        listPersonsFirstNames.add("Jack");
        
        listPersonsFirstNames.add("Rosalie");
        listPersonsFirstNames.add("Brandi");
        listPersonsFirstNames.add("Adam");
        listPersonsFirstNames.add("Wallace");
        listPersonsFirstNames.add("Carole");
        
        listPersonsFirstNames.add("Dean");
        listPersonsFirstNames.add("Mamie");
        listPersonsFirstNames.add("Ed");
        listPersonsFirstNames.add("Santiago");
        listPersonsFirstNames.add("Shelly");
        
        listPersonsFirstNames.add("Gerald");
        listPersonsFirstNames.add("Ruben");
        listPersonsFirstNames.add("Cesar");
        listPersonsFirstNames.add("Samuel");
        listPersonsFirstNames.add("Edward");
        
        listPersonsFirstNames.add("Randy");
        listPersonsFirstNames.add("Rick");
        listPersonsFirstNames.add("Toni");
        listPersonsFirstNames.add("Tracey Henry");
        listPersonsFirstNames.add("Fredrick");
        
        listPersonsFirstNames.add("Elizabeth");
        listPersonsFirstNames.add("Larry");
        listPersonsFirstNames.add("Natasha");
        listPersonsFirstNames.add("Irvin");
        listPersonsFirstNames.add("Mamie");
       
        
        
        
        
        
        listPersonsLastNames.add("Perez");
        listPersonsLastNames.add("Wise");
        listPersonsLastNames.add("Drake");
        listPersonsLastNames.add("Schneider");
        listPersonsLastNames.add("Bryan");
        
        listPersonsLastNames.add("Castro");
        listPersonsLastNames.add("Knight");
        listPersonsLastNames.add("Sullivan");
        listPersonsLastNames.add("Gardner");
        listPersonsLastNames.add("Garrett");
        
        listPersonsLastNames.add("Wagner");
        listPersonsLastNames.add("Quinn");
        listPersonsLastNames.add("Obrien");
        listPersonsLastNames.add("Ramsey");
        listPersonsLastNames.add("Garza");
        
        listPersonsLastNames.add("Ray");
        listPersonsLastNames.add("Barrett");
        listPersonsLastNames.add("Bishop");
        listPersonsLastNames.add("Brooks");
        listPersonsLastNames.add("Abbott");
        
        listPersonsLastNames.add("Fields");
        listPersonsLastNames.add("Cunningham");
        listPersonsLastNames.add("Hudson");
        listPersonsLastNames.add("Summers");
        listPersonsLastNames.add("Salazar");
        
        listPersonsLastNames.add("Lewis");
        listPersonsLastNames.add("Bowers");
        listPersonsLastNames.add("Washington");
        listPersonsLastNames.add("Hill");
        listPersonsLastNames.add("Curry");
        
        listPersonsLastNames.add("Moss");
        listPersonsLastNames.add("Sims");
        listPersonsLastNames.add("Adkins");
        listPersonsLastNames.add("Holland");
        listPersonsLastNames.add("Newton");
        
        listPersonsLastNames.add("Maxwell");
        listPersonsLastNames.add("Stokes");
        listPersonsLastNames.add("Peters");
        listPersonsLastNames.add("Henry");
        listPersonsLastNames.add("Moreno");
        
        listPersonsLastNames.add("Beck");
        listPersonsLastNames.add("Owen");
        listPersonsLastNames.add("Lamb");
        listPersonsLastNames.add("Pierce");
        listPersonsLastNames.add("Hill");
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    public static void DisplayCityLevelOptions(){
        System.out.println(" \n Select Option");
        System.out.println("1. Number of people having risk of getting heart disease in city ");
        System.out.println("2. Percentage of people having risk of getting heart disease in city");
        System.out.println("3. People having risk of getting heart disease in city based on age");
        System.out.println("0. Exit");
        System.out.print(" Enter options : ");
        int option = scanner.nextInt();
        if (option < 0 || option > 3)
            {
                System.out.println(" Please enter valid option \n");
                return;
            }

        if (option == 0)
            {
                return;
            }
        
        switch(option)
        {
            case 1 :    ReportFunctions.CalculateHeartRiskForCity(patients);
                        break;
                        
            case 2 :    ReportFunctions.PercentageHeartRiskForCity(patients, citizens);
                        break;
            
            case 3 :    ReportFunctions.HeartRiskBasedOnAge(patients);
                        break;
            
            default :   break;
        }
    }
    
    
    public static void DisplayCommunityLevelOptions()
    {
        System.out.println(" \n Select Option");
        System.out.println("1. Number of people having risk of getting heart disease in each community ");
        System.out.println("2. Percentage of people having risk of getting heart disease in in each community");
    //    System.out.println("3. people having risk of getting heart disease in community based on age");
        System.out.println("0. Exit");
        System.out.print(" Enter options : ");
        
        int option = scanner.nextInt();
        if (option < 0 || option > 3) {
                System.out.println(" Please enter valid option \n");
                return;
            }

        if (option == 0)
            {
                return;
            }
        switch(option)
        {
            case 1 :   ReportFunctions.CalculateHeartRiskForCommunity(patients);
                        break;
            
            case 2 :   ReportFunctions.PercentageHeartRiskForCommunity(patients);
                        break;
                        
            
            default:    break;
        }
    }
    
    
    
    public static void DisplayHouseLevelOptions()
    {
        System.out.println(" \n Select Option");
        System.out.println("1. Number of people having risk of getting heart disease in each house ");
        System.out.println("2. Percentage of people having risk of getting heart disease in in each house");
        System.out.println("0. Exit");
        System.out.print(" Enter options : ");
        int option = scanner.nextInt();
        if (option < 0 || option > 2)
            {
                System.out.println(" Please enter valid option \n");
                return;
            }

        if (option == 0)
            {
                return;
            }
        switch(option)
        {
            case 1 :    ReportFunctions.CalculateHeartRiskForHouse(patients);
                        break;
            
            case 2 :    ReportFunctions.PercentageHeartRiskForHouse(patients);
                        break;
            default:    break;
        }
    }
    
    public static void DisplayFamilyLevelOptions()
    {
        System.out.println(" \n Select Option");
        System.out.println("1.No of heart disease patients in a particular family:");
        System.out.println("0. Exit");
        System.out.print(" Enter options : ");
        int option = scanner.nextInt();
        if (option < 0 || option > 2)
            {
                System.out.println(" Please enter valid option \n");
                return;
            }

        if (option == 0)
            {
                return;
            }
        switch(option) {
            case 1 :    ReportFunctions.CalculateHeartRiskForFamily(patients);
                        break;
            
            default:    break;
        }
    }
}
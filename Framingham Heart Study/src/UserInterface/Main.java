/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface;

import Patient.Patient;
import java.util.Scanner;

/**
 *
 * @author Rohan
 */
public class Main {
    
    private static Scanner scanner = new Scanner(System.in);
    private static int option;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    //    Initialization.initializeResearch();
    //    ReportGeneration.GenerateReport();
        
        
        
        
        
        
        while(true)
        {   
           // int option = 0;
            String userInput = null;
            System.out.println("======== Welcome to Framingham Heart Study Center ========\n");
            System.out.println("Select Option");
            System.out.println("1. Estimate 10 year risk");
            System.out.println("2. Generate Reports");
            System.out.println("0. Exit \n ");
            System.out.print("Enter options : ");
            option = scanner.nextInt();

            if (option == 0){
                System.out.println("Existing from Framingham Heart Study Center ");
                break;
            }
            switch (option) {
                case 0:
                        break;
                case 1: ReportFunctions.calculateRisk();
                        break;
                        
                case 2: Initialization.initializeResearch();;
                        break;
                default:
                        System.out.println("Please enter a valid input.");
                        break;
            }
            scanner.nextLine();
            System.out.println(" Press enter to Continue : ");
            userInput = scanner.nextLine();
        }
        
        
        
    }
}

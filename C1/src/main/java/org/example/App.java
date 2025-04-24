package org.example;

import java.util.Scanner;

public class App {

   static Scanner appScanner;
    static UserInterface UI = new UserInterface();

    public static void main(String[] args) {


        boolean isRunning = true;
        appScanner = new Scanner(System.in);


        while(isRunning) {
            //let;s start building out our UI (User Interface)

            System.out.println("Welcome to YUU's Accounting Ledger");
            System.out.println("Please navigate tot the Home Menu to get started");
            System.out.println("H: Home Menu");
            System.out.println("E: Exit Application");

            String userSelection = appScanner.nextLine();

            switch (userSelection.toUpperCase()) {
                case "H":
                    //home menu
                   // System.out.println(" home Screen");
                    displayHomeScreen();
                    break;
                case "E":
                    // exit application
                    //System.out.println("Exit screen");
                    displayExitScreen();
                    isRunning = false;
                    break;
                default:
                    System.out.println("ERROR: Please re-type your selection");
                    System.out.println(" ");
                    break;
            } //end of switch


        } // end of the while loop

        System.out.println(" End of App - aka end of main method: D O N E ");
    } // end of main method

    //we want to create the homeScreen and the exit app methods

    static void displayHomeScreen(){
        System.out.println("+++++++++++++++++++");
        System.out.println("+++ HOME SCREEN +++");
        System.out.println("+++++++++++++++++++");
        System.out.println(" ");
        System.out.println("What would you like to do today?");
        System.out.println("D: Add Deposit");
        System.out.println("P: Make Payment");
        System.out.println("L: Open Ledger");
        System.out.println("E: Exit");

        String userSelection = appScanner.nextLine();

        switch (userSelection.toUpperCase()){
            case "D":
              //  System.out.println("Add Deposit");
                UI.addDeposit();
                displayHomeScreen();
                break;

            case "P":
                UI.makePayment();
                displayHomeScreen();
                break;

            case "L":
                System.out.println("Open Ledger");
                displayHomeScreen();
                break;

            case "E":
                System.out.println("Exit Home Screen");
                break;

            default:
                System.out.println("ERROR: Please re-type your selection");
                displayHomeScreen();
                break;

        }//out of the switch case

    } //end of displayHomeScreen method

    //create Exit Screen

    static void displayExitScreen(){

        System.out.println(".");
        System.out.println(".");
        System.out.println("You are now exiting the application");
        System.out.println("Have great day!");
    }


}

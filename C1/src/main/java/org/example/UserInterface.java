package org.example;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class UserInterface {
    //fields: variables that exist only on the class

    Scanner uiScanner = new Scanner(System.in);

    //constructor(s) - a special method

    public UserInterface(){
        // we don't have to add logic within this constructor
        // however we could if we wanted to
        System.out.println("Default constructor has been called");
    }

    //methods
    //add deposit method
    public void addDeposit(){
        //All Transactions have the same set-up
        //date|time|description|vendor|amount
        //The best way to go about formatting this "transaction"
        //is using a StringBuilder class

        StringBuilder receiptGenerator = new StringBuilder();
        //get today's date
        LocalDate date = LocalDate.now();
        //System.out.println(date);
        //the user view
        System.out.println("Today's Date: " + date.getMonth() + " " + date.getDayOfMonth() + ", " +date.getYear());

        //current time
        LocalTime time = LocalTime.now();
        time = time.truncatedTo(ChronoUnit.SECONDS);
        System.out.println("Current time: " + time );


        System.out.println("Transaction description: ");
        String description = uiScanner.nextLine();

        System.out.println("Vendor Name: ");
        String vendor = uiScanner.nextLine();

        System.out.println("Deposit Amount: ");
        String amount = uiScanner.nextLine();

        receiptGenerator.append(date);
        receiptGenerator.append("|");
        receiptGenerator.append(time);
        receiptGenerator.append("|");
        receiptGenerator.append(description);
        receiptGenerator.append("|");
        receiptGenerator.append(vendor);
        receiptGenerator.append("|");
        receiptGenerator.append(amount);

      // String advancedString = String.format("%s|%s|%s|%s|%s",date,time,description,vendor,amount);
        //get the string we've built out of the String builder
        // right now we're printing out the receipt but what we need to do is
        //        //persist the information - aka save it to a file called transactions.csv
       String receipt = receiptGenerator.toString();

       if(saveTransaction(receipt)) {

           System.out.println("Excellent!! Below you'll find your transaction details");
           System.out.println(".");
           System.out.println(".");
           System.out.println(receipt);
           System.out.println(" ");
       } else {
           System.out.println("Unable to complete transaction");
           System.out.println("Please try again later");
           System.out.println("Returning to Home Screen");
           System.out.println(" ");
       }


    } //end of add deposit method

//make payment method

    public void makePayment(){
        //get today's date
        LocalDate date = LocalDate.now();
        //System.out.println(date);
        //the user view
        System.out.println("Today's Date: " + date.getMonth() + " " + date.getDayOfMonth() + ", " +date.getYear());

        //current time
        LocalTime time = LocalTime.now();
        time = time.truncatedTo(ChronoUnit.SECONDS);
        System.out.println("Current time: " + time );


        System.out.println("Transaction description: ");
        String description = uiScanner.nextLine();

        System.out.println("Vendor Name: ");
        String vendor = uiScanner.nextLine();

        System.out.println("Deposit Amount: ");
        String amount = uiScanner.nextLine();

        String receipt = String.format("%s|%s|%s|%s|-%s",date,time,description,vendor,amount);
        //get the string we've built out of the String builder
        // String receipt = receiptGenerator.toString();

        if(saveTransaction(receipt)) {

            System.out.println("Excellent!! Below you'll find your transaction details");
            System.out.println(".");
            System.out.println(".");
            System.out.println(receipt);
            System.out.println(" ");
        } else {
            System.out.println("Unable to complete transaction");
            System.out.println("Please try again later");
            System.out.println("Returning to Home Screen");
            System.out.println(" ");
        }
    }

    //create a 'save transaction' method
    public boolean saveTransaction(String transaction){
        String fileName = "transactions.csv";

      //  try{ // some logic we want to try and execute }catch( exception that can be thrown){ //logic to execute in case of thrown exception}

        try (FileWriter fileWriter = new FileWriter(fileName,true);
             BufferedWriter bw = new BufferedWriter(fileWriter) ){
            //here we are adding the logic that we actually want to try
            //we want to 'write' to the transactions.csv file
            bw.write(transaction);
            bw.newLine();
            return true;

        } catch (IOException ioException){
            System.out.println(ioException.getLocalizedMessage());
            return false;
        }

    }

}

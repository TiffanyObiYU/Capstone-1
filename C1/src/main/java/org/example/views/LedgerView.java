package org.example.views;

import org.example.models.Transaction;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

public class LedgerView {
    Scanner ledgerScanner = new Scanner(System.in);

    ArrayList<Transaction> transactionHistory = new ArrayList<>();

    ReportView reportView;

    //ledgerMenu
    public void ledgerMenu() {
        transactionHistory = getAllTransactions();

        boolean isRunning = true;

        while (isRunning) {

            System.out.println("+++++++++++++++++");
            System.out.println("Ledger Menu");
            System.out.println("+++++++++++++++++");
            System.out.println(" ");

            System.out.println("Please select from the following options");
            System.out.println("A: All- Display all entries");
            System.out.println("D: Deposits - Display deposits");
            System.out.println("P: Payments - Display payments");
            System.out.println("R: Reports");
            System.out.println("E: Exit to Home Menu");


            //capture the user selection
            String selection = ledgerScanner.nextLine();

            switch (selection.toUpperCase()) {
                case "A":
                    // System.out.println("All transactions");
                    System.out.println("__________________________________");
                    System.out.println(" ");
                    System.out.println("View your transaction history below");
                    System.out.println(" ");
                    System.out.println("___________________________________");
                    for (Transaction transaction : transactionHistory) {
                        System.out.println(transaction);
                    }
                    break;
                case "D":
                    System.out.println("__________________________________");
                    System.out.println(" ");
                    System.out.println("View your DEPOSIT history below");
                    System.out.println(" ");
                    System.out.println("___________________________________");
                    getAllDeposits();

                    break;

                case "P":
                    System.out.println("__________________________________");
                    System.out.println(" ");
                    System.out.println("View your transaction history below");
                    System.out.println(" ");
                    System.out.println("___________________________________");
                    getAllPayments();

                    break;

                case "R":
                    System.out.println("__________________________________");
                    System.out.println(" ");
                    System.out.println("Navigating to Reports Menu....");
                    System.out.println(".....................................");
                    System.out.println("..........................................");
                    System.out.println(".....................................");
                    System.out.println("..........................................");
                    System.out.println(".....................................");
                    System.out.println(" ");
                    System.out.println("___________________________________");
                    reportView = new ReportView(transactionHistory);
                    reportView.reportsMenu();
                    break;

                case "E":
                    System.out.println("Exiting back to home screen");
                    isRunning = false;
                    break;

                default:
                    System.out.println("ERROR: Please re-type your selection");

            }
        }
    }

    //retrieve all transactions from the transaction.csv file
    public ArrayList<Transaction> getAllTransactions(){

        ArrayList<Transaction> allTransactionsFromCSVFile = new ArrayList<>();

        String fileName = "transactions.csv";

        try(FileReader fileReader = new FileReader(fileName);
            BufferedReader br = new BufferedReader(fileReader)){
          //  System.out.println("In File reader method");
            //This variable is going to hold each line from the file
            String line;

            while((line = br.readLine()) != null){
                //we're printing out each line or row from our csv file.
              //  System.out.println(line);
                Transaction transaction = new Transaction();

                //split this String!!!
                String[] transactionArr = line.split("\\|");

                //print out each attribute
                //enhanced for-loops
//                for(String item: transactionArr){
//                    System.out.println(item);
//                }
                //we can assign the proper item to the corresponding field
               // transaction.setDate(LocalDate.parse(transactionArr[0]));
                LocalDate date = LocalDate.parse(transactionArr[0]); //date
                transaction.setDate(date);
                LocalTime time = LocalTime.parse(transactionArr[1]); //time
                transaction.setTime(time);
                String description = transactionArr[2]; //description
                transaction.setDescription(description);
                String vendor = transactionArr[3]; //vendor
                transaction.setVendor(vendor);
                double amount = Double.parseDouble(transactionArr[4]);
                transaction.setAmount(amount);

                // another example of how we could create out Transaciton object from the
                //lines in the transaction file
                Transaction trans2 = new Transaction(date,time,description,vendor,amount);
               // allTransactionsFromCSVFile.add(trans2);
                allTransactionsFromCSVFile.add(transaction);


                //Create a Transaction Object from the line we retrieve
            }

        }catch (IOException ioException){
            ioException.getLocalizedMessage();
        }

        return allTransactionsFromCSVFile;
    }

    //getting only deposits
    public void getAllDeposits(){
        for(Transaction deposit: transactionHistory){
            if(deposit.getAmount() > 0){
                System.out.println(deposit);
            }
        }
    }

    //getting only payments
    public void getAllPayments(){
        for(Transaction payment: transactionHistory){
            if(payment.getAmount() < 0){
                System.out.println(payment);
            }
        }
    }


}

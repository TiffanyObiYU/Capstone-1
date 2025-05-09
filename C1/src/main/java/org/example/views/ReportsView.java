package org.example.views;

import org.example.models.Transaction;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Scanner;

public class ReportsView {
    ArrayList<Transaction> transactionsList;
    Scanner scanner = new Scanner(System.in);

    // We can crete a new instance on the arraylist of Transactions or pass over
    // the existing array

    //we would pass it over in the constructor
    public ReportsView(ArrayList<Transaction> transactionsList){
        this.transactionsList = transactionsList;
    }


    //view Reports Menu
    public void reportsMenu(){

        boolean isRunning = true;
        while(isRunning) {

            System.out.println("+++++++++++++++++");
            System.out.println("Reports Menu");
            System.out.println("+++++++++++++++++");
            System.out.println(" ");

            System.out.println("Please select from the following options");
            System.out.println("1) Month To Date");
            System.out.println("2) Previous Month");
            System.out.println("3) Year To Date");
            System.out.println("4) Previous Year");
            System.out.println("5) Search by Vendor");
            System.out.println("0) Back to Ledger");

            int selection = scanner.nextInt();
            scanner.nextLine(); // this closes out hte scanner after we retrieve our int value

            switch (selection){
                case 1:
                    System.out.println("___________________________");
                    System.out.println("This Month's Transactions: ");
                    System.out.println("___________________________");
                    monthToDate();
                    break;

                case 2:
                    System.out.println("____________________________");
                    System.out.println(" Last Month's Transactions: ");
                    System.out.println("____________________________");
                    previousMonth();
                    break;

                case 3:
                    System.out.println("___________________________");
                    System.out.println(" This Year's Transactions: ");
                    System.out.println("___________________________");
                    yearToDate();
                    break;

                case 4:
                    System.out.println("___________________________");
                    System.out.println(" Last Year's Transactions: ");
                    System.out.println("___________________________");
                    previousYear();
                    break;

                case 5:
                    System.out.println("___________________________");
                    System.out.println("     Search By Vendor:     ");
                    System.out.println("___________________________");
                    System.out.println(" Input the vendor to search ");

                    String vendor = scanner.nextLine();
                    searchByVendor(vendor);
                    break;

                case 0:
                    isRunning = false;
                    System.out.println("__________________________________");
                    System.out.println(" ");
                    System.out.println("Returning to Ledger Menu");
                    System.out.println(".....................................");
                    System.out.println("..........................................");
                    System.out.println(".....................................");
                    System.out.println("..........................................");
                    System.out.println(".....................................");
                    System.out.println(" ");
                    System.out.println("___________________________________");
                    break;

                default:
                    System.out.println("ERROR: Please re-type your selection");
            }


        }
    }

    private void monthToDate(){

        int counter = 0;

        LocalDate now = LocalDate.now();
        LocalDate firstOfMonth = LocalDate.of(now.getYear(),now.getMonth(),1);
        LocalDate currentDayOfMonth = LocalDate.of(now.getYear(),now.getMonth(),now.getDayOfMonth());
        for(Transaction item: transactionsList){
            if(item.getDate().isAfter(firstOfMonth) && item.getDate().isBefore(currentDayOfMonth)){
                counter += 1;
                System.out.println(item);

            }
        }
        if (counter < 1){
            System.out.println("**** No transaction to show ****");
        }

    }

    private void previousMonth(){
        int counter = 0;

        LocalDate now = LocalDate.now();
        LocalDate firstOfLastMonth = LocalDate.of(now.getYear(), now.getMonth().getValue()-1,1);
        LocalDate lastDayOfLastMonth = LocalDate.of(now.getYear(), now.getMonth().getValue()-1, Month.of(now.getMonth().getValue()-1).maxLength());
        for(Transaction item: transactionsList){
            if (item.getDate().isAfter(firstOfLastMonth) && item.getDate().isBefore(lastDayOfLastMonth)){
                counter += 1;
                System.out.println(item);
            }
        }
        if (counter<1){
            System.out.println("**** No transaction to show ****");
        }

    }

    private void yearToDate(){

        int counter = 0;

        LocalDate now = LocalDate.now();
        LocalDate firstOfYear = LocalDate.of(now.getYear(), 1,1);
        LocalDate currentDayOFMonth = LocalDate.of(now.getYear(), now.getMonth(), now.getDayOfMonth());
        for(Transaction item: transactionsList){
            if (item.getDate().isAfter(firstOfYear) && item.getDate().isBefore(currentDayOFMonth)){
                counter += 1;
                System.out.println(item);
            }
        }
        if (counter<1){
            System.out.println("**** No transaction to show ****");
        }

    }

    private void previousYear(){
        int counter = 0;

        LocalDate now = LocalDate.now();
        LocalDate firstOfYear = LocalDate.of(now.getYear()-1, Month.JANUARY,1);
        LocalDate lastDayOfPreviousYear = LocalDate.of(now.getYear()-1, Month.DECEMBER, Month.DECEMBER.maxLength());
        for(Transaction item: transactionsList){
            if (item.getDate().isAfter(firstOfYear) && item.getDate().isBefore(lastDayOfPreviousYear)){
                counter += 1;
                System.out.println(item);
            }
        }
        if (counter<1){
            System.out.println("**** No transaction to show ****");
        }

    }

    private void searchByVendor(String vendor){

        int counter = 0;

        for (Transaction item: transactionsList){
            if(item.getVendor().equalsIgnoreCase(vendor)){
                counter += 1;
                System.out.println(item);
            }
        }

        if (counter<1){
            System.out.println("**** No transaction to show ****");
        }

    }


}

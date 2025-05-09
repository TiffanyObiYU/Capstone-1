package org.example.views;

import org.example.models.Transaction;

import java.util.ArrayList;

public class ReportView {
    ArrayList<Transaction> transactionsList;

    // We can crete a new instance on the arraylist of Transactions or pass over
    // the existing array

    //we would pass it over in the constructor
    public ReportView(ArrayList<Transaction> transactionsList){
        this.transactionsList = transactionsList;
    }


    //view Reports Menu
    public void reportsMenu(){

        boolean isRunning = true;
        

        System.out.println("+++++++++++++++++");
        System.out.println("Ledger Menu");
        System.out.println("+++++++++++++++++");
        System.out.println(" ");

        System.out.println("Please select from the following options");
        System.out.println("1) Month To Date");
        System.out.println("2) Previous Month");
        System.out.println("3) Year To Date");
        System.out.println("4) Previous Year");
        System.out.println("5) Search by Vendor");
        System.out.println("0) Back to Ledger");



    }

}

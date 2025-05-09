package org.example.models;

//4 Pillars of OOP (Object-Oriented Programming)
//Inheritance - inherit from a parent class or another object
//Polymorphism - Many forms. // method overloading or method overriding
//Encapsulation - Protecting data
//Abstraction - Hiding Data

import java.time.LocalDate;
import java.time.LocalTime;

public class Transaction {
    //date|time|description|vendor|amount


    //Encapsulation - we are using the private access modifier
    //fields
    private LocalDate date;
    private LocalTime time;
    private String description;
    private String vendor;
    private double amount;


    //constructors
    //default constructor
    public Transaction() {
    }

    //all args constructor
    public Transaction(LocalDate date, LocalTime time, String description, String vendor, double amount) {
        this.date = date;
        this.time = time;
        this.description = description;
        this.vendor = vendor;
        this.amount = amount;
    }

    //methods (getters and setters)


    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        System.out.println(" ");
        System.out.println("++++++++++++++++++++++++++++++");

        return date +
                "|" +
                time +
                "|" +
                description +
                "|" +
                vendor +
                "|" +
                amount;
    }
}

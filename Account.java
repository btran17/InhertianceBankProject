package com.company;
/*
    Account is the Parent class for the children
 */


import java.util.Random;

public class Account {
    private String name = " ";
    private long taxID; //ss number
    private double balance;
//    protected double balance = 100; //amount in dollars
//    protected double last10withdraws[][] = new double[2][5];
//    protected double last10deposits[][] = new double[2][5];
    protected double last10withdraws[] = new double[10];
    protected double last10deposits[] = new double[10];
    protected int numDeposits = 0;
    protected int numWithdraws = 0;


    //Mutators: assign a new value for each with error checking
    public void setName(String name) {
        this.name = name;
    }

    public void setTaxID(long taxID) {
        this.taxID = taxID;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    //Accessors: returns a value for each variable
    public String getName() {
        return name;
    }

    public long getTaxID() {
        return taxID;
    }

    public double getBalance() {
        return balance;
    }

    public void makeDeposit(double amount){
        if(amount > 0){
            balance += amount;
            numDeposits++;
            System.out.println("You deposited: $" + (amount));
            System.out.println("Current Balance: $"+ balance);
            System.out.println("Number of Deposits: " + numDeposits);

//            for (int i = 0; i < last10deposits.length; i++) {
//                for(int j = 0; j < last10deposits[i].length; j++) {
//                    last10deposits[i][j] = amount;
//                        System.out.print(last10deposits[i][j] + "  ");
//                }
//                System.out.println();
//            }

        }
        else{
            System.err.println("Error: Invalid Amount.");
        }
    }

    //Contructors
    public Account() {
        Random gen = new Random();
        name = "Britt";
        taxID = gen.nextInt(9000) + 1000;
        balance = 100;
//        last10deposits = new double[2][5];
//        last10withdraws = new double[2][5];
         last10deposits = new double[10];
        last10withdraws = new double[10];
        numDeposits = 0;
        numWithdraws = 0;
    }

    public Account(String name, long taxID, double balance) {
        this.name = name;
        this.taxID = taxID;
        this.balance = balance;

    }

    //display the name, taxID, and balance
    public void display() {
        System.out.println("Name: " + getName());
        System.out.println("Tax ID: " + getTaxID());
        System.out.println("Initial Balance: "+ getBalance());
    }






}

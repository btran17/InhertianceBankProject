package com.company;

import java.util.Arrays;
import java.util.Random;

public class CreditCard extends Account {

    public long cardNumber;
    public String last10Charges[] = new String[10];
    private double balance = 100;
    private int numWithdraws = 0;
    private int numDeposits = 0;

    //adjust the balance and list it as a withdraw in the base class
    public void debitCharges(String name, double amount){
        if(amount > 0 && amount < balance){
            balance -= amount;
            numWithdraws++;
            System.out.println("Charged for: " + name);
            System.out.println("You withdrew: $" + (amount));
            System.out.println("Current Balance: $"+ balance);
            System.out.println("Number of withdrawals: " + numWithdraws);

            //adding to the array
            for(int i = 0; i < last10Charges.length; i++){
                if(last10Charges[i] == null){
                    last10Charges[i] = name;
                    break;
                }
            }

//            System.out.println("Last 10 withdrawals: ");
//            for(int i = 0; i < last10withdraws.length; i++) {
//                for(int j = 0; j < last10withdraws[i].length; j++) {
//                    if(last10withdraws[i][j] == 0) {
//                        last10withdraws[i][j] = amount;
//                        break;
//                    }
//                }
//            }

            for(int i = 0; i < last10withdraws.length; i++){
                if(last10withdraws[i] == 0){
                    last10withdraws[i] = amount;
                    break;
                }
            }

        }
        else{
            System.err.println("Cannot withdraw more than balance.");        }
    }

    //adjust the balance and list it as a DEPOSIT in the base class
    public void makePayment(double amount){
        if (amount > 0) {
            balance += amount;
            numDeposits++;
            System.out.println("You deposited: $" + (amount));
            System.out.println("New Balance of: $" + balance);
            System.out.println("Number of Deposits: " + numDeposits);

//            for (int i = 0; i < last10deposits.length; i++) {
//                for (int j = 0; j < last10deposits[i].length; j++) {
//                    if (last10deposits[i][j] == 0) {
//                        last10deposits[i][j] = amount;
//                        break;
//                    }
//                }
//            }

            for(int i = 0; i < last10deposits.length; i++){
                if(last10deposits[i] == 0){
                    last10deposits[i] = amount;
                    break;
                }
            }

        }
        else {
            System.err.println("Invalid amount");
        }
    }

    public double getCCBalance() {
        return balance;
    }


    public CreditCard(){
        Random gen = new Random();
        cardNumber = gen.nextInt(9000) + 1000;
        last10Charges = new String[10];
    }

    public CreditCard(String name, long taxID, double balance) {
        super(name, taxID, balance);
    }

    //display the account charges (name and amount) and deposit record
    public void display(){
        System.out.println("\nRecords");
        System.out.println("Card Ending in: " + cardNumber);
        System.out.println("Number of deposits  made: " + numDeposits);
        System.out.println("Last 10 Charges: \n"+ Arrays.toString(last10Charges));

    }
}

package com.company;

import java.util.Arrays;

public class Checking extends Account {

    private int last10Checks[] = new int[10];
    private double balance = 100;
    private int numWithdraws = 0;

    //adjust the balance and list it as a withdraw in the base class
    public void writeCheck(int checkNum, double amount){
        if(amount > 0 && amount < balance){
            balance -= amount;
            numWithdraws++;
            System.out.println("Check number: " + checkNum);
            System.out.println("You withdrew: $" + (amount));
            System.out.println("Current Balance: $"+ balance);
            System.out.println("Number of withdrawals: " + numWithdraws);

            for(int i = 0; i < last10Checks.length; i++){
                if(last10Checks[i] == 0){
                    last10Checks[i] = checkNum;
                    break;
                }
            }

            System.out.println("Last 10 withdrawals: ");
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
            System.err.println("Error: Cannot withdraw more than balance.");
        }
    }

    public void makeDeposit(double amount) {
        if (amount > 0) {
            balance += amount;
            numDeposits++;
            System.out.println("You deposited: $" + (amount));
            System.out.println("Current Balance: $" + balance);
            System.out.println("Number of Deposits: " + numDeposits);

//            for (int i = 0; i < last10deposits.length; i++) {
//                for (int j = 0; j < last10deposits[i].length; j++) {
//                    if (last10deposits[i][j] == 0) {
//                        last10deposits[i][j] = amount;
//                        break;
//                    }
//                }
//
//            }

            for(int i = 0; i < last10deposits.length; i++){
                if(last10deposits[i] == 0){
                    last10deposits[i] = amount;
                    break;
                }
            }

        } else {
            System.err.println("Error: Invalid Amount.");
        }
    }

    public double getCBalance() {
        return balance;
    }

    public Checking() {
        last10Checks = new int[10];
    }

    public Checking(String name, long taxID, double balance) {
        super(name, taxID, balance);
    }

    //display the accounts check register (number and amount) and deposit record
    public void display(){
        System.out.println("\nRecords");
        System.out.println("Number of deposits made: " + numDeposits);
        System.out.println("Last 10 Deposits: \n"+ Arrays.toString(last10deposits));
        System.out.println("Check Register: \n" + Arrays.toString(last10Checks));

    }

}

package com.company;

import java.util.Arrays;

public class Savings extends Account {

    private double RATE = 0.025 * 100; // interest rate
    private double balance = 100;
    private int numWithdraws = 0;

    //adjust the balance and list it as a withdraw in the base class
    public double doWithdraw(double withdrew){
        if( withdrew > 0 && withdrew <= balance){
            //if withdraws more than 6 times interest gets charged
            if(numWithdraws >= 6){
                balance -= (withdrew * RATE);
                numWithdraws++;
            }
            balance -= withdrew;
            numWithdraws++;
            System.out.println("You withdrew: $" + (withdrew));
            System.out.println("Current Balance: $"+ balance);
            System.out.println("Number of Withdrawals: " + numWithdraws);

           // storing the value in the 2D Array
//          System.out.println("Last 10 withdrawals: ");
//            for(int i = 0; i < last10withdraws.length; i++) {
//                for(int j = 0; j < last10withdraws[i].length; j++) {
//                    if(last10withdraws[i][j] == 0) {
//                        last10withdraws[i][j] = withdrew;
//                        break;
//                    }
//                }
//            }

            for(int i = 0; i < last10withdraws.length; i++){
                if(last10withdraws[i] == 0){
                    last10withdraws[i] = withdrew;
                    break;
                }
            }

            return withdrew;
        }
        else{
            System.err.println("Cannot withdraw more than balance.");
        }
        return 0;
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
//            }

            for(int i = 0; i < last10deposits.length; i++){
                if(last10deposits[i] == 0){
                    last10deposits[i] = amount;
                    break;
                }
            }

        }
        else {
            System.err.println("Error: Invalid Amount.");
        }
    }

    public double getSBalance() {
        return balance;
    }

    public Savings(){ }

    public Savings(String name, long taxID, double balance) {
        super(name, taxID, balance);
    }

    //display the accounts withdrawal and deposit record
    public void display(){
        System.out.println("\nRecords");
        System.out.println("Number of deposits made: " + numDeposits);
        System.out.println("Number of withdrawal made: "+ numWithdraws);
        System.out.println("Last 10 Deposits: \n"+ Arrays.toString(last10deposits));
        System.out.println("Last 10 Withdrawals: \n"+ Arrays.toString(last10withdraws));
//        System.out.println("Last 10 Deposits: \n"+ Arrays.deepToString(last10deposits));
//        System.out.println("Last 10 Withdrawals: \n"+ Arrays.deepToString(last10withdraws));

    }
}

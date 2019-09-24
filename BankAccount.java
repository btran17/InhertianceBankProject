package com.company;

    /* Name: Brittney Tran
    # Date: 9/23/2019
    # Class: CSC 1120
    # Pledge: I have neither given nor received unauthorized aid on this program.
    # Description: The Bank Account Class allows for updates and modification to the child classes.
    # Input: The user types commands such as (1-10 to execute deposits, withdrawals and payments)."
    # Output:The program will display the rolling balance of each of the classes.
    */
    import java.util.Scanner;

public class BankAccount {

   static Scanner scan = new Scanner(System.in);

    public static void lines(){
        System.out.println();
        for (int i = 0; i < 4; i++) {
            System.out.print("≡≡≡≡≡≡≡≡≡≡≡≡≡≡≡≡≡≡≡≡≡");
        }
        System.out.println();
    }

    public static void menu(){
        System.out.println("\t\t\t\t\t\t\t  Banking Corp, LLC \t\t\t\t\t\t\t\t");
        for(int i = 0; i < 4; i++) {
            System.out.print("~~~~~~~~~~~~~~~~~~~~~");
        }
        System.out.println();
        System.out.println("Options: ");
        System.out.println("1. Savings Deposit \t\t\t" + "2. Savings Withdrawal \t\t\t"+ "3. Checking Deposit ");
        System.out.println("4. Write a Check \t\t\t" + "5. Credit Card Payment \t\t\t"+ "6. Make a Charge ");
        System.out.println("7. Display Savings \t\t\t" + "8. Display Checking \t\t\t"+ "9. Display Credit Card ");
        System.out.println("10. Exit");
        System.out.println("\nPlease enter a number: 1-10 ");
    }

    public static void main(String[] args) {
        Account a = new Account();
        Checking c = new Checking();
        Savings s = new Savings();
        CreditCard cc = new CreditCard();
        a.display();
        lines();
        System.out.print(" Checking Balance: $" + c.getCBalance() + " | ");
        System.out.print(" Savings Balance: $" + s.getSBalance() + " | ");
        System.out.print(" Credit Card Balance: $" + cc.getCCBalance());
        lines();
        menu();
        boolean finish = false;
        while(!finish) {
            switch (scan.next()) {
                case "1":
                    System.out.println("SELECTED: Savings Deposit");
                    System.out.println("\nPlease enter an amount to deposit.");
                    s.makeDeposit(scan.nextDouble());
                    System.out.println();
                    s.display();
                    break;
                case "2":
                    System.out.println("SELECTED: Saving Withdrawal");
                    System.out.println("\nPlease enter an amount to withdraw.");
                    s.doWithdraw(scan.nextDouble());
                    s.display();
                    break;
                case "3":
                    System.out.println("SELECTED: Checking Deposit");
                    System.out.println("\nPlease enter an amount to deposit.");
                    c.makeDeposit(scan.nextDouble());
                    c.display();
                    break;
                case "4":
                    System.out.println("SELECTED: Write a Check");
                    System.out.println("\nPlease enter the Check Number.");
                    int check = scan.nextInt();
                    System.out.println("Please enter the amount.");
                    double number = scan.nextDouble();
                    c.writeCheck(check, number);
                    c.display();
                    break;
                case "5":
                    System.out.println("SELECTED: Credit Card Payment");
                    System.out.println("\nPlease enter an amount to pay.");
                    cc.makePayment(scan.nextDouble());
                    cc.display();
                    break;
                case "6":
                    System.out.println("SELECTED: Make a Charge");
                    System.out.println("\nPlease enter the reason for the charge (Food, Gas, Clothes...).");
                    String charge = scan.next();
                    System.out.println("Please enter the amount.");
                    double cost = scan.nextDouble();
                    cc.debitCharges(charge, cost);
                    cc.display();
                    break;
                case "7":
                    System.out.println("SELECTED: Savings Display");
                    System.out.println("\nSavings Account: $" + s.getSBalance());
                    break;
                case "8":
                    System.out.println("SELECTED: Display Checking");
                    System.out.println("\nChecking Account: $" + c.getCBalance());
                    break;
                case "9":
                    System.out.println("SELECTED: Display Credit Card");
                    System.out.println("\nCredit Card: $" + cc.getCCBalance());
                    break;
                case "10":
                    System.out.print("Exiting");
                    finish = true;
                    System.exit(0);
                    break;
                default:
                    System.err.println("ERROR: INVALID INPUT");
            }
            lines();
            System.out.print(" Checking Balance: $" + c.getCBalance() + " | ");
            System.out.print(" Savings Balance: $" + s.getSBalance() + " | ");
            System.out.print(" Credit Card Balance: $" + cc.getCCBalance());
            lines();
            menu();
        }

    }

}

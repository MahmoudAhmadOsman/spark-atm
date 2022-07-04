package com.bank.atm;

import java.util.Scanner;
public class Main {
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
//    public static final String RED_BACKGROUND = "\u001B[41m";

    public static void main(String[] args) {
        int atnNum = 25000;
        int pinNum = 5000;

        //4. create AtmOperationInterface objects here
    AtmOperationInterface op = new AtmOperationInterfaceImplementation();


//Scanner - ask the user his/her ATM & pin-number
        System.out.println("Welcome to Easter Bank ATM. Please use below ATM credentials.\n " +
                "ATM number is: [25000], Pin number is: [5000]");
        System.out.println();
        Scanner in = new Scanner(System.in);
        System.out.print(ANSI_BLUE + "Enter you ATM number: ");
        int atmNumber = in.nextInt();
        System.out.print(ANSI_BLUE + "Enter your pin number: ");
        int atmPinNumber = in.nextInt();


//Check if the atm number and the pin-number are correct
        if ((atnNum == atmNumber & pinNum == atmPinNumber)) {
            while (true) {
                System.out.println(ANSI_GREEN +
                        "1.View Balance\n" +
                        "2.Withdraw Money\n" +
                        "3.Deposit Money\n" +
                        "4.View Account Activities\n" +
                        "5.Exit or end activity"
                );
                System.out.println(ANSI_BLUE + "Please choose an option\n ");
                int choice = in.nextInt();
                if (choice == 1) {
                    op.viewBalance();

                } else if (choice == 2) {
                    System.out.println("Withdraw money");
                } else if (choice == 3) {
                    System.out.println("Enter the amount you want to deposit");
                    double depositAmount = in.nextDouble();
                    op.viewBalance(); // immediately call view balance & show the available balance
                    op.depositAmount(depositAmount);


                } else if (choice == 4) {

                    System.out.println("4");

                } else if (choice == 5) {

                    System.out.println("============ Thank you ============");
                    System.out.println(ANSI_RED + "Please take your card!" );
                    System.exit(1);

                } else {
                    System.out.println(ANSI_RED + "Invalid option! Please choose valid option ");
                }//end of main if statement


            }//end while
        } else {
            System.out.println(ANSI_RED + "Invalid ATM number or pin number!");
            System.out.println(ANSI_RED + "Please, enter valid credentials!");
        }

in.close();
    }
}

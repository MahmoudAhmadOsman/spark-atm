package com.spark.atm;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

//3. implement the AtmOperationInterface class here - otherwise make this class an abstract class
//4. create objects in main class
public class AtmOperationInterfaceImplementation implements AtmOperationInterface {

    public static final String ANSI_PURPLE = "\u001B[35m";
    //create object of ATM class to access its states with the help of getter & setter
    Map<Double, String> miniStatement = new HashMap<>();
    ATM atm = new ATM();
    public Long customerServiceNumber = 18003547888L;


    //show transaction date & time
    private DateTimeFormatter currentDate = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
    LocalDateTime now = LocalDateTime.now();


    @Override
    public void viewBalance() {
        System.out.println("========================= ");
        System.out.println("Your Balance is:  $" + atm.getBalance());
        System.out.println("========================= ");

    }

    @Override
    public void withdrawAmount(double withdrawAmount) {

        if (withdrawAmount <= atm.getBalance()) {

            miniStatement.put(withdrawAmount, " withdrawn on | " + currentDate.format(now));
            atm.setBalance(atm.getBalance() - withdrawAmount);
            System.out.println("The amount of " + withdrawAmount + " has been withdrawn");
            viewBalance();

        } else {
            System.out.println("Your balance is too low for the amount of $"
                    + withdrawAmount + " to be withdrawn. Your available balance is: $" + atm.getBalance());
            System.out.println(ANSI_PURPLE + "Please contact Customer Service at: " + customerServiceNumber);
            System.out.println();
        }


    }

    @Override
    public void depositAmount(double depositAmount) {

        miniStatement.put(depositAmount, " deposited on | " + currentDate.format(now));
        //show a message of the deposited amount
        System.out.println(ANSI_PURPLE + "Total of $" + depositAmount + " has been deposited into your account.");
        //Then add this amount into the available balance
        atm.setBalance(atm.getBalance() + depositAmount); //current balance + deposited amount
        viewBalance(); // immediately show the balance

    }

    @Override
    public void viewMiniStatement() {
        for (Map.Entry<Double, String> m : miniStatement.entrySet()) {
            System.out.println(m.getKey() + "" + m.getValue());
        }
    }
}
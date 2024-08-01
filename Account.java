package com.company;
import java.text.DecimalFormat;
import java.util.Scanner;

public class Account {
    Scanner scan = new Scanner(System.in);
    DecimalFormat formatMoney = new DecimalFormat("'€' ###,###.00");

    private int idClient;
    private int pinClient;
    private double currentAccount;
    private double savingsAccount;

    public int getIdClient() {
        return idClient;
    }
    public int setIdClient(int idClient) {
        this.idClient = idClient;
        return idClient;
    }

    public int getPinClient() {
        return pinClient;
    }

    public int setPinClient(int pinClient) {
        this.pinClient = pinClient;
        return pinClient;
    }

    public double getCurrentAccount() {
        return currentAccount;
    }

    public double getSavingsAccount() {
        return  savingsAccount;
    }

//    public Account(int idClient, int pinClient, double currentAccount, double savingsAccount) {
//        this.idClient = idClient;
//        this.pinClient = pinClient;
//        this.currentAccount = currentAccount;
//        this. savingsAccount =  savingsAccount;
//    }

    public double currentAccountWithdrawal(double suma) {
        currentAccount = currentAccount - suma;
        return currentAccount;
    }
    public double addCurrentAccount(double suma) {
        currentAccount = currentAccount + suma;
        return currentAccount;
    }
    public double savingsAccountWithdrawal(double suma) {
        savingsAccount =  savingsAccount - suma;
        return  savingsAccount;
    }
    public double addSaveingAccount(double suma) {
        savingsAccount =  savingsAccount + suma;
        return  savingsAccount;
    }

    public void withdrawalCurrentAccount() {
        System.out.println("The current account balance is: " + formatMoney.format(currentAccount));
        System.out.println("The amount you wish to withdraw from the Current Account: ");
        double suma = scan.nextDouble();
        if(currentAccount - suma >= 0) {
            currentAccountWithdrawal(suma);
            System.out.println("The new balance of the Account is: " + formatMoney.format(currentAccount));
        }else {
            System.out.println("We are sorry, insufficient funds, the balance cannot be negative" + "\n");
        }
    }
    public void CurrentAccountAdd() {
        System.out.println("The current account balance is: " + formatMoney.format(currentAccount));
        System.out.println("The amount you want to deposit in the Current Account: ");
        double suma = scan.nextDouble();
        addCurrentAccount(suma);
            System.out.println("The new balance of the Account is: " + formatMoney.format(currentAccount));
    }
    public void withdrawalSavingsAccount() {
        System.out.println("The savings account balance is: " + formatMoney.format( savingsAccount));
        System.out.println("The amount you wish to withdraw from the Savings Account: ");
        double suma = scan.nextDouble();
        if( savingsAccount - suma >= 0) {
            savingsAccountWithdrawal(suma);
            System.out.println("The new balance of the Account is: " + formatMoney.format( savingsAccount));
        }else {
            System.out.println("We are sorry, insufficient funds, the balance cannot be negative" + "\n");
        }
    }
    public void SavingsAccountAdd() {
        System.out.println("The savings account balance is: " + formatMoney.format( savingsAccount));
        System.out.println("The amount you want to deposit in the Savings Account: ");
        double suma = scan.nextDouble();
        addSaveingAccount(suma);
        System.out.println("The new balance of the Account is: " + formatMoney.format( savingsAccount));
    }
}

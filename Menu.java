package com.company;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;
import java.text.DecimalFormat;
import java.util.Map.Entry;
public class Menu extends Account {
    Scanner menu = new Scanner(System.in);
    DecimalFormat formatMoney = new DecimalFormat(" '€' ###,###.00");
    HashMap<Integer, Integer> data = new HashMap<Integer, Integer>();

    public void getLogin() throws IOException {
        int x = 1;
        do {
            try{
                data.put(12345, 1234);
                data.put(98765, 5678);
                System.out.println("Welcome to this ATM");
                System.out.println("Enter the user number");
                setIdClient(menu.nextInt());
                System.out.println("Enter your PIN");
                setPinClient(menu.nextInt());
            }catch(Exception e) {
                System.out.println("Invalid character" + "\n");
                x = 2;
            }
            //I check if the id and pin entered is equal to the one in the database
            for(Entry<Integer, Integer> entry: data.entrySet()) {
                if(entry.getKey() == getIdClient() && entry.getValue() == getPinClient()) {
                    getDesiredAccount();
                }
            }
        }while(x == 1);
    }

    int select;

    public void getDesiredAccount() {
        System.out.println("Select the account you want to access:");
        System.out.println("Type 1: Current Account\n" +
                    "Type 2: Savings account\n" +
                    "Type 3: Exit\n" +
                    "Choose:");
        select = menu.nextInt();
        switch (select) {
            case 1:
                getCurent();
                break;
            case 2:
                getSavings();
                break;
            case 3:
                System.out.println("Thank you for using this ATM");
                break;
            default:
                System.out.println("Incorrect choice" + "\n");
                getDesiredAccount();
        }
    }
    public void getCurent() {
        System.out.println("Current account\n" +
                "Type 1: See the balance\n" +
                "Type 2: Withdraw funds\n" +
                "Type 3: Deposit funds\n" +
                "Type 4: Exit\n" +
                "Choose:");
        select = menu.nextInt();
        switch(select) {
            case 1:
                System.out.println("Savings account balance" + formatMoney.format(getCurrentAccount()));
                getDesiredAccount();
                break;
            case 2:
                withdrawalCurrentAccount();
                getDesiredAccount();
                break;
            case 3:
                CurrentAccountAdd();
                getDesiredAccount();
                break;
            case 4:
                getDesiredAccount();
                break;
            default:
                System.out.println("Incorrect choice" + "\n");
                getCurent();
        }
    }
    public void getSavings() {
        System.out.println("Savings account\n" +
                "Type 1: See the balance\n" +
                "Type 2: Withdraw funds\n" +
                "Type 3: Deposit funds\n" +
                "Type 4: Exit\n" +
                "Choose:");
        select = menu.nextInt();
        switch(select) {
            case 1:
                System.out.println("Savings account balance" + formatMoney.format(getSavingsAccount()));
                getDesiredAccount();
                break;
            case 2:
                withdrawalSavingsAccount();
                getDesiredAccount();
                break;
            case 3:
                SavingsAccountAdd();
                getDesiredAccount();
                break;
            case 4:
                getDesiredAccount();
                break;
            default:
                System.out.println("Incorrect choice" + "\n");
                getSavings();
        }
    }
}

package com.revature.account;

import com.revature.exceptions.InvalidRequestException;

public class Account {

    public int accountId;
    private AccountTypes accountType;
    private double balance;

    public Account(){

    }

    public Account(double balance,AccountTypes accountType){
        this.balance=balance;
        this.accountType=accountType;
    }

    public Account( double balance,AccountTypes accountType,int accountId){
        this.accountId=accountId;
        this.accountType=accountType;
        this.balance=balance;
    }

    public double deposit(double amount){
        balance+= amount;
        return balance;
    }

    public double withdraw(double amount){
        if(amount>balance){
            System.err.println("Insufficient Funds!");
            System.out.print("current balance: ");
            return balance;

        }
            balance-=amount;
            return balance;
    }

    public double transfer(double amount){
        if(amount>balance){
            System.err.println("Insufficient Funds!");
            System.out.print("current balance: ");
            return balance;

        }
        return amount;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public AccountTypes getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountTypes accountType) {
        this.accountType = accountType;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}

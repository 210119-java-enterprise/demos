package com.revature.screens;

import com.revature.account.Account;
import com.revature.account.AccountTypes;
import com.revature.repo.AccountRepository;
import com.revature.services.AccountService;

import static com.revature.BankingApp.app;

public class TransactionScreen extends Screen{
    public TransactionScreen() {
        super("Transaction","/transaction");
    }
    AccountRepository accountRepository;

    //render that
    @Override
    public void render() {

        Account account;
        AccountService accountService = null;

        System.out.println("+---------------------+");
        System.out.println(" Deposit or withdraw from your account");
        System.out.println("1) Deposit");
        System.out.println("2) Withdraw");
        System.out.println("3) Exit application");

        System.out.print("> ");

        try {
            String selection = app().getConsole().readLine();
            System.out.println("Enter transaction amount");
            String transaction=app().getConsole().readLine();
            double amount=Double.parseDouble(transaction);
            switch(selection){
                case "1":
                    accountService.Deposit(amount);
                    System.out.println("your deposit of "+amount+" has been added to your account");

                    break;
                case"2":
                    accountService.Withdraw(amount);
                    System.out.println("You withdrew "+amount+" from your account");

                    break;
                case"3":
                    System.out.println("Exiting Application");
                    app().setAppRunning(false);
                    break;

                default:
                    System.out.println("Invalid selection");
            }


        }catch(Exception e){
            e.printStackTrace();
            System.err.println("Shutting down application");
            app().setAppRunning(false);

        }
    }
}

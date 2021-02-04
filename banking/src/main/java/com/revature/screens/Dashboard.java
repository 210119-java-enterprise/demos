package com.revature.screens;

import com.revature.repo.AccountRepository;
import com.revature.services.AccountService;

import static com.revature.BankingApp.app;

public class Dashboard extends Screen{

    public Dashboard(){
        super("Dashboard","/dashboard");
    }

    @Override
    public void render() {
        AccountRepository accountRepository=new AccountRepository();
        AccountService accountService=new AccountService(accountRepository);

        System.out.println("+---------------------+");
        System.out.println("Welcome to the Dashboard");
        System.out.println("1) Open new account");
        System.out.println("2) deposit to an account");
        System.out.println("3) withdraw from an account");
        System.out.println("4) View current balance");
        System.out.println("5) Exit back to homeScreen");

        try{
            System.out.print("> ");
            String userSelection=app().getConsole().readLine();
            String transaction;
            double amount;
            switch(userSelection){

                case "1":
                    System.out.println("Creating new account");
                    app().getRouter().navigate("/accountType");
                    break;
                case "2":

                    System.out.println("Enter transaction amount");
                    System.out.print("> ");
                     transaction=app().getConsole().readLine();
                     amount=Double.parseDouble(transaction);


                    accountService.Deposit(amount);
                    System.out.println("your deposit of "+amount+" has been added to your account");

                    break;
                case "3":

                    System.out.println("Enter transaction amount");
                    transaction=app().getConsole().readLine();
                      amount=Double.parseDouble(transaction);
                    accountService.Withdraw(amount);

                    System.out.println("You Withdrew "+ amount+" from your account");
                    break;

                case "4":
                        accountService.viewAccount();
                        break;
                case "5":
                    System.out.println("Navigating back to HomeScreen");
                    app().getRouter().navigate("/home");
                    break;
                default:
                    System.out.println("Invalid selection!");
            }

            System.out.println("what else would you like to do?");
            app().getRouter().navigate("/dashboard");


        }catch(Exception e){
            e.printStackTrace();
            System.out.println("would you like to do something else?");
            app().getRouter().navigate("/dashboard");
        }


    }
}

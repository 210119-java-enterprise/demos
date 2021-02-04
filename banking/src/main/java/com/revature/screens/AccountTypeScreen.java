package com.revature.screens;

import com.revature.account.Account;
import com.revature.account.AccountTypes;
import com.revature.repo.AccountRepository;
import com.revature.services.AccountService;

import static com.revature.BankingApp.app;

public class AccountTypeScreen extends Screen{

    AccountRepository accountRepository= new AccountRepository();

    public AccountTypeScreen(){
        super("AccountType","/accountType");
    }

    //render that
    @Override
    public void render() {

       Account account=new Account();
       AccountTypes accountType = null;
       String myBalance;
        double initialBalance = 0;
        System.out.println("+---------------------+");
        System.out.println("welcome, please select the type of account you would like to create");
        System.out.println("1) Checking Account");
        System.out.println("2) Savings Account");
        System.out.println("3) Exit application");

        System.out.print("> ");

        try {
            String selection = app().getConsole().readLine();


            switch(selection){
                case "1":
                    System.out.println("Enter in your Starting Balance");
                    myBalance =app().getConsole().readLine();
                    initialBalance=Double.parseDouble(myBalance);
                    account.setBalance(initialBalance);
                    accountType=AccountTypes.CHECKING_ACCOUNT;
                    
                    break;
                case"2":
                    System.out.println("Enter in your Starting Balance");
                    myBalance =app().getConsole().readLine();
                    initialBalance=Double.parseDouble(myBalance);
                    account.setBalance(initialBalance);
                    accountType=AccountTypes.SAVINGS_ACCOUNT;
                    
                    break;
                case"3":
                    System.out.println("Exiting Application");
                    app().setAppRunning(false);
                    break;

                default:
                    System.out.println("Invalid selection");
            }


                account=new Account(initialBalance,accountType);

                accountRepository.save(account);

                 app().getRouter().navigate("/dashboard");

        }catch(Exception e){
            e.printStackTrace();
            System.err.println("Shutting down application");
            app().setAppRunning(false);

        }
    }
}

package com.revature.services;

import com.revature.account.Account;
import com.revature.exceptions.InvalidAccountException;
import com.revature.repo.AccountRepository;

import static com.revature.BankingApp.app;


public class AccountService {

    /*
    withdraw
    deposit
    view
     */

    private AccountRepository accRepo;

   private Account account=new Account();

    public AccountService(AccountRepository accRepo) {
        this.accRepo = accRepo;
    }

    public void Deposit(double amount){

        account = accRepo.findById(app().getCurrentSession().getSessionUser().getId());
        account.setBalance(account.getBalance()+amount);
         accRepo.update(account);
    }

   public void Withdraw(double amount){
       account = accRepo.findById(app().getCurrentSession().getSessionUser().getId());
       account.setBalance(account.getBalance()-amount);
       accRepo.update(account);

    }

    public void createAccount(Account account){
        if(!isValid(account)) {
            throw new InvalidAccountException("Account not saved");
        }


            accRepo.save(account);
    }

    public boolean isValid(Account account){
        return (account.getBalance()>=0);
    }

    public void viewAccount(){
        account = accRepo.findById(app().getCurrentSession().getSessionUser().getId());
        System.out.println("");
        System.out.println("your current balance is: "+account.getBalance());
        System.out.println("");


    }

}

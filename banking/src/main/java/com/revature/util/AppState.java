package com.revature.util;

import com.revature.account.Account;
import com.revature.models.AppUser;
import com.revature.repo.AccountRepository;
import com.revature.repo.UserRepository;
import com.revature.screens.*;
import com.revature.services.AccountService;
import com.revature.services.UserService;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class AppState {

    private BufferedReader console;
    private ScreenRouter router;
    private Session currentSession;
    private boolean appRunning;
    private Account account;
    private AppUser appUser;
    private int id;


    public AppState() {

        System.out.println("[LOG] - Initializing application...");

        this.appRunning = true;
        this.console = new BufferedReader(new InputStreamReader(System.in));

        final UserRepository userRepo = new UserRepository();
        final UserService userService = new UserService(userRepo);


        final AccountRepository accountRepository=new AccountRepository();
        final AccountService accountService=new AccountService(accountRepository);
        AppUser appUser= new AppUser();
        Account account=new Account();


        router = new ScreenRouter();
        router.addScreen(new HomeScreen())
                .addScreen(new RegisterScreen(userService))
                .addScreen(new LoginScreen(userService))
                .addScreen(new Dashboard())
                .addScreen(new AccountTypeScreen())
                .addScreen(new TransactionScreen());

        System.out.println("[LOG] - Application initialized");

    }
    public int getId(){ return id; }

    public int setId(int id){ return this.id=id; }

    public AppUser getAppUser(){ return appUser; }

    public void setAppUser(AppUser appUser){
        this.appUser=appUser;
    }

    public Account getAccount(){ return account; }

    public void setAccount(Account account){
        this.account=account;
    }

    public BufferedReader getConsole() {
        return console;
    }

    public ScreenRouter getRouter() {
        return router;
    }

    public boolean isAppRunning() {
        return appRunning;
    }

    public void setAppRunning(boolean appRunning) {
        this.appRunning = appRunning;
    }

    public Session getCurrentSession() {
        return currentSession;
    }

    public void setCurrentSession(Session currentSession) {
        this.currentSession = currentSession;
    }

    public void invalidateCurrentSession() {
        this.currentSession = null;
    }

    public boolean isSessionValid() {
        return (this.currentSession != null);
    }



}
package org.marianaduarte.tema16;

public class BankAccount {
    private final String accountName;

    public BankAccount(String accountName){
        this.accountName = accountName;
    }

    public String getAccountName(){
        return this.accountName;
    }

    public void deposit(double value){
        System.out.println("Deposito de R$"+value+" realizado!");
    }

    public void draft(double value){
        System.out.println("Saque de R$"+value+" realizado!");
    }


    }


package org.marianaduarte.tema16;

public class Main {
    public static void main(String[] args) {

        BankAccount mariBankAccount = new BankAccount("Conta Bancaria da Mari");
        Bank bank = new Bank(mariBankAccount);

        bank.deposit(1000);
        bank.draft(100);
        System.out.println(bank.accountStatement());

        BankAccount pedroBankAccount = new BankAccount("Conta Bancaria do Pedro");
        bank = new Bank(pedroBankAccount);

        bank.deposit(100);
        bank.draft(50);
        System.out.println(bank.accountStatement());
    }
}
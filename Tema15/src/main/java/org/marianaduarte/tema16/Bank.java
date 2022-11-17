package org.marianaduarte.tema16;

import java.util.ArrayList;

public class Bank {
    private static ArrayList<Command> commandList;
    private final BankAccount bankAccount;
    public Bank(BankAccount bankAccount){
        this.bankAccount = bankAccount;
        commandList = new ArrayList<>();
    }

    public boolean deposit(double value){
        if(value > 0){
            DepositCommand deposit = new DepositCommand(bankAccount, value);
            commandList.add(deposit);
            deposit.execute();
            return true;
        }
        else{
            throw new IllegalArgumentException("O valor para deposito não pode ser negativo!");
        }
    }

    public boolean draft( double value){
        if(value >= 0 && value <= checkBalance()){
            DraftCommand draft = new DraftCommand(bankAccount,value);
            commandList.add(draft);
            draft.execute();
            return true;
        }
        else{
            throw new IllegalArgumentException("O valor para saque não pode ser negativo nem maior que o saldo disponivel!");
        }
    }

    public String accountStatement(){
        StringBuilder statement = new StringBuilder();
        statement.append("\n---- Extrato Bancário da ").append(bankAccount.getAccountName()).append("----\n");
        for(Command command:  commandList){
            statement.append(command.commandDescription());
        }
        statement.append("\n---- Saldo: R$").append(checkBalance()).append(" ----\n");

        return statement.toString();
    }

    public double checkBalance(){
        double balance = 0;
        for(Command command:commandList) {
            balance += command.getValue();
        }
        return balance;
    }
}

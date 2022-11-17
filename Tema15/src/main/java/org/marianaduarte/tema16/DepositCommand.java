package org.marianaduarte.tema16;

public class DepositCommand implements Command{

    private final BankAccount bankAccount;
    private final double value;

    public DepositCommand(BankAccount bankAccount,double value){
        this.bankAccount = bankAccount;
        this.value = value;
    }

    @Override
    public void execute() {
        this.bankAccount.deposit(this.value);
    }

    @Override
    public double getValue(){
        return this.value;
    }
    @Override
    public String commandDescription() {
        return "Deposito de R$:"+this.value+"\n";
    }
}

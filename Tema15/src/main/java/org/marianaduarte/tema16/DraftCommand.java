package org.marianaduarte.tema16;

public class DraftCommand implements Command{
    private final BankAccount bankAccount;
    private final double value;
    public DraftCommand(BankAccount bankAccount, double value){
        this.bankAccount = bankAccount;
        this.value = value;
    }

    @Override
    public void execute() {
        this.bankAccount.draft(this.value);
    }

    @Override
    public double getValue(){
        return -this.value;
    }

    @Override
    public String commandDescription() {
        return "Saque de R$:"+this.value+"\n";
    }
}

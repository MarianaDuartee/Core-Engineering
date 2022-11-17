package org.marianaduarte.tema16;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BankAccountTest {

    private BankAccount bankAccountTest;
    private Bank bankTest;

    @BeforeEach
    public void setUp(){
        bankAccountTest = new BankAccount("Conta Bancaria Teste");
        bankTest = new Bank(bankAccountTest);
    }

    @Test
    public void shouldNotAllowNegativeValuesOfDeposit(){
        double valueDeposit = -100;
        assertThrows(IllegalArgumentException.class,()->bankTest.deposit(valueDeposit));
    }

    @Test
    public void shouldRealizeDeposit(){
        double valueDeposit = 1000;
        assertTrue(bankTest.deposit(valueDeposit));
        assertEquals(valueDeposit,bankTest.checkBalance());
    }

    @Test
    public void shouldNotAllowNegativeOrInvalidValuesOfDraft(){
        double valueDeposit = 100;
        bankTest.deposit(valueDeposit);
        assertThrows(IllegalArgumentException.class,()->bankTest.draft(-100));
        assertThrows(IllegalArgumentException.class,()->bankTest.draft(150));
    }

    @Test
    public void shouldRealizeDraft(){
        double valueDeposit = 100;
        bankTest.deposit(valueDeposit);

        double valueDraft = 90;
        assertTrue(bankTest.draft(valueDraft));
        assertEquals(valueDeposit-valueDraft,bankTest.checkBalance());
    }

    @Test
    public void bankAccountTest(){
        double valueDeposit = 1000;
        double valueDraft = 100;

        double balance = (valueDeposit)-(valueDraft);
        bankTest.deposit(valueDeposit);
        bankTest.draft(valueDraft);

        assertEquals(balance,bankTest.checkBalance());
    }
}

package br.com.salvador.atm.application.domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;
import java.math.BigInteger;

class BankAccountTest {
    @Test
    void testGetBalance(){
        BankAccount account = new BankAccount(new BigInteger("500"));
        BigInteger balance = account.getBalance();
        assertThat(balance).isEqualTo(new BigInteger("500"));
    }

   @Test
    void testDeposit(){
        BankAccount account = new BankAccount(new BigInteger("500"));
        account.deposit(new BigInteger("100"));
        BigInteger balance = account.getBalance();
        assertThat(balance).isEqualTo(new BigInteger("600"));
    }

    @Test
    void testWithdraw(){
        BankAccount account = new BankAccount(new BigInteger("500"));
        account.withdraw(new BigInteger("100"));
        BigInteger balance = account.getBalance();
        assertThat(balance).isEqualTo(new BigInteger("400"));
    }
}

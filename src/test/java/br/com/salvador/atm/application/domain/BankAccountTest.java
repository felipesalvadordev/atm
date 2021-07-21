package br.com.salvador.atm.application.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;
import java.math.BigInteger;

class BankAccountTest {

    private BankAccount account;

    @BeforeEach
    void setup(){
        account = new BankAccount(new BigInteger("500"));
    }

    @Test
    void testGetBalance(){
        BigInteger balance = account.getBalance();
        assertThat(balance).isEqualTo(new BigInteger("500"));
    }

   @Test
    void testDeposit(){
        account.deposit(new BigInteger("100"));
        BigInteger balance = account.getBalance();
        assertThat(balance).isEqualTo(new BigInteger("600"));
    }

    @Test
    void testWithdraw(){
        account.withdraw(new BigInteger("100"));
        BigInteger balance = account.getBalance();
        assertThat(balance).isEqualTo(new BigInteger("400"));
    }
}

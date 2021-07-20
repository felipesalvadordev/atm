package br.com.salvador.atm.application.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.math.BigInteger;
@Entity
@RequiredArgsConstructor
public class BankAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Getter
    private BigInteger balance;

    public BankAccount(BigInteger balance) {
        this.balance = balance;
    }

    public void withdraw(BigInteger amount) {
        balance = balance.subtract(amount);
    }

    public void deposit(BigInteger amount) {
        balance = balance.add(amount);
    }

    public BigInteger getBalance()
    {
        return this.balance;
    }
}

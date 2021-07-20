package br.com.salvador.atm.application.domain.data;

import lombok.Getter;
import lombok.NonNull;

import java.math.BigInteger;

public class AccountBalanceDTO {
    public AccountBalanceDTO(@NonNull BigInteger balance)
    {
        this.balance = balance;
    }
    @Getter private BigInteger balance;
}

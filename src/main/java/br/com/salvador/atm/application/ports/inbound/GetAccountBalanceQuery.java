package br.com.salvador.atm.application.ports.inbound;

import java.math.BigInteger;

public interface GetAccountBalanceQuery {
    BigInteger getAccountBalance(Long accountID);
}

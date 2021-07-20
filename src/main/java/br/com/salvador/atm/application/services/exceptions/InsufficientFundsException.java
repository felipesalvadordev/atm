package br.com.salvador.atm.application.services.exceptions;

import java.math.BigDecimal;
import java.math.BigInteger;

public class InsufficientFundsException extends RuntimeException {

    public InsufficientFundsException(BigInteger balance) {
        super(String.format("Insufficient Funds. Your balance is %s", balance));
    }
}

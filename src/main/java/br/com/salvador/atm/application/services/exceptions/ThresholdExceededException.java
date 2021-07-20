package br.com.salvador.atm.application.services.exceptions;

import java.math.BigDecimal;
import java.math.BigInteger;

public class ThresholdExceededException extends RuntimeException {

    public ThresholdExceededException(BigInteger threshold) {
        super(String.format("Maximum threshold for withdraw exceeded. The threshold is %s!", threshold));
    }
}
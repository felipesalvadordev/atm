package br.com.salvador.atm.application.ports.inbound;

import java.math.BigInteger;

public interface DepositUseCase     {
    void deposit(Long id, BigInteger amount);
}

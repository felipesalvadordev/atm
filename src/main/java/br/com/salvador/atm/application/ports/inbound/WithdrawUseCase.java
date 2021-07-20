package br.com.salvador.atm.application.ports.inbound;

import java.math.BigInteger;

public interface WithdrawUseCase {
    void withdraw(Long id, BigInteger amount);
}

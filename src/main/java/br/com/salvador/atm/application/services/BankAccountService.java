package br.com.salvador.atm.application.services;

import br.com.salvador.atm.application.domain.BankAccount;
import br.com.salvador.atm.application.ports.inbound.DepositUseCase;
import br.com.salvador.atm.application.ports.inbound.GetAccountBalanceQuery;
import br.com.salvador.atm.application.ports.inbound.WithdrawUseCase;
import br.com.salvador.atm.application.ports.outbound.LoadAccountPort;
import br.com.salvador.atm.application.ports.outbound.SaveAccountPort;
import br.com.salvador.atm.application.services.exceptions.InsufficientFundsException;
import br.com.salvador.atm.application.services.exceptions.ThresholdExceededException;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class BankAccountService implements DepositUseCase, WithdrawUseCase, GetAccountBalanceQuery {

    private final LoadAccountPort loadAccountPort;
    private final SaveAccountPort saveAccountPort;

    public BankAccountService(LoadAccountPort loadAccountPort, SaveAccountPort saveAccountPort) {
        this.loadAccountPort = loadAccountPort;
        this.saveAccountPort = saveAccountPort;
    }

    @Override
    public BigInteger getAccountBalance(Long accountID) {
        Optional<BankAccount> account = Optional.ofNullable(loadAccountPort.load(accountID));
        BigInteger balance = account.get().getBalance();
        return balance;
    }

    @Override
    public void deposit(Long id, BigInteger amount) {
        BankAccount account = loadAccountPort.load(id);
        account.deposit(amount);
        saveAccountPort.save(account);
    }

    @Override
    public void withdraw(Long id, BigInteger amount) {
        verifyThreshold(amount);
        verifyBalance(id, amount);
        BankAccount account = loadAccountPort.load(id);
        account.withdraw(amount);
        saveAccountPort.save(account);
    }

    private void verifyBalance(Long accountID, BigInteger amount){
        Optional<BankAccount> account = Optional.ofNullable(loadAccountPort.load(accountID));

        BigInteger accountBalance = account.get().getBalance();

        if (accountBalance.compareTo(amount) < 0) {
            throw new InsufficientFundsException(accountBalance);
        }
    }

    private void verifyThreshold(BigInteger amount){
        if(amount.compareTo(new BigInteger("1000")) >= 0) {
            throw new ThresholdExceededException(new BigInteger("1000"));
        }
    }
}

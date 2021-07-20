package br.com.salvador.atm.application.ports.outbound;

import br.com.salvador.atm.application.domain.BankAccount;

public interface SaveAccountPort {
    void save(BankAccount account);
}

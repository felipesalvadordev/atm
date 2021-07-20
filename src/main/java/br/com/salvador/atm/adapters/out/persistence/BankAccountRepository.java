package br.com.salvador.atm.adapters.out.persistence;

import br.com.salvador.atm.application.domain.BankAccount;
import br.com.salvador.atm.application.ports.outbound.LoadAccountPort;
import br.com.salvador.atm.application.ports.outbound.SaveAccountPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityNotFoundException;

@Component
public class BankAccountRepository implements LoadAccountPort, SaveAccountPort {

    private final SpringDataBankAccountRepository repository;

    @Autowired
    public BankAccountRepository(SpringDataBankAccountRepository repository) {
        this.repository = repository;
    }

    @Override
    public BankAccount load(Long id) {
        return repository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public void save(BankAccount bankAccount) {
        repository.save(bankAccount);
    }
}

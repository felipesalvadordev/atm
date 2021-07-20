package br.com.salvador.atm.adapters.out.persistence;

import br.com.salvador.atm.application.domain.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpringDataBankAccountRepository extends JpaRepository<BankAccount, Long> {
}

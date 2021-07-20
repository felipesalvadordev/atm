package br.com.salvador.atm.adapters.in.web;

import br.com.salvador.atm.application.domain.data.AccountBalanceDTO;
import br.com.salvador.atm.application.ports.inbound.DepositUseCase;
import br.com.salvador.atm.application.ports.inbound.GetAccountBalanceQuery;
import br.com.salvador.atm.application.ports.inbound.WithdrawUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.math.BigInteger;

@RestController
@RequestMapping("/bankaccount")
public class BankAccountController {

    private final DepositUseCase depositUseCase;
    private final WithdrawUseCase withdrawUseCase;
    private final GetAccountBalanceQuery getAccountBalanceQuery;

    public BankAccountController(DepositUseCase depositUseCase, WithdrawUseCase withdrawUseCase, GetAccountBalanceQuery getAccountBalanceQuery) {
        this.depositUseCase = depositUseCase;
        this.withdrawUseCase = withdrawUseCase;
        this.getAccountBalanceQuery = getAccountBalanceQuery;
    }

    @PostMapping(value = "/{id}/deposit/{amount}")
    ResponseEntity<Void> deposit(@PathVariable final Long id, @PathVariable final BigInteger amount) {
        depositUseCase.deposit(id, amount);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping(value = "/{id}/withdraw/{amount}")
    ResponseEntity<Void> withdraw(@PathVariable final Long id, @PathVariable final BigInteger amount) {
        withdrawUseCase.withdraw(id, amount);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = "/{id}/balance")
    public ResponseEntity<AccountBalanceDTO> getAccountBalance(Long id) {
        try {
            BigInteger balance = getAccountBalanceQuery.getAccountBalance(id);
            AccountBalanceDTO accountDTO = new AccountBalanceDTO(balance);
            return new ResponseEntity<>(accountDTO, HttpStatus.OK);
        }
        catch (EntityNotFoundException ex){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

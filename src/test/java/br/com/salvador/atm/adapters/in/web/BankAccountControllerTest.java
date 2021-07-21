package br.com.salvador.atm.adapters.in.web;

import br.com.salvador.atm.adapters.out.persistence.BankAccountRepository;
import br.com.salvador.atm.application.ports.inbound.DepositUseCase;
import br.com.salvador.atm.application.ports.inbound.GetAccountBalanceQuery;
import br.com.salvador.atm.application.ports.inbound.WithdrawUseCase;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.math.BigInteger;

import static org.mockito.BDDMockito.*;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = BankAccountController.class)
class BankAccountControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DepositUseCase depositUseCase;

    @MockBean
    private WithdrawUseCase withdrawUseCase;

    @MockBean
    private GetAccountBalanceQuery getAccountBalanceQuery;

    @MockBean
    private BankAccountRepository bankAccountRepository;

    private ObjectMapper objectMapper = new ObjectMapper();

    @Test
    void testDeposit() throws Exception{

        mockMvc.perform(MockMvcRequestBuilders.post("/bankaccount/{id}/deposit/{amount}", 1, 100))
                .andExpect(status().isOk());

        verify(depositUseCase, only()).deposit(1L, new BigInteger("100"));
    }

    @Test
    void testWithdraw() throws Exception{

        mockMvc.perform(MockMvcRequestBuilders.post("/bankaccount/{id}/withdraw/{amount}", 1, 100))
                .andExpect(status().isOk());

        then(withdrawUseCase).should().withdraw(1L, new BigInteger("100"));
    }
}

package br.com.salvador.atm;

import br.com.salvador.atm.adapters.out.persistence.BankAccountRepository;
import br.com.salvador.atm.application.domain.BankAccount;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;

import java.math.BigInteger;

@SpringBootApplication
public class AtmApplication {

	public static void main(String[] args) {
		SpringApplication.run(AtmApplication.class, args);
	}

	@Bean
	public CommandLineRunner bootstrapData(BankAccountRepository repository) {
		return (args) -> {
			BigInteger initialBalance = BigInteger.valueOf(10000);
			BankAccount bankAccount = new BankAccount(initialBalance);
			repository.save(bankAccount);
		};
	}
}



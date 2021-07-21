#ATM Spring Boot API arquitetura hexagonal

#Anatomia do projeto

In Adapters (Web)
- BankAccountController
- BankAccountService

Out Adapters (Persistence)
- BankAccountRepository

In Port 
- DepositUseCase
- WithdrawUseCase
- GetAccountBalanceQuery

Out Port 
- LoadAccountPort
- SaveAccountPort

Domain
- BankAccount

Java 11/Spring Boot 2.5.2/Lombok/H2 Database

#Testes
Junit/MockMvc/MockBean/WebMvcTest

Referências: 

https://jivimberg.io/blog/2020/02/01/hexagonal-architecture-on-spring-boot/

https://reflectoring.io/spring-hexagonal/


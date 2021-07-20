#ATM operations Spring Boot API in hexagonal architecture

#Project Anatomy

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


Java 11
Spring Boot 2.5.2
Lombok
H2 Database

References: 

https://jivimberg.io/blog/2020/02/01/hexagonal-architecture-on-spring-boot/

https://reflectoring.io/spring-hexagonal/


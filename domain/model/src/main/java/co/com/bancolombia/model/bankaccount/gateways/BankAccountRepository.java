package co.com.bancolombia.model.bankaccount.gateways;

import co.com.bancolombia.model.bankaccount.BankAccount;
import reactor.core.publisher.Mono;

import java.util.List;

public interface BankAccountRepository {

    Mono<BankAccount> findById(String id);
    Mono<List<BankAccount>> findAll();
    Mono<BankAccount> save(String accountName);
}

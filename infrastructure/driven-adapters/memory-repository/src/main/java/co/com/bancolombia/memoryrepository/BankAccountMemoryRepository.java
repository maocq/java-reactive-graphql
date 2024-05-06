package co.com.bancolombia.memoryrepository;

import co.com.bancolombia.model.bankaccount.BankAccount;
import co.com.bancolombia.model.bankaccount.gateways.BankAccountRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.List;
import java.util.UUID;

@Repository
public class BankAccountMemoryRepository implements BankAccountRepository {

    @Override
    public Mono<BankAccount> findById(String id) {
        var bankAccount = BankAccount.builder().id(id).userName("Foo").balance(100f).build();
        return Mono.just(bankAccount)
                .delayElement(Duration.ofMillis(100));
    }

    @Override
    public Mono<List<BankAccount>> findAll() {
        var bankAccount = BankAccount.builder().id(UUID.randomUUID().toString()).userName("Foo").balance(100f).build();
        return Mono.just(List.of(bankAccount))
                .delayElement(Duration.ofMillis(200));
    }

    @Override
    public Mono<BankAccount> save(String userName) {
        var bankAccount = BankAccount.builder()
                .id(UUID.randomUUID().toString())
                .userName(userName)
                .balance(0f).build();
        return Mono.just(bankAccount)
                .delayElement(Duration.ofMillis(100));
    }
}

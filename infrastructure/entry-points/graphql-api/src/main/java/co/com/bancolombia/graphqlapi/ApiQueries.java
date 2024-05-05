package co.com.bancolombia.graphqlapi;

import co.com.bancolombia.model.bankaccount.BankAccount;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.List;
import java.util.UUID;


@RequiredArgsConstructor
@Controller
public class ApiQueries{

    @QueryMapping
    public Mono<BankAccount> getBankAccount(@Argument("id") String id) {
        return Mono.just(BankAccount
                .builder()
                .id(id)
                .userName("Foo")
                .balance(100F).build())
                .delayElement(Duration.ofMillis(100));
    }

    @QueryMapping
    public Mono<List<BankAccount>> getBankAccounts() {
        return Mono.just(List.of(BankAccount
                .builder()
                .id(UUID.randomUUID().toString())
                .userName("Foo")
                .balance(100F).build()))
                .delayElement(Duration.ofMillis(100));
    }
}
package co.com.bancolombia.graphqlapi;

import co.com.bancolombia.model.bankaccount.BankAccount;
import co.com.bancolombia.model.bankaccount.gateways.BankAccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Mono;

import java.util.List;


@RequiredArgsConstructor
@Controller
public class ApiQueries{

    private final BankAccountRepository bankAccountRepository;

    @QueryMapping
    @PreAuthorize("hasRole('foo')")
    public Mono<BankAccount> getBankAccount(@Argument("id") String id) {
        return bankAccountRepository.findById(id);
    }

    @QueryMapping
    public Mono<List<BankAccount>> getBankAccounts() {
        return bankAccountRepository.findAll();
    }
}
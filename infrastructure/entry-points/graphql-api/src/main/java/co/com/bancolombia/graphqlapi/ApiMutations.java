package co.com.bancolombia.graphqlapi;

import co.com.bancolombia.dtos.NewBankAccountInput;
import co.com.bancolombia.model.bankaccount.BankAccount;
import co.com.bancolombia.model.bankaccount.gateways.BankAccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@Controller
public class ApiMutations {

    private final BankAccountRepository bankAccountRepository;

    @MutationMapping
    public Mono<BankAccount> addBankAccount(@Argument("newBankAccountInput") NewBankAccountInput bankAccount) {
        return bankAccountRepository.save(bankAccount.userName());
    }
}

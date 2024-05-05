package co.com.bancolombia.api;

import co.com.bancolombia.model.bankaccount.gateways.BankAccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class Handler {

    private final BankAccountRepository bankAccountRepository;

    public Mono<ServerResponse> listenBankAccounts(ServerRequest serverRequest) {
        return bankAccountRepository.findAll()
                .flatMap(response -> ServerResponse.ok().bodyValue(response));
    }

    public Mono<ServerResponse> listenBankAccount(ServerRequest serverRequest) {
        return bankAccountRepository.findById("id")
                .flatMap(response -> ServerResponse.ok().bodyValue(response));
    }
}

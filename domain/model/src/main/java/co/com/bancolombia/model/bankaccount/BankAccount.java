package co.com.bancolombia.model.bankaccount;
import lombok.*;

@Builder(toBuilder = true)
public record BankAccount(String id, String userName, Float balance) {}
package co.com.bancolombia.dtos;

import lombok.Builder;

@Builder(toBuilder = true)
public record NewBankAccountInput(String userName) { }

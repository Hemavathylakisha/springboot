package com.Bank.BankingApplication.Dto.Transaction;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DepositRequestDTO {
    @NotNull(message="Amount should be filled to deposit")
    @Min(value=1, message="Please enter deposit amount")
    private Double amount;
}

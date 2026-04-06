package com.Bank.BankingApplication.Dto.Account;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AccountRequestDTO {
    @NotBlank(message="Name should not be empty or null")
    private String name;

    @NotNull(message = "Balance should not be null")
    @Min(message="Balance should be maintained with minimum",value=1000)
    private Double amount;
}

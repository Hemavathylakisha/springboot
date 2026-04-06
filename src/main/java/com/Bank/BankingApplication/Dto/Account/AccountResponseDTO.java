package com.Bank.BankingApplication.Dto.Account;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AccountResponseDTO {
    private String accountId;
    private String name;
    private Double amount;
    private LocalDateTime createdDate;
}

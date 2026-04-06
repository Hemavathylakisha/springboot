package com.Bank.BankingApplication.Dto.Transaction;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TransactionResponseDTO {
    private String transactionId;
    private String type;
    private Double amount;
    private LocalDateTime date;
    private String message;
}

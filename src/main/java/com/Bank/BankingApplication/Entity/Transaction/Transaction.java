package com.Bank.BankingApplication.Entity.Transaction;

import com.Bank.BankingApplication.Entity.Account.Account;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Transaction {

    @Id
    private String transactionId;

    @Enumerated(EnumType.STRING)
    private TransactionType type;
    private Double amount;
    private LocalDateTime date;
    private String message;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="accountId")
    private Account account;
}

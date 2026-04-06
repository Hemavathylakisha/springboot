package com.Bank.BankingApplication.Entity.Account;

import com.Bank.BankingApplication.Entity.Transaction.Transaction;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Account {
    @Id
    private String accountId;
    private String name;
    private Double amount;
    private LocalDateTime CreatedDate;

    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Transaction> transaction;
}

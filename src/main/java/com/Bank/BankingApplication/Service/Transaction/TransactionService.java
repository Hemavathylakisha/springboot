package com.Bank.BankingApplication.Service.Transaction;

import com.Bank.BankingApplication.Dto.Transaction.TransactionResponseDTO;
import com.Bank.BankingApplication.Entity.Transaction.Transaction;
import com.Bank.BankingApplication.Entity.Transaction.TransactionType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TransactionService {
    //deposit
    TransactionResponseDTO deposit(String id, Double amount);

    //withdraw
    TransactionResponseDTO withdraw(String accountId, Double amount);

    //transfer
    void transfer(String fromId, String toId, Double amount);

    Page<TransactionResponseDTO> getAllTransactions(String accountId, Pageable pageable);

    Page<TransactionResponseDTO> getByType(
            String accountId,
            TransactionType type,
            Pageable pageable);
}

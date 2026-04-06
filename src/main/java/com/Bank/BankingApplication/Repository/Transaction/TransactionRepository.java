package com.Bank.BankingApplication.Repository.Transaction;

import com.Bank.BankingApplication.Entity.Transaction.Transaction;
import com.Bank.BankingApplication.Entity.Transaction.TransactionType;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, String> {

    Page<Transaction> findByAccountAccountId(String accountId, Pageable pageable);

    Page<Transaction> findByAccountAccountIdAndType(
            String accountId,
            TransactionType type,
            Pageable pageable);
}

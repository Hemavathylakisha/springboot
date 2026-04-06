package com.Bank.BankingApplication.Mapper.Transaction;

import com.Bank.BankingApplication.Dto.Transaction.DepositRequestDTO;
import com.Bank.BankingApplication.Dto.Transaction.TransactionResponseDTO;
import com.Bank.BankingApplication.Entity.Account.Account;
import com.Bank.BankingApplication.Entity.Transaction.Transaction;
import com.Bank.BankingApplication.Entity.Transaction.TransactionType;
import com.Bank.BankingApplication.Util.IDGenerator.TransactionIdGenerator;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class TransactionMapper {

    public Transaction toDepositEntity(Account account,
                                       Double amount,
                                       String txnId) {

        return Transaction.builder()
                .transactionId(txnId)
                .account(account)
                .type(TransactionType.DEPOSIT)
                .amount(amount)
                .date(LocalDateTime.now())
                .message("Amount Deposited")
                .build();
    }

    public TransactionResponseDTO toDTO(Transaction txn) {

        return TransactionResponseDTO.builder()
                .transactionId(txn.getTransactionId())
                .type(txn.getType().name())
                .amount(txn.getAmount())
                .date(txn.getDate())
                .message(txn.getMessage())
                .build();
    }
    public Transaction toWithdrawEntity(Account account,Double amount,String txnId){
        return Transaction.builder()
                .transactionId(txnId)
                .account(account)
                .type(TransactionType.WITHDRAW)
                .amount(amount)
                .date(LocalDateTime.now())
                .message("Amount withdrawn")
                .build();

    }

    public Transaction toTransferDebitEntity(Account sender,
                                             Double amount,
                                             String toId,
                                             String txnId) {

        return Transaction.builder()
                .transactionId(txnId)
                .account(sender)
                .type(TransactionType.TRANSFER)
                .amount(amount)
                .date(LocalDateTime.now())
                .message("Transferred to " + toId)
                .build();
    }

    public Transaction toTransferCreditEntity(Account receiver,
                                              Double amount,
                                              String fromId,
                                              String txnId) {

        return Transaction.builder()
                .transactionId(txnId)
                .account(receiver)
                .type(TransactionType.TRANSFER)
                .amount(amount)
                .date(LocalDateTime.now())
                .message("Received from " + fromId)
                .build();
    }

    //transaction list - tofilter from transaction entity
    public TransactionResponseDTO mapToDTO(Transaction txn) {
        return TransactionResponseDTO.builder()
                .transactionId(txn.getTransactionId())
                .type(txn.getType().name())
                .amount(txn.getAmount())
                .date(txn.getDate())
                .message(txn.getMessage())
                .build();
    }
}
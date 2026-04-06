package com.Bank.BankingApplication.Service.Transaction;

import com.Bank.BankingApplication.Dto.Transaction.DepositRequestDTO;
import com.Bank.BankingApplication.Dto.Transaction.TransactionResponseDTO;
import com.Bank.BankingApplication.Entity.Account.Account;
import com.Bank.BankingApplication.Entity.Transaction.Transaction;
import com.Bank.BankingApplication.Entity.Transaction.TransactionType;
import com.Bank.BankingApplication.ExceptionHandling.BadRequestException;
import com.Bank.BankingApplication.ExceptionHandling.ResourceNotFoundException;
import com.Bank.BankingApplication.Mapper.Transaction.TransactionMapper;
import com.Bank.BankingApplication.Repository.Account.AccountRepository;
import com.Bank.BankingApplication.Repository.Transaction.TransactionRepository;
import com.Bank.BankingApplication.Util.IDGenerator.TransactionIdGenerator;
import jakarta.transaction.TransactionManager;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.util.IdGenerator;
import org.springframework.data.domain.Pageable;

import java.time.LocalDateTime;

@Service
public class TransactionServiceImplements implements TransactionService {

    @Autowired
    private AccountRepository accountRepo;
    @Autowired
    private TransactionRepository transactionRepo;
    @Autowired
    private TransactionMapper transactionMapper;

    @Override
    @Transactional
    public TransactionResponseDTO deposit(String accountId, Double amount) {

        //  1. Validation
        if (amount == null || amount <= 0) {
            throw new BadRequestException("Amount must be greater than 0");
        }

        //  2. Fetch account
        Account acc = accountRepo.findById(accountId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Account not found"));

        //  3. Update balance
        acc.setAmount(acc.getAmount() + amount);
        accountRepo.save(acc);

        //  4. Create transaction (NO DTO needed here)
        Transaction txn = transactionMapper.toDepositEntity(
                acc,
                amount,
                TransactionIdGenerator.generateId()
        );

        //  5. Save transaction
        transactionRepo.save(txn);

        // 6. Return response
        return transactionMapper.toDTO(txn);
    }

    @Override
    public TransactionResponseDTO withdraw(String accountId, Double amount) {
        //  1. Validation
        if (amount == null || amount <= 0) {
            throw new BadRequestException("Amount must be greater than 0");
        }

        //  2. Fetch account
        Account acc = accountRepo.findById(accountId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Account not found"));

        // 3.  throw exception while insufficient
        if(acc.getAmount() < amount){
            throw new BadRequestException("Insufficient balance");
        }

        // 4. withdraw - amount deduct
        acc.setAmount(acc.getAmount() - amount);
        accountRepo.save(acc);

        // 5. Transaction entry
        Transaction txn=transactionMapper.toWithdrawEntity(
                acc,
                amount,
                TransactionIdGenerator.generateId()
                );

        // 6. save transaction
        transactionRepo.save(txn);

        //return response
        return transactionMapper.toDTO(txn);
    }

    //transaction
    @Override
    @Transactional
    public void transfer(String fromId, String toId, Double amount) {

        //  1. Validation
        if (amount == null || amount <= 0) {
            throw new BadRequestException("Amount must be greater than 0");
        }

        if (fromId.equals(toId)) {
            throw new BadRequestException("Sender and receiver cannot be same");
        }

        //  2. Fetch sender
        Account sender = accountRepo.findById(fromId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Sender account not found"));

        //  3. Fetch receiver
        Account receiver = accountRepo.findById(toId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Receiver account not found"));

        //  4. Check balance
        if (sender.getAmount() < amount) {
            throw new BadRequestException("Insufficient balance");
        }

        //  5. Deduct & Add
        sender.setAmount(sender.getAmount() - amount);
        receiver.setAmount(receiver.getAmount() + amount);
        accountRepo.save(sender);
        accountRepo.save(receiver);

        //  6. Create transactions
        Transaction senderTxn = transactionMapper.toTransferDebitEntity(
                sender, amount, toId, TransactionIdGenerator.generateId()
        );

        Transaction receiverTxn = transactionMapper.toTransferCreditEntity(
                receiver, amount, fromId, TransactionIdGenerator.generateId()
        );

        //  7. Save transactions
        transactionRepo.save(senderTxn);
        transactionRepo.save(receiverTxn);
    }

    //  ALL transactions
    @Override
    public Page<TransactionResponseDTO> getAllTransactions(
            String accountId,
            Pageable pageable) {

        Pageable safePageable = PageRequest.of(
                pageable.getPageNumber(),
                Math.min(pageable.getPageSize(), 50), // limit size
                Sort.by("date").descending()
        );

        return transactionRepo
                .findByAccountAccountId(accountId, safePageable)
                .map(transactionMapper::toDTO);
    }

    //  FILTER BY TYPE
    @Override
    public Page<TransactionResponseDTO> getByType(
            String accountId,
            TransactionType type,
            Pageable pageable) {

        Pageable safePageable = PageRequest.of(
                pageable.getPageNumber(),
                Math.min(pageable.getPageSize(), 50),
                Sort.by("date").descending()
        );

        return transactionRepo
                .findByAccountAccountIdAndType(accountId, type, safePageable)
                .map(transactionMapper::toDTO);
    }

}
package com.Bank.BankingApplication.Service.Account;

import com.Bank.BankingApplication.Dto.Account.AccountRequestDTO;
import com.Bank.BankingApplication.Dto.Account.AccountResponseDTO;
import com.Bank.BankingApplication.Dto.Account.AccountUpdateDTO;
import com.Bank.BankingApplication.Entity.Account.Account;
import com.Bank.BankingApplication.ExceptionHandling.BadRequestException;
import com.Bank.BankingApplication.ExceptionHandling.DuplicateResourceException;
import com.Bank.BankingApplication.ExceptionHandling.ResourceNotFoundException;
import com.Bank.BankingApplication.ExceptionHandling.handleRuntime;
import com.Bank.BankingApplication.Mapper.Account.AccountMapper;
import com.Bank.BankingApplication.Repository.Account.AccountRepository;
import com.Bank.BankingApplication.Util.IDGenerator.AccountIdGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
public class AccountServiceImplements implements AccountService{
    @Autowired
    private AccountRepository accountrepo;

    @Override
    public AccountResponseDTO create(AccountRequestDTO dto) {

        //validate input with balance
        if (dto.getAmount() < 0) {
            throw new BadRequestException("Balance cannot be negative");
        }
        String id = AccountIdGenerator.generateId();
        //check duplicate
        if (accountrepo.existsById(id)) {
            throw new DuplicateResourceException("Account ID already exists");
        }

        Account account = Account.builder()
                .accountId(id)
                .name(dto.getName())
                .amount(dto.getAmount())
                .CreatedDate(LocalDateTime.now())
                .build();
        try {
            accountrepo.save(account);
        } catch (Exception e) {
            throw new handleRuntime("Error while create an account");
        }
        return AccountMapper.toDTO(account);
    }

    @Override
    public AccountResponseDTO getAccountById(String id) {
        Account account=accountrepo.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Account not found with id: " + id));
        return AccountMapper.toDTO(account);
    }

    @Override
    @Transactional
    public AccountResponseDTO updateAccount(String account_id, AccountUpdateDTO dto) {
        Account account=accountrepo.findById(account_id)
                .orElseThrow(()-> new ResourceNotFoundException("Account not found with id: " + account_id));
        account.setName(dto.getName());
        return AccountMapper.toDTO(account);
    }

    @Override
    public String deleteAccount(String id) {
        Account account=accountrepo.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Account not found with id: " + id));
        accountrepo.delete(account);
        return "Account deleted Successfully";
    }
}

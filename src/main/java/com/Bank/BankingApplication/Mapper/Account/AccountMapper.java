package com.Bank.BankingApplication.Mapper.Account;

import com.Bank.BankingApplication.Dto.Account.AccountRequestDTO;
import com.Bank.BankingApplication.Dto.Account.AccountResponseDTO;
import com.Bank.BankingApplication.Entity.Account.Account;
import com.Bank.BankingApplication.Util.IDGenerator.AccountIdGenerator;

import java.time.LocalDateTime;

public class AccountMapper {

    public Account toEntity(AccountRequestDTO dto){
        return Account.builder()
                .accountId(AccountIdGenerator.generateId())
                .name(dto.getName())
                .amount(dto.getAmount())
                .CreatedDate(LocalDateTime.now())
                .build();
    }
    public static AccountResponseDTO toDTO(Account acc) {
        return AccountResponseDTO.builder()
                .accountId(acc.getAccountId())
                .name(acc.getName())
                .amount(acc.getAmount())
                .createdDate(acc.getCreatedDate())
                .build();
    }
}

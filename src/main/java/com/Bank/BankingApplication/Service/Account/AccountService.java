package com.Bank.BankingApplication.Service.Account;

import com.Bank.BankingApplication.Dto.Account.AccountRequestDTO;
import com.Bank.BankingApplication.Dto.Account.AccountResponseDTO;
import com.Bank.BankingApplication.Dto.Account.AccountUpdateDTO;

public interface AccountService {
    //Account create
    AccountResponseDTO create(AccountRequestDTO dto);

    //get account
    AccountResponseDTO getAccountById(String id);

    //update account
    AccountResponseDTO updateAccount(String account_id, AccountUpdateDTO dto);

    //Delete account
    String deleteAccount(String id);
}

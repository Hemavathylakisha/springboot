package com.Bank.BankingApplication.Repository.Account;

import com.Bank.BankingApplication.Entity.Account.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account,String> {
}

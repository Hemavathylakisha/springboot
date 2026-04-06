package com.Bank.BankingApplication.Controller.Account;

import com.Bank.BankingApplication.Dto.Account.AccountRequestDTO;
import com.Bank.BankingApplication.Dto.Account.AccountResponseDTO;
import com.Bank.BankingApplication.Dto.Account.AccountUpdateDTO;
import com.Bank.BankingApplication.Service.Account.AccountService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/account")
public class AccountController {
    @Autowired
    private AccountService service;

    @PostMapping
    public AccountResponseDTO create(@Valid @RequestBody AccountRequestDTO dto) {
        return service.create(dto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AccountResponseDTO> getAccount(@PathVariable String id) {
        return ResponseEntity.ok(service.getAccountById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AccountResponseDTO> update(
            @PathVariable String id,
            @Valid @RequestBody AccountUpdateDTO dto) {

        return ResponseEntity.ok(service.updateAccount(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAccount(@PathVariable  String id){
        return ResponseEntity.ok(service.deleteAccount(id));
    }
}

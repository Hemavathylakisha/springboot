package com.Bank.BankingApplication.Controller.Transaction;

import com.Bank.BankingApplication.Dto.Transaction.DepositRequestDTO;
import com.Bank.BankingApplication.Dto.Transaction.TransactionResponseDTO;
import com.Bank.BankingApplication.Entity.Transaction.TransactionType;
import com.Bank.BankingApplication.Service.Transaction.TransactionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/account")
public class TransactionController {

    @Autowired
    private TransactionService service;

    @PostMapping("/{id}/deposit")
    public ResponseEntity<?> deposit(
            @PathVariable String id,
            @RequestParam Double amount) {

        return ResponseEntity.ok(service.deposit(id, amount));
    }

    @PostMapping("/{id}/withdraw")
    public ResponseEntity<?> withdraw(
            @PathVariable String id,
            @RequestParam Double amount) {

        return ResponseEntity.ok(service.withdraw(id, amount));
    }

    @PostMapping("/transfer")
    public ResponseEntity<String> transfer(
            @RequestParam String fromId,
            @RequestParam String toId,
            @RequestParam Double amount) {

        service.transfer(fromId, toId, amount);

        return ResponseEntity.ok("Transfer successful");
    }

    //  ALL transactions
    @GetMapping("/transactions")
    public Page<TransactionResponseDTO> getAllTransactions(
            @RequestParam String accountId,
            @PageableDefault(size = 5, sort = "date", direction = Sort.Direction.DESC)
            Pageable pageable) {

        return service.getAllTransactions(accountId, pageable);
    }

    //  DEPOSIT filter
    @GetMapping("/{id}/transaction/deposit")
    public Page<TransactionResponseDTO> getDeposit(
            @PathVariable String id,
            @PageableDefault(size = 5, sort = "date", direction = Sort.Direction.DESC)
            Pageable pageable) {

        return service.getByType(id, TransactionType.DEPOSIT, pageable);
    }

    //  WITHDRAW filter
    @GetMapping("/{id}/transaction/withdraw")
    public Page<TransactionResponseDTO> getWithdraw(
            @PathVariable String id,
            Pageable pageable) {

        return service.getByType(id, TransactionType.WITHDRAW, pageable);
    }

    //  TRANSFER filter
    @GetMapping("/{id}/transaction/transfer")
    public Page<TransactionResponseDTO> getTransfer(
            @PathVariable String id,
            Pageable pageable) {

        return service.getByType(id, TransactionType.TRANSFER, pageable);
    }
}

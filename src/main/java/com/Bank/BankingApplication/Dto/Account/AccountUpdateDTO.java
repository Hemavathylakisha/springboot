package com.Bank.BankingApplication.Dto.Account;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountUpdateDTO {

    @NotBlank(message = "Name should be given for updated")
    private String name;
}

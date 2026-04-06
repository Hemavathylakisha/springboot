package com.Bank.BankingApplication.ExceptionHandling;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ExceptionResponseDTO {
    private LocalDateTime timesatamp;
    private int status;
    private String message;
    private String path;
}

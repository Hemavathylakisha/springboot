package com.Bank.BankingApplication.Util.IDGenerator;

import java.util.UUID;

public class TransactionIdGenerator {

    public static String generateId() {
       // Final ID
        return "TXN" + UUID.randomUUID();
    }
}

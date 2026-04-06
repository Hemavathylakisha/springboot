package com.Bank.BankingApplication.Util.IDGenerator;

import org.springframework.stereotype.Component;

import java.security.SecureRandom;
import java.time.Instant;

@Component
public class AccountIdGenerator {
    private static final String PREFIX="ACC";
    private static final String CHARSET="ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private static final int RANDOMLENGTH=7;

    private static final SecureRandom random=new SecureRandom();

    public static String generateId() {

        // Timestamp (unique base)
        long timestamp = Instant.now().toEpochMilli();

        // Random suffix
        StringBuilder randomPart = new StringBuilder();
        for (int i = 0; i < RANDOMLENGTH; i++) {
            randomPart.append(CHARSET.charAt(random.nextInt(CHARSET.length())));
        }

        // Final ID
        return PREFIX + timestamp + randomPart;
    }

}

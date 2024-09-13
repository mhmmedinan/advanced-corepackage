package com.core_security.emailAuthenticator;

import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.Base64;

@Service
public class EmailAuthenticationHelperImpl implements EmailAuthenticatorHelper{

    private final SecureRandom random = new SecureRandom();

    @Override
    public String createEmailActivationKey() {
        byte[] keyBytes = new byte[64];
        random.nextBytes(keyBytes);
        String key = Base64.getEncoder().encodeToString(keyBytes);
        return key;
    }

    @Override
    public String createEmailActivationCode() {
        int code = random.nextInt((int) Math.pow(10,6));
        String formattedCode = String.format("%06d",code);
        return formattedCode;
    }
}

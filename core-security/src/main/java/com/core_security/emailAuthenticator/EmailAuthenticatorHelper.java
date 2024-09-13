package com.core_security.emailAuthenticator;

public interface EmailAuthenticatorHelper {
    String createEmailActivationKey();
    String createEmailActivationCode();
}

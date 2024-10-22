package io.github.mhmmedinan.core_mailing;

import jakarta.mail.MessagingException;

public interface MailService {

    void sendMessage(String to, String subject, String htmlContent) throws MessagingException;
}

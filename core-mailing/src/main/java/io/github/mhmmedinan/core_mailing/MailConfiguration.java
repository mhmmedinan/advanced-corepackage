package io.github.mhmmedinan.core_mailing;

import org.springframework.boot.autoconfigure.mail.MailProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

@Configuration
public class MailConfiguration {

    @Bean
    public MailProperties mailProperties() {
        return new MailProperties(); // MailProperties bean'ini manuel oluşturuyoruz
    }

    @Bean
    public JavaMailSender mailSender(MailProperties properties) {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost(properties.getHost());
        mailSender.setPort(properties.getPort());
        mailSender.setUsername(properties.getUsername());
        mailSender.setPassword(properties.getPassword());


        Properties props = mailSender.getJavaMailProperties();
        props.putAll(properties.getProperties());
        return mailSender;
    }
}

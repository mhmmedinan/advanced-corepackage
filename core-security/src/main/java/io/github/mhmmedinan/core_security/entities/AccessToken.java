package io.github.mhmmedinan.core_security.entities;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AccessToken {
    private String token;
    private Date expiration;
}
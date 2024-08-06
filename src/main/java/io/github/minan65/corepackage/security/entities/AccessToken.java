package io.github.minan65.corepackage.security.entities;

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
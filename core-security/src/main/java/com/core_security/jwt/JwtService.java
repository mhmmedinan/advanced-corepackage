package com.core_security.jwt;



import com.core_security.entities.AccessToken;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import javax.crypto.SecretKey;
import java.security.SecureRandom;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class JwtService {
    private static final String SECRET_KEY = "12023660c1601aaada3da96a4a80612e291ec33b28f60b58191f8b2845eb237bc978efb4d339d0b09f285cda79c5d67eef4458d6cefbd592ac663c783d1a64ee";
    private static final long EXPIRATION = 600000;


    public AccessToken generateToken(String username){
        Map<String,Object> claims = new HashMap<>();
        return createToken(claims,username);
    }

    public AccessToken generateToken(Map<String,Object> claims,String username) {
        return createToken(claims, username);
    }

    public Boolean validateToken(String token, String username) {
        return username.equals(extractUser(token)) && !isTokenExpired(token);
    }

    public String extractUser(String token){
        Claims claims = Jwts
                .parser()
                .verifyWith(getSignKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
        return claims.getSubject();
    }

    private Date extractExpiration(String token) {
        Claims claims = Jwts
                .parser()
                .verifyWith(getSignKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
        return claims.getExpiration();
    }

    private AccessToken createToken(Map<String,Object> claims,String username){
        Date expiration = new Date(System.currentTimeMillis() + EXPIRATION);
        String jwt = Jwts.builder()
                .claims(claims)
                .subject(username)
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(expiration)
                .signWith(getSignKey(), Jwts.SIG.HS256)
                .compact();
        return new AccessToken(jwt,expiration);
    }

    private SecretKey getSignKey(){
        byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }
    private boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    public String refreshToken() {
        byte[] numberByte = new byte[33];
        SecureRandom random = new SecureRandom();
        random.nextBytes(numberByte);
        return Base64.getEncoder().encodeToString(numberByte);
    }
}

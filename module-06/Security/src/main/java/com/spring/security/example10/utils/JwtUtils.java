package com.spring.security.example10.utils;

import io.jsonwebtoken.Jwts;
import org.bouncycastle.jcajce.provider.digest.Skein;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Component
public class JwtUtils {

    private final String secret = "my-very-long-secret-key-with-random-data-!##@#@#@#@#$";
    private final SecretKey secretKey = new SecretKeySpec(secret.getBytes(), "HmacSHA256");

    public String generateToken(String userName) {
        return Jwts.builder()
                .subject(userName)
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + (1000 * 60 *60)))
                .signWith(secretKey)
                .compact();
    }
}

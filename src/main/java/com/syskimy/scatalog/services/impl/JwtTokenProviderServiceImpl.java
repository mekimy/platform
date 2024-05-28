package com.syskimy.scatalog.services.impl;

import com.syskimy.scatalog.controllers.JwtTokenProviderService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;

@Service
public class JwtTokenProviderServiceImpl implements JwtTokenProviderService {
    @Override
    public Claims parseClaims(String token) {
        byte[] keyBytes = Decoders.BASE64.decode("helloworld");
        SecretKey key = Keys.hmacShaKeyFor(keyBytes);

        Jws<Claims> jws = Jwts.parser().decryptWith(key).build().parseSignedClaims(token);

        return jws.getPayload();
    }
}

package com.syskimy.scatalog.controllers;

import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.SignatureAlgorithm;

import javax.crypto.SecretKey;
import java.security.Key;

public interface JwtTokenProviderService {
    Claims parseClaims(String token);
}

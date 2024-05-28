package com.syskimy.scatalog.filters;

import com.syskimy.scatalog.controllers.JwtTokenProviderService;
import io.jsonwebtoken.Claims;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {
    private final String TOKEN_PREFIX = "Bearer ";
    private final JwtTokenProviderService jwtTokenProviderService;
    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        String authorization = request.getHeader(HttpHeaders.AUTHORIZATION);
        if (!ObjectUtils.isEmpty(authorization) && authorization.startsWith(TOKEN_PREFIX)) {
            Claims claims = jwtTokenProviderService.parseClaims(
                    authorization.replace(TOKEN_PREFIX, "")
            );

            String email = claims.get("EMAIL").toString();


        }

    }
}

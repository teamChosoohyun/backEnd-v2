package com.example.codingmom.global.security.jwt;

import io.jsonwebtoken.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.*;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
public class JwtTokenProvider {
    @Value("${token.secretKey}")
    private String secretKey;

    private final UserDetailsService userDetailsService;

    @PostConstruct
    protected void init() {
        secretKey = Base64.getEncoder().encodeToString(secretKey.getBytes());
    }

    public String createToken(String username, Long time) {
        Claims claims = Jwts.claims().setSubject(username);
        claims.put("username", username);
        Date now = new Date();

        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(now)
                .setExpiration(new Date(now.getTime()+time))
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact();
    }

    public String createAccessToken(String username){
        Long accessTokenValidTime = 30 * 60 * 1000L;
        return createToken(username, accessTokenValidTime);
    }

    public String createRefreshToken(String username){
        Long refreshTokenValidTime = 1000L * 60 * 60 * 24 * 14;
        return createToken(username, refreshTokenValidTime);
    }

    public Authentication getAuthentication(String token) {
        UserDetails userDetails = userDetailsService.loadUserByUsername(this.getUserPk(token));
        return new UsernamePasswordAuthenticationToken(userDetails, "", userDetails.getAuthorities());
    }

    public String getUserPk(String token) {
        return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody().getSubject();
    }

    public String resolveToken(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies){
            if(cookie.getName().equals("accessToken")) return cookie.getValue();
        }
        return null;
    }

    public boolean validateToken(String jwtToken) {
        try{
            Jws<Claims> claims  = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(jwtToken);
            return !claims.getBody().getExpiration().before(new Date());
        } catch (Exception e) {
            return false;
        }
    }
    public Claims parseJwtToken(String token){
        try{
            return Jwts.parser()
                    .setSigningKey(secretKey)
                    .parseClaimsJws(token)
                    .getBody();
        }catch (ExpiredJwtException e){
            e.printStackTrace();
            return null;
        }
    }
}

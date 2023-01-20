package com.example.codingmom.global.security.jwt;


import com.example.codingmom.domain.user.entity.User;
import com.example.codingmom.domain.user.facade.UserFacade;
import com.example.codingmom.global.security.jwt.exception.AuthExpiredException;
import com.example.codingmom.global.util.CookieUtil;
import io.jsonwebtoken.Jwts;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@RequiredArgsConstructor
@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtTokenProvider jwtTokenProvider;
    private final CookieUtil cookieUtil;
    private final UserFacade userFacade;

    @Override
    protected void doFilterInternal(HttpServletRequest req, HttpServletResponse res, FilterChain filterChain) throws ServletException, IOException {
        res.setHeader("Access-Control-Allow-Origin", "http://localhost:3000");
        res.setHeader("Access-Control-Allow-Credentials", "true");
        res.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE, PUT, PATCH");
        res.setHeader("Access-Control-Max-Age", "3600");
        res.setHeader("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With, remember-me");

        String path = req.getRequestURI();
        if(!(path.contains("/auth") || path.contains("/kakao"))){
            try{
                checkAccessToken(req);
            }catch (Exception e){
                checkRefreshToken(req, res);
            }
        }
//        String token = req.getHeader("Authorization");
//        if(token != null && jwtTokenProvider.validateToken(token)){
//            Authentication authentication = jwtTokenProvider.getAuthentication(token);
//            SecurityContextHolder.getContext().setAuthentication(authentication);
//        }
        filterChain.doFilter(req, res);
    }

    private void checkRefreshToken(HttpServletRequest req, HttpServletResponse res){
        Cookie refreshToken = cookieUtil.getCookie(req, "refreshToken");

        if(refreshToken == null){
            res.setHeader(HttpHeaders.SET_COOKIE, cookieUtil.createCookie("accessToken", null, 0L).toString());
            res.setHeader(HttpHeaders.SET_COOKIE, cookieUtil.createCookie("refreshToken", null, 0L).toString());
            return;
        }
        
        try{
            Cookie accessToken = cookieUtil.getCookie(req, "accessToken");
            User user = userFacade.findByKakaoid(jwtTokenProvider.parseJwtToken(accessToken.getValue()).getSubject());
            String newToken = jwtTokenProvider.createAccessToken(user.getKakaoid(), user.getRoles());

            ResponseCookie cookie = cookieUtil.createCookie("accessToken", newToken, 30 * 60 * 1000L);
            res.addHeader(HttpHeaders.SET_COOKIE, cookie.toString());

            authentication(newToken);
        }catch (Exception e){
            e.printStackTrace();
            throw AuthExpiredException.EXCEPTION;
        }
    }

    private void checkAccessToken(HttpServletRequest req){
        Cookie accessToken = cookieUtil.getCookie(req, "accessToken");
        String token = accessToken.getValue();
        authentication(token);
    }

    private void authentication(String token){
        Authentication auth = jwtTokenProvider.getAuthentication(token);
        SecurityContextHolder.getContext().setAuthentication(auth);
    }
}

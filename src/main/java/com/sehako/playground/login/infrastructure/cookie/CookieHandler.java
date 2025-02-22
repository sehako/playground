package com.sehako.playground.login.infrastructure.cookie;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;

public class CookieHandler {
    public static void setRefreshTokenToHeader(HttpServletResponse response, String refreshToken, long expirationTime) {
        ResponseCookie responseCookie = ResponseCookie
                .from("refresh-token", refreshToken)
                .maxAge(expirationTime)
                .httpOnly(true)
                .path("/")
                .build();

        response.setHeader(HttpHeaders.SET_COOKIE, responseCookie.toString());
    }
}

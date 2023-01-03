package com.example.codingmom.global.security.jwt.exception;

import com.example.codingmom.global.error.exception.CodingmomException;
import com.example.codingmom.global.error.exception.ErrorCode;

public class AuthExpiredException extends CodingmomException {

    public final static AuthExpiredException EXCEPTION = new AuthExpiredException();
    public AuthExpiredException() {
        super(ErrorCode.AUTHENTICATION_HAS_EXPIRED);
    }
}

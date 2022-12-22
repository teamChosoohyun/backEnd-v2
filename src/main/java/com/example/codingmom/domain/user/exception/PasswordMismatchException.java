package com.example.codingmom.domain.user.exception;

import com.example.codingmom.global.error.exception.CodingmomException;
import com.example.codingmom.global.error.exception.ErrorCode;

public class PasswordMismatchException extends CodingmomException {

    public final static PasswordMismatchException EXCEPTION = new PasswordMismatchException();
    public PasswordMismatchException() {
        super(ErrorCode.PASSWORD_MISMATCH);
    }
}

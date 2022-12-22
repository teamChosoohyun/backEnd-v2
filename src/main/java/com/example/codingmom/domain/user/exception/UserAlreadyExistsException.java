package com.example.codingmom.domain.user.exception;

import com.example.codingmom.global.error.exception.CodingmomException;
import com.example.codingmom.global.error.exception.ErrorCode;

public class UserAlreadyExistsException extends CodingmomException {

    public final static UserAlreadyExistsException EXCEPTION = new UserAlreadyExistsException();
    private UserAlreadyExistsException() {
        super(ErrorCode.USER_ALREADY_EXISTS);
    }
}

package com.example.codingmom.domain.user.exception;

import com.example.codingmom.global.error.exception.CodingmomException;
import com.example.codingmom.global.error.exception.ErrorCode;

public class UserNotFoundException extends CodingmomException {

    public final static UserNotFoundException EXCEPTION = new UserNotFoundException();

    public UserNotFoundException() {
        super(ErrorCode.USER_NOT_FOUND);
    }
}

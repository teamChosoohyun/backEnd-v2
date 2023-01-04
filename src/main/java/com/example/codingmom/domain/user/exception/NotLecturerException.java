package com.example.codingmom.domain.user.exception;

import com.example.codingmom.global.error.exception.CodingmomException;
import com.example.codingmom.global.error.exception.ErrorCode;

public class NotLecturerException extends CodingmomException {

    public final static NotLecturerException EXCEPTION = new NotLecturerException();
    public NotLecturerException() { super(ErrorCode.IS_NOT_LECTURER);}
}

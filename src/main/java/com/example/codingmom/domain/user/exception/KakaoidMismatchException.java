package com.example.codingmom.domain.user.exception;

import com.example.codingmom.global.error.exception.CodingmomException;
import com.example.codingmom.global.error.exception.ErrorCode;

public class KakaoidMismatchException extends CodingmomException {

    public final static KakaoidMismatchException EXCEPTION = new KakaoidMismatchException();
    public KakaoidMismatchException() {
        super(ErrorCode.PASSWORD_MISMATCH);
    }
}

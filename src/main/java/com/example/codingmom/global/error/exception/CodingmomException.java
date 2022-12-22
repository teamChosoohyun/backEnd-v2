package com.example.codingmom.global.error.exception;

import lombok.Getter;

@Getter
public class CodingmomException extends RuntimeException{
    private final ErrorCode errorCode;
    private final String message;

    public CodingmomException(ErrorCode errorCode){
        super(errorCode.getMessage());
        this.errorCode = errorCode;
        this.message = errorCode.getMessage();
    }

    public CodingmomException(ErrorCode errorCode, String message){
        super(message);
        this.errorCode = errorCode;
        this.message = message;
    }
}

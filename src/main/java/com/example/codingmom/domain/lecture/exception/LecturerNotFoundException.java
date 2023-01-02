package com.example.codingmom.domain.lecture.exception;

import com.example.codingmom.global.error.exception.CodingmomException;
import com.example.codingmom.global.error.exception.ErrorCode;

public class LecturerNotFoundException extends CodingmomException {

    public final static LecturerNotFoundException EXCEPTION = new LecturerNotFoundException();

    public LecturerNotFoundException (){
        super(ErrorCode.LECTURER_NOT_FOUND);
    }
}

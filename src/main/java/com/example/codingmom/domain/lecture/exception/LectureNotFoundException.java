package com.example.codingmom.domain.lecture.exception;

import com.example.codingmom.global.error.exception.CodingmomException;
import com.example.codingmom.global.error.exception.ErrorCode;

public class LectureNotFoundException extends CodingmomException {

    public final static LectureNotFoundException EXCEPTION = new LectureNotFoundException();

    public LectureNotFoundException(){ super(ErrorCode.LECTURE_NOT_FOUND);}
}

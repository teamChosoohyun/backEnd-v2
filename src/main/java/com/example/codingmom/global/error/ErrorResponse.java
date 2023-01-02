package com.example.codingmom.global.error;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class
ErrorResponse {
    private final int status;
    private final String message;
}

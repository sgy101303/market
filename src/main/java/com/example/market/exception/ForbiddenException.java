package com.example.market.exception;

public class ForbiddenException extends KnownException {

    public ForbiddenException(int errorCode, String errorMessage) {
        super(403, errorCode, errorMessage);
    }

}

package com.example.market.exception;

public class UnauthorizedException extends KnownException {

    public UnauthorizedException(int errorCode, String errorMessage) {
        super(401, errorCode, errorMessage);
    }

}

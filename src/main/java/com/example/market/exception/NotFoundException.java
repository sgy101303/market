package com.example.market.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, code = HttpStatus.NOT_FOUND)
public class NotFoundException extends KnownException {

    public NotFoundException() {
        super(404, 404, "페이지를 찾을 수 없습니다.");
    }

    public NotFoundException(int errorCode, String errorMessage) {
        super(404, errorCode, errorMessage);
    }

}

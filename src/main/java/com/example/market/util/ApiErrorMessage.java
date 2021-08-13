package com.example.market.util;

import kr.sharenshare.keylitadmin.exception.KnownException;
import lombok.Data;

import java.util.Date;

@Data
public class ApiErrorMessage {

    private boolean result;
    private String message;
    private int code;
    private Date timestamp;

    public ApiErrorMessage(Exception e) {
        this.result = false;
        this.message = e.getMessage();
        this.code = 9999;
        this.timestamp = new Date();
    }

    public ApiErrorMessage(KnownException e) {
        this.result = false;
        this.message = e.getErrorMessage();
        this.code = e.getErrorCode();
        this.timestamp = new Date();
    }

    @Override
    public String toString() {
        return GsonUtils.toString(this);
    }

}

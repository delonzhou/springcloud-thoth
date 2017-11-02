package com.changyou.thoth.common.model;


import com.changyou.thoth.common.exception.ErrorCode;
import com.changyou.thoth.common.exception.GlobalErrorCode;

/**
 * RestResult Builder
 * <p>
 * Created by wujun on 2017/02/16.
 */
public class RestResultBuilder {

    protected int code;

    protected String message;

    protected Object data;

    public static RestResultBuilder builder() {
        RestResultBuilder restResultBuilder = new RestResultBuilder();
        return restResultBuilder;
    }

    public RestResultBuilder code(int code) {
        this.code = code;
        return this;
    }

    public RestResultBuilder message(String message) {
        this.message = message;
        return this;
    }

    public RestResultBuilder data(Object data) {
        this.data = data;
        return this;
    }

    public RestResultBuilder errorCode(ErrorCode errorCode) {
        this.code = errorCode.getCode();
        this.message = errorCode.getMessage();
        return this;
    }

    public RestResultBuilder success() {
        this.code = GlobalErrorCode.SUCCESS.getCode();
        this.message = GlobalErrorCode.SUCCESS.getMessage();
        return this;
    }

    public RestResultBuilder success(Object data) {
        this.code = GlobalErrorCode.SUCCESS.getCode();
        this.message = GlobalErrorCode.SUCCESS.getMessage();
        this.data = data;
        return this;
    }

    public RestResultBuilder failure() {
        this.code = GlobalErrorCode.FAILURE.getCode();
        this.message = GlobalErrorCode.FAILURE.getMessage();
        return this;
    }

    public RestResultBuilder failure(Object data) {
        this.code = GlobalErrorCode.FAILURE.getCode();
        this.message = GlobalErrorCode.FAILURE.getMessage();
        this.data = data;
        return this;
    }

    public RestResultBuilder result(boolean successful) {
        if (successful) {
            return this.success();
        } else {
            return this.failure();
        }
    }

    public RestResultBuilder success(Boolean result) {
        if (result == Boolean.TRUE) {
            success();
        } else {
            failure();
        }
        return this;
    }

    public RestResult build() {
        return new RestResult(this.code, this.message, this.data);
    }

    public RestResult build(RestResult restResult) {
        return restResult;
    }
}

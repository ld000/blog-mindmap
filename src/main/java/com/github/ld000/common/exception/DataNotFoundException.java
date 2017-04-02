package com.github.ld000.common.exception;

import com.github.ld000.common.ResponseCode;

/**
 * data not found exception
 */
public class DataNotFoundException extends K2ResponseException {

    private static final long serialVersionUID = -5999409754794135010L;
    private static final String SEPARATOR = ": ";

    public DataNotFoundException() {
        super(ResponseCode.GENERAL_RESULT_NOT_FOUND, ResponseCode.MSG_RESULT_NOT_FOUND);
    }

    public DataNotFoundException(String extraMessage) {
        super(ResponseCode.GENERAL_RESULT_NOT_FOUND,
                ResponseCode.MSG_RESULT_NOT_FOUND + SEPARATOR + extraMessage);
    }

}
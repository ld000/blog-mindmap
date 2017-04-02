package com.github.ld000.common.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class K2ResponseException extends Exception {

    private static final long serialVersionUID = -700782141122462621L;

    private int code;

    private String message;

    public K2ResponseException(int code, String message, Exception e) {
        this.code = code;
        this.message = String.format("%s(%s: %s)", message, e.getClass().getSimpleName(), e.getMessage());
    }

}

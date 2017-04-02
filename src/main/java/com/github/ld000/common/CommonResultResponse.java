package com.github.ld000.common;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;


@NoArgsConstructor
@AllArgsConstructor
@JsonPropertyOrder({ "code", "message", "result" })
public class CommonResultResponse<T> extends CommonResponse implements Serializable {

    /**
     * 有返回信息的response
     */
    private static final long serialVersionUID = 2523377728598055414L;
    @Setter
    @Getter
    private T result;

    public static <T> CommonResultResponse<T> buildSuccessCommonResultResponse(T result) {
        CommonResultResponse<T> response = new CommonResultResponse<T>();
        response.setCode(ResponseCode.GENERAL_SUCCESS);
        response.setMessage(ResponseCode.SUCCESS);
        response.setResult(result);

        return response;
    }
}

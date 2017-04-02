package com.github.ld000.common;

import com.github.ld000.common.exception.DataNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 * Response Helper
 */
public class ResponseHelper {

    /**
     * Response OK
     */
    public static <T> ResponseEntity<CommonResultResponse> success(T result) throws Exception {

        return success(result, false);
    }

    /**
     * For some functions return void
     * Response OK
     */
    public static ResponseEntity<CommonResultResponse> success() throws Exception {

        return success("", false);
    }


    /**
     * Response OK
     *
     * @param result     service result
     * @param emptyCheck empty check or not
     */
    @SuppressWarnings("unchecked")
    public static <T> ResponseEntity<CommonResultResponse> success(T result, boolean emptyCheck) throws Exception {

        if (emptyCheck && ObjectUtils.isEmpty(result)) {
            throw new DataNotFoundException();
        }

        CommonResultResponse response = new CommonResultResponse();

        response.setCode(ResponseCode.GENERAL_SUCCESS);
        response.setMessage(ResponseCode.SUCCESS);
        response.setResult(result);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}

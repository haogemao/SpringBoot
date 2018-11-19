/**
 *
 */
package com.person.springboot.util;

import com.person.springboot.vo.Response;

/**
 * @author HS
 */
public class ResponseUtil {

    public static Response success(Object data) {
        Response response = new Response();
        response.setSuccess(true);
        response.setMessage("����ɹ�");
        response.setData(data);
        return response;
    }

    public static Response success() {
        return success(null);
    }

    public static Response error(String message) {
        Response response = new Response();
        response.setSuccess(false);
        response.setMessage(message);
        response.setData(null);
        return response;
    }
}

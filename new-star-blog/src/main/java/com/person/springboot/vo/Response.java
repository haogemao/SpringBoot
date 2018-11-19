package com.person.springboot.vo;

/**
 * 鍝嶅簲 鍊煎璞�.
 *
 * @author <a href="https://waylau.com">Way Lau</a>
 * @since 1.0.0 2017骞�4鏈�4鏃�
 */
public class Response {


    private boolean success;
    private String message;
    private Object body;

    /**
     * 鍝嶅簲澶勭悊鏄惁鎴愬姛
     */
    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    /**
     * 鍝嶅簲澶勭悊鐨勬秷鎭�
     */
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * 鍝嶅簲澶勭悊鐨勮繑鍥炲唴瀹�
     */
    public Object getBody() {
        return body;
    }

    public void setBody(Object body) {
        this.body = body;
    }

    public Response(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public Response(boolean success, String message, Object body) {
        this.success = success;
        this.message = message;
        this.body = body;
    }

}

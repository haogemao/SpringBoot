/**
 *
 */
package com.person.ssm.exception;

/**
 * @author HS
 */
public class ShopCategoryExecution extends RuntimeException {

    /**
     *
     */
    private static final long serialVersionUID = -2259992486414695963L;

    /**
     *
     */
    public ShopCategoryExecution() {
        // TODO Auto-generated constructor stub
    }

    /**
     * @param message
     */
    public ShopCategoryExecution(String message) {
        super(message);
        // TODO Auto-generated constructor stub
    }

    /**
     * @param cause
     */
    public ShopCategoryExecution(Throwable cause) {
        super(cause);
        // TODO Auto-generated constructor stub
    }

    /**
     * @param message
     * @param cause
     */
    public ShopCategoryExecution(String message, Throwable cause) {
        super(message, cause);
        // TODO Auto-generated constructor stub
    }

    /**
     * @param message
     * @param cause
     * @param enableSuppression
     * @param writableStackTrace
     */
    public ShopCategoryExecution(String message, Throwable cause, boolean enableSuppression,
                                 boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
        // TODO Auto-generated constructor stub
    }

}

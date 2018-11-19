/**
 *
 */
package com.person.ssm.exception;

/**
 * @author HS
 */
public class ShopOperationException extends RuntimeException {

    /**
     *
     */
    private static final long serialVersionUID = -7250967316776102399L;

    /**
     *
     */
    public ShopOperationException() {
        // TODO Auto-generated constructor stub
    }

    /**
     * @param message
     */
    public ShopOperationException(String message) {
        super(message);
        // TODO Auto-generated constructor stub
    }

    /**
     * @param cause
     */
    public ShopOperationException(Throwable cause) {
        super(cause);
        // TODO Auto-generated constructor stub
    }

    /**
     * @param message
     * @param cause
     */
    public ShopOperationException(String message, Throwable cause) {
        super(message, cause);
        // TODO Auto-generated constructor stub
    }

    /**
     * @param message
     * @param cause
     * @param enableSuppression
     * @param writableStackTrace
     */
    public ShopOperationException(String message, Throwable cause, boolean enableSuppression,
                                  boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
        // TODO Auto-generated constructor stub
    }

}

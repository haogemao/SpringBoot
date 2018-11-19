/**
 *
 */
package com.person.ssm.util;

import javax.servlet.http.HttpServletRequest;

import com.google.code.kaptcha.Constants;

/**
 * @author HS
 */
public class CodeUtil {

    public static boolean checkVerifyCode(HttpServletRequest request) {
        String verifyCodeExpected = (String) request.getSession().getAttribute(Constants.KAPTCHA_SESSION_KEY);
        String verifyCodeActual = HttpServletRequestUtil.getString(request, "verifyCodeActual");
        if (verifyCodeActual == null || !verifyCodeActual.equalsIgnoreCase(verifyCodeExpected)) {
            return false;
        }
        return true;
    }
}

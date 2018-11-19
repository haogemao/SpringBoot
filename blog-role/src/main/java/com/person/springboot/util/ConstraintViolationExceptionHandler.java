/**
 *
 */
package com.person.springboot.util;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.apache.commons.lang3.StringUtils;

/**
 * @author HS
 */
public class ConstraintViolationExceptionHandler {

    public static String getMessage(ConstraintViolationException e) {
        List<String> mStrings = new ArrayList<>();

        for (ConstraintViolation<?> constraintViolation : e.getConstraintViolations()) {
            mStrings.add(constraintViolation.getMessage());
        }

        String messages = StringUtils.join(mStrings.toArray(), ";");
        return messages;
    }
}

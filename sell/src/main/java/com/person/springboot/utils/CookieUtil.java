package com.person.springboot.utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * Cookie工具类
 */
public class CookieUtil {

    /**
     * 删除Cookie
     *
     * @param response
     * @param name
     */
    public static void del(HttpServletResponse response, String name) {
        set(response, name, null, 0);
    }

    /**
     * 设置Cookie
     *
     * @param response
     * @param name
     * @param value
     * @param maxAge
     */
    public static void set(HttpServletResponse response, String name, String value, int maxAge) {
        Cookie cookie = new Cookie(name, value);
        cookie.setPath("/");
        cookie.setMaxAge(maxAge);
        response.addCookie(cookie);
    }

    /**
     * 获取Cookie
     *
     * @param httpServletRequest
     * @param name
     * @return
     */
    public static Cookie get(HttpServletRequest httpServletRequest, String name) {
        Map<String, Cookie> cookieMap = readCookieMap(httpServletRequest);
        if (cookieMap.containsKey(name)) {
            return cookieMap.get(name);
        }
        return null;
    }

    /**
     * 将cookie数组封装为Map
     *
     * @param httpServletRequest
     * @return
     */
    public static Map<String, Cookie> readCookieMap(HttpServletRequest httpServletRequest) {
        Map<String, Cookie> cookieMap = new HashMap<>();
        Cookie[] cookies = httpServletRequest.getCookies();
        if (cookies == null || cookies.length == 0) {
            return cookieMap;
        }
        for (Cookie cookie : cookies) {
            cookieMap.put(cookie.getName(), cookie);
        }
        return cookieMap;
    }
}

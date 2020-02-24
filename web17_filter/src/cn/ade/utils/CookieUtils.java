package cn.ade.utils;

import javax.servlet.http.Cookie;

/**
 * 需求：Cookie的工具类
 * 
 * @author ade
 * @version 1.0，2017-10-20 14:39:44
 */
public class CookieUtils {

	public static String getCookie(Cookie[] cookies, String name) {
		for (Cookie cookie : cookies) {
			String cookieName = cookie.getName();
			if (name.equals(cookieName)) {
				return cookie.getValue();
			}
		}
		return null;
	} 
	
}

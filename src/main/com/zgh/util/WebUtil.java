package main.com.zgh.util;

import javax.servlet.http.Cookie;

public class WebUtil {
    public static Cookie getWantCookie(String cookieName,Cookie[] cookies){
        Cookie resultCookie = null;
        for(Cookie cookie:cookies){
            if(cookieName.equals(cookie.getName())){
                resultCookie = cookie;
            }
        }
        return resultCookie;
    }
}

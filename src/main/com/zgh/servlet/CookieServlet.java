package main.com.zgh.servlet;

import main.com.zgh.util.WebUtil;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CookieServlet extends BaseServlet {
    public void createCookie(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        Cookie cookie = new Cookie("key2","value2");
        resp.addCookie(cookie);
        resp.getWriter().write("创建Cookie成功!");
    }

    public void getAllCookie(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        Cookie[] cookies = req.getCookies();
        for(Cookie cookie:cookies){
            resp.getWriter().write(cookie.getName() + ":" + cookie.getValue());
            resp.getWriter().write("<br/>");
        }
    }
    public void getWantCookie(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        Cookie[] cookies = req.getCookies();
        Cookie cookie = WebUtil.getWantCookie("key1",cookies);
        if(cookie == null){
            resp.getWriter().write("没有获取到想要cookie!");
        }
        else{
            resp.getWriter().write("想要的cookie值为 => " + cookie.getValue());
        }
    }
}

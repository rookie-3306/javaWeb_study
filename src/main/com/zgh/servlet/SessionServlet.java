package main.com.zgh.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class SessionServlet extends BaseServlet{
    public void getSession(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String msg = "Session的ID为 => " + session.getId() + ".\nSession是否是新创建的 => " + session.isNew();
        req.setAttribute("sessionMsg",msg);
        req.getRequestDispatcher("/session.jsp").forward(req,resp);
    }

    public void setAttribute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        session.setAttribute("key1","sessionValue1");
        String msg = "数据设置成功!";
        req.setAttribute("sessionMsg",msg);
        req.getRequestDispatcher("/session.jsp").forward(req,resp);
    }

    public void getAttribute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String msg = "Session中key1中保存的数据为 => " + session.getAttribute("key1");
        req.setAttribute("sessionMsg",msg);
        req.getRequestDispatcher("/session.jsp").forward(req,resp);
    }

    public void getMaxInactiveInterval(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String msg = "Session的生存时间为 => " + session.getMaxInactiveInterval();
        req.setAttribute("sessionMsg",msg);
        req.getRequestDispatcher("/session.jsp").forward(req,resp);
    }

    public void setMaxInactiveInterval(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        //这里设置的是秒,web.xml里面的timeout则设置的是分钟
        //而且是经过setMaxInactiveInterval方法设置的存活时间只适合该次Session
        session.setMaxInactiveInterval(3);
        String msg = "Session生存时长设置成功!";
        req.setAttribute("sessionMsg",msg);
        req.getRequestDispatcher("/session.jsp").forward(req,resp);
    }
}

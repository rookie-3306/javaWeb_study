package main.com.zgh.servlet;

import main.com.zgh.entity.UserEntity;
import main.com.zgh.pojo.Page;
import main.com.zgh.server.UserServer;
import main.com.zgh.server.UserServerImp;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserServlet extends BaseServlet {
    UserServer userServer = new UserServerImp();

    //登录
    public void logon(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        boolean flush = userServer.logon(username,password);
        if(flush){
            //跳转
        }
        else{
            req.setAttribute("msg","账号或者密码错误!");
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/logon.jsp");
            requestDispatcher.forward(req,resp);
        }
    }

    //注册
    public void register(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        req.setCharacterEncoding("UTF-8");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String nickname = req.getParameter("nickname");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html");
        if(userServer.existence(username)){
            req.setAttribute("msg","此账号已经存在!");
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/register.jsp");
            requestDispatcher.forward(req,resp);
        }
        else {
            if(userServer.register(username,password,nickname)){
                resp.getWriter().write("<h1>注册成功!</h1>");
            }
            else {
                resp.getWriter().write("<h1>注册失败!原因xxxxxxx!</h1>");
            }
        }
    }

    //分页
    public void page(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        int pageNo = req.getParameter("pageNo")==null||Integer.parseInt(req.getParameter("pageNo"))==0?1:Integer.parseInt(req.getParameter("pageNo"));
        int pageSize = req.getParameter("pageSize")==null||Integer.parseInt(req.getParameter("pageSize"))== 0?Page.PAGE_SIZE:Integer.parseInt(req.getParameter("pageSize"));
        Page<UserEntity> page = userServer.page(pageNo,pageSize);
        req.setAttribute("page",page);
        req.setAttribute("pageSize",pageSize);
        req.getRequestDispatcher("/userManager.jsp").forward(req,resp);
    }
}

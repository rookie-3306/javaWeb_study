package main.com.zgh.servlet;

import main.com.zgh.entity.UserEntity;
import main.com.zgh.pojo.Page;
import main.com.zgh.server.UserServer;
import main.com.zgh.server.UserServerImp;
import main.com.zgh.util.WebUtil;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY;

public class UserServlet extends BaseServlet {
    UserServer userServer = new UserServerImp();

    //登录
    public void logon(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        boolean flush = userServer.logon(username,password);
        if(flush){
            Cookie cookie = new Cookie("username",username);
            UserEntity user = userServer.findUserByName(username);
            req.getSession().setAttribute("user",user);
            //设置保存用户名的cookie一周的存活时间
            cookie.setMaxAge(60 * 60 * 24 * 7);
            resp.addCookie(cookie);
            req.getRequestDispatcher("/mainPage.jsp").forward(req,resp);
        }
        else{
            req.setAttribute("msg","账号或者密码错误!");
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/logon.jsp");
            requestDispatcher.forward(req,resp);
        }
    }

    //跳转登录界面
    public void forwardLogon(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        //判断是否有上次登录的用户cookie
        Cookie userCookie = WebUtil.getWantCookie("username",req.getCookies());
        if(userCookie != null){
            UserEntity user = userServer.findUserByName(userCookie.getValue());
            req.getSession().setAttribute("user",user);
            req.getRequestDispatcher("/mainPage.jsp").forward(req,resp);
        }
        else{
            req.getRequestDispatcher("/logon.jsp").forward(req,resp);
        }
    }

    //注册
    public void register(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        //验证码操作
        String token = (String)req.getSession().getAttribute(KAPTCHA_SESSION_KEY);
        req.getSession().removeAttribute(KAPTCHA_SESSION_KEY);
        String code = req.getParameter("code");
        if(token == null || !token.equalsIgnoreCase(code)){
            req.setAttribute("msg","验证码错误!");
            req.getRequestDispatcher("/register.jsp").forward(req,resp);
        }

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
                req.setAttribute("msg","注册成功!");
            }
            else {
                req.setAttribute("msg","注册失败!原因:xxxxxx");
            }
            req.getRequestDispatcher("/register.jsp").forward(req,resp);
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

    //注销
    public void cancellation(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        //销毁Session中保存的user数据
        req.removeAttribute("user");
        //通知浏览器销毁cookie
        Cookie wantDeleteCookie = WebUtil.getWantCookie("username",req.getCookies());
        wantDeleteCookie.setMaxAge(0);
        resp.addCookie(wantDeleteCookie);
        req.getRequestDispatcher("/logon.jsp").forward(req,resp);
    }
}

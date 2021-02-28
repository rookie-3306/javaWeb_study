package main.com.zgh.servlet;

import main.com.zgh.entity.BookEntity;
import main.com.zgh.entity.UserEntity;
import main.com.zgh.pojo.Page;
import main.com.zgh.server.BookServer;
import main.com.zgh.server.BookServerImp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class BookServlet extends BaseServlet{

    BookServer bookServer = new BookServerImp();

    public void page(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("访问了bookServlet的page方法");
        int pageNo = req.getParameter("pageNo")==null||Integer.parseInt(req.getParameter("pageNo"))==0?1:Integer.parseInt(req.getParameter("pageNo"));
        int pageSize = req.getParameter("pageSize")==null||Integer.parseInt(req.getParameter("pageSize"))== 0? Page.PAGE_SIZE:Integer.parseInt(req.getParameter("pageSize"));
        Page<BookEntity> page = bookServer.page(pageNo,pageSize);
        req.setAttribute("page",page);
        req.setAttribute("pageSize",pageSize);
        req.getRequestDispatcher("/bookManager.jsp").forward(req,resp);
    }
}

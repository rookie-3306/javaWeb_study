package main.com.zgh.servlet;

import com.sun.org.apache.xpath.internal.objects.XNull;
import main.com.zgh.entity.BookEntity;
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
        int pageNo = req.getParameter("pageNo")==null||Integer.parseInt(req.getParameter("pageNo"))==0?1:Integer.parseInt(req.getParameter("pageNo"));
        int pageSize = req.getParameter("pageSize")==null||Integer.parseInt(req.getParameter("pageSize"))== 0? Page.PAGE_SIZE:Integer.parseInt(req.getParameter("pageSize"));
        Page<BookEntity> page = bookServer.page(pageNo,pageSize);
        req.setAttribute("page",page);
        req.setAttribute("pageSize",pageSize);
        req.getRequestDispatcher("/bookManager.jsp").forward(req,resp);
    }

    public void deleteBookById(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(bookServer.deleteBookById(Integer.parseInt(req.getParameter("bookId")))){
            req.setAttribute("bookMsg","删除成功!");
        }else{
            req.setAttribute("bookMsg","删除失败!");
        }
        page(req,resp);
    }

    public void forwardUpdateBookJsp(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BookEntity needUpdateBook = bookServer.findBookById(Integer.parseInt(req.getParameter("bookId")));
        req.setAttribute("needUpdateBook",needUpdateBook);
        req.getRequestDispatcher("/updateBook.jsp").forward(req,resp);
    }

    public void updateBook(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BookEntity newBookEntity = new BookEntity();
        fillBookEntity(req,newBookEntity);
        if(bookServer.updateBookInformation(newBookEntity)){
            req.setAttribute("bookMsg","更新成功!");
        }
        else {
            req.setAttribute("bookMsg","更新失败!");
        }
        page(req,resp);
    }

    public void addBook(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BookEntity addBookEntity = new BookEntity();
        fillBookEntity(req,addBookEntity);
        if(bookServer.addBook(addBookEntity)){
            req.setAttribute("bookMsg","添加成功!");
        }
        else {
            req.setAttribute("bookMsg","添加失败!");
        }
        page(req,resp);
    }

    //填充BookEntity实体类,String默认值为未知,int与float为-1
    private void fillBookEntity(HttpServletRequest req, BookEntity bookEntity) throws ServletException, IOException {
        int bookId =  -1;
        if(req.getParameter("id") != null){
            bookId = Integer.parseInt(req.getParameter("id"));
        }
        String bookName = null;
        if(req.getParameter("name") != null){
            bookName = req.getParameter("name");
        }
        float bookPrice = -1.0f;
        if(req.getParameter("price") != null){
            bookPrice = Float.parseFloat(req.getParameter("price"));
        }
        String bookAuthor = null;
        if(req.getParameter("author") != null){
            bookAuthor = req.getParameter("author");
        }
        int bookSales = -1;
        if(req.getParameter("sales") != null){
            bookSales = Integer.parseInt(req.getParameter("sales"));
        }
        int bookStock = -1;
        if(req.getParameter("stock") != null){
            bookStock = Integer.parseInt(req.getParameter("stock"));
        }
        bookEntity.setId(bookId);
        bookEntity.setName(bookName);
        bookEntity.setPrice(bookPrice);
        bookEntity.setAuthor(bookAuthor);
        bookEntity.setSales(bookSales);
        bookEntity.setStock(bookStock);
    }
}

package main.com.zgh.server;

import main.com.zgh.entity.BookEntity;
import main.com.zgh.pojo.Page;

import java.util.List;

public interface BookServer {
    Page<BookEntity> page(int pageNo,int pageSize);
    boolean deleteBookById(int bookId);
    boolean updateBookInformation(BookEntity bookEntity);
    BookEntity findBookById(int bookId);
    boolean addBook(BookEntity bookEntity);
    //    List<BookEntity> findAllBook();
//    boolean deleteBookByName(String bookName);
}

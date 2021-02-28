package main.com.zgh.server;

import main.com.zgh.entity.BookEntity;
import main.com.zgh.pojo.Page;

import java.util.List;

public interface BookServer {
    Page<BookEntity> page(int pageNo,int pageSize);
//    List<BookEntity> findAllBook();
//    boolean addBook(BookEntity bookEntity);
//    boolean deleteBookById(int bookId);
//    boolean deleteBookByName(String bookName);
//    boolean updateBookInformation(BookEntity bookEntity);
}

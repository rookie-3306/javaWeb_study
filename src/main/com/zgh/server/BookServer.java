package main.com.zgh.server;

import main.com.zgh.entity.BookEntity;

import java.util.List;

public interface BookServer {
    List<BookEntity> findAllBook();
    boolean addBook(BookEntity bookEntity);
    boolean deleteBookById(int bookId);
    boolean deleteBookByName(String bookName);
    boolean updateBookInformation(BookEntity bookEntity);
}

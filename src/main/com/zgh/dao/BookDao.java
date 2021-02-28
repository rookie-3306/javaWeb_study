package main.com.zgh.dao;

import main.com.zgh.entity.BookEntity;
import main.com.zgh.entity.UserEntity;

import java.util.List;

public interface BookDao {
    boolean addBook(BookEntity bookEntity);
    boolean deleteBookById(int id);
    boolean updateBook(BookEntity bookEntity);
    BookEntity findBookById(int id);
    List<BookEntity> findAllBook();
    int recordsNumber();
    List<BookEntity> findRange(int begin, int number);
}

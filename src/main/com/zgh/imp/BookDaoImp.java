package main.com.zgh.imp;

import main.com.zgh.dao.BookDao;
import main.com.zgh.entity.BookEntity;
import main.com.zgh.util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDaoImp implements BookDao {
    Connection connection = null;
    public BookDaoImp(){
        connection = JDBCUtil.getConnection();
    }
    @Override
    public boolean addBook(BookEntity bookEntity) {
        String sql = "INSERT INTO book_information(name,price,author,sales,stock) " +
                "VALUES(?,?,?,?,?)";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,bookEntity.getName());
            preparedStatement.setFloat(2,bookEntity.getPrice());
            preparedStatement.setString(3,bookEntity.getAuthor());
            preparedStatement.setInt(4,bookEntity.getSales());
            preparedStatement.setInt(5,bookEntity.getStock());
            preparedStatement.execute();
            return true;
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteBookById(int id) {
        String sql = "DELETE FROM book_information WHERE id = ?";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,id);
            preparedStatement.execute();
            return true;
        }
        catch (SQLException e){
          e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean updateBook(BookEntity bookEntity) {
        String sql = "UPDATE book_information SET price=?,author=?,sales=?,stock=? " +
                "WHERE name=?";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setFloat(1,bookEntity.getPrice());
            preparedStatement.setString(2,bookEntity.getAuthor());
            preparedStatement.setInt(3,bookEntity.getSales());
            preparedStatement.setInt(4,bookEntity.getStock());
            preparedStatement.setString(5,bookEntity.getName());
            preparedStatement.execute();
            return true;
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public BookEntity findBookById(int id) {
        BookEntity result = null;
        String sql = "SELECT * FROM book_information WHERE id=?";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,id);
            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.getResultSet();
            while(resultSet.next()){
                result = new BookEntity(resultSet.getInt(1),resultSet.getString(2),
                        resultSet.getFloat(3),resultSet.getString(4),
                        resultSet.getInt(5),resultSet.getInt(6));
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public List<BookEntity> findAllBook() {
        List<BookEntity> bookEntities = new ArrayList<>();
        String sql = "SELECT * FROM book_information";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.getResultSet();
            while(resultSet.next()){
                BookEntity temp = new BookEntity(resultSet.getInt(1),resultSet.getString(2),
                        resultSet.getFloat(3),resultSet.getString(4),
                        resultSet.getInt(5),resultSet.getInt(6));
                bookEntities.add(temp);
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return bookEntities;
    }

    public static void main(String[] args) {
        BookDao bookDao = new BookDaoImp();
        BookEntity bookEntity = new BookEntity(-1,"朝花夕拾",20.00f,"鲁迅",100,10);
        bookDao.addBook(bookEntity);
    }
}

package main.com.zgh.imp;

import main.com.zgh.dao.UserDao;
import main.com.zgh.entity.UserEntity;
import main.com.zgh.util.JDBCUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImp implements UserDao {
    Connection connection = null;
    public UserDaoImp(){
        connection = JDBCUtil.getConnection();
    }
    @Override
    public boolean addUser(UserEntity user) {
        String sql = "INSERT INTO user(username,password,nickname)"+
                "values(?,?,?)";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,user.getUsername());
            preparedStatement.setString(2,user.getPassword());
            preparedStatement.setString(3,user.getNickname());
            preparedStatement.execute();
            return true;
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean existenceInUser(String username) {
        int count = 0;
        String sql = "SELECT COUNT(*) FROM user WHERE username=?";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,username);
            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.getResultSet();
            while(resultSet.next()){
                count = resultSet.getInt(1);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        if(count == 0){
            return false;
        }
        else {
            return true;
        }
    }

    @Override
    public boolean existenceInUser(UserEntity userEntity) {
        int count = 0;
        String sql = "SELECT COUNT(*) FROM user WHERE username=? AND password=?";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,userEntity.getUsername());
            preparedStatement.setString(2,userEntity.getPassword());
            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.getResultSet();
            while(resultSet.next()){
                count = resultSet.getInt(1);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        if(count == 0){
            return false;
        }
        else {
            return true;
        }
    }

    @Override
    public UserEntity getUser(String username) {
        UserEntity userEntity = new UserEntity();
        String sql = "SELECT * FROM user WHERE username=?";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,username);
            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.getResultSet();
            while(resultSet.next()){
                userEntity.setId(resultSet.getInt("id"));
                userEntity.setUsername(resultSet.getString("username"));
                userEntity.setPassword(resultSet.getString("password"));
                userEntity.setNickname(resultSet.getString("nickname"));
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return userEntity;
    }

    @Override
    public UserEntity getUser(int id) {
        return null;
    }

    @Override
    public List<UserEntity> findAll() {
        List<UserEntity> userEntities = new ArrayList<>();
        String sql = "SELECT * FROM user";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.getResultSet();
            while(resultSet.next()){
                UserEntity temp = new UserEntity();
                temp.setId(resultSet.getInt("id"));
                temp.setUsername(resultSet.getString("username"));
                temp.setPassword(resultSet.getString("password"));
                temp.setNickname(resultSet.getString("nickname"));
                userEntities.add(temp);
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return userEntities;
    }

    @Override
    public int recordsNumber() {
        String sql = "SELECT COUNT(*) FROM user";
        int count = 0;
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.getResultSet();
            while(resultSet.next()){
                count = resultSet.getInt(1);
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return count;
    }

    @Override
    public List<UserEntity> findRange(int begin, int number) {
        List<UserEntity> userEntities = new ArrayList<>();
        String sql = "SELECT * FROM user limit ?,?";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,begin);
            preparedStatement.setInt(2,number);
            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.getResultSet();
            while(resultSet.next()){
                UserEntity userEntity = new UserEntity();
                userEntity.setId(resultSet.getInt("id"));
                userEntity.setUsername(resultSet.getString("username"));
                userEntity.setPassword(resultSet.getString("password"));
                userEntity.setNickname(resultSet.getString("nickname"));
                userEntities.add(userEntity);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return userEntities;
    }

    public static void main(String[] args) {
        UserDao userDao = new UserDaoImp();
//        UserEntity userEntity = new UserEntity();
//        userEntity.setUsername("aaa123");
//        userEntity.setPassword("123");
//        userEntity.setNickname("张三");
//        userDao.addUser(userEntity);
//        boolean flush = userDao.existenceInUser("aaa");
//        System.out.println(flush);
//        List<UserEntity> x = userDao.findAll();
//        for(UserEntity item : x){
//            System.out.println(item.getId());
//        }
//        System.out.println(userDao.recordsNumber());
        List<UserEntity> userEntities = userDao.findRange(1,2);
        for(UserEntity temp : userEntities){
            System.out.println(temp.getId());
        }
    }
}

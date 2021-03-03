package main.com.zgh.dao;

import main.com.zgh.entity.UserEntity;
import main.com.zgh.pojo.IPage;

import java.util.List;

public interface UserDao extends IPage<UserEntity> {
    //添加用户
    boolean addUser(UserEntity user);
    //检测是否存在次用户
    boolean existenceInUser(String username);
    boolean existenceInUser(UserEntity userEntity);
    //获取用户信息
    UserEntity getUser(String username);
    UserEntity getUser(int id);
    //查询所有用户
    List<UserEntity> findAll();
    //查询记录条数
    int recordsNumber();
    //查找范围内的
    List<UserEntity> findRange(int begin, int number);
}

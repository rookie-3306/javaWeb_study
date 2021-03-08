package main.com.zgh.server;

import main.com.zgh.entity.UserEntity;
import main.com.zgh.pojo.Page;

public interface UserServer {
    Page<UserEntity> page(int pageNo,int pageSize);
    boolean logon(String username,String password);
    boolean register(String username,String password,String nickname);
    boolean existence(String username);
    UserEntity findUserById(int userId);
    UserEntity findUserByName(String userName);
}

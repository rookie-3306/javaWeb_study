package main.com.zgh.server;

import main.com.zgh.dao.UserDao;
import main.com.zgh.entity.UserEntity;
import main.com.zgh.imp.UserDaoImp;
import main.com.zgh.pojo.Page;
import main.com.zgh.util.PageUtil;

import java.util.List;

public class UserServerImp implements UserServer{
    UserDao userDao = new UserDaoImp();
    @Override
    public Page<UserEntity> page(int pageNo, int pageSize) {
        return new PageUtil<UserEntity>().createPage(userDao,pageNo,pageSize);
    }

    @Override
    public boolean logon(String username, String password) {
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(username);
        userEntity.setPassword(password);
        UserDao userDao = new UserDaoImp();
        return userDao.existenceInUser(userEntity);
    }

    @Override
    public boolean register(String username, String password, String nickname) {
        UserEntity userEntity = new UserEntity();
        userEntity.setNickname(nickname);
        userEntity.setUsername(username);
        userEntity.setPassword(password);
        UserDao userDao = new UserDaoImp();
        return userDao.addUser(userEntity);
    }

    @Override
    public boolean existence(String username) {
        return userDao.existenceInUser(username);
    }

    @Override
    public UserEntity findUserById(int userId) {
        return userDao.getUser(userId);
    }

    @Override
    public UserEntity findUserByName(String userName) {
        return userDao.getUser(userName);
    }
}

package main.com.zgh.server;

import main.com.zgh.dao.UserDao;
import main.com.zgh.entity.UserEntity;
import main.com.zgh.imp.UserDaoImp;
import main.com.zgh.pojo.Page;

import java.util.List;

public class UserServerImp implements UserServer{
    UserDao userDao = new UserDaoImp();
    @Override
    public Page<UserEntity> page(int pageNo, int pageSize) {
        if(pageNo < 1){
            System.out.println("输入页数开始值小于1!");
            pageNo = 1;
        }
        Page<UserEntity> page = new Page<>();
        page.setPageNo(pageNo);
        page.setPageSize(pageSize);
        int pageTotalCount = userDao.recordsNumber();
        page.setPageTotalCount(pageTotalCount);
        int pageTotal = pageTotalCount / pageSize;
        if(pageTotalCount % pageSize > 0){
            pageTotal++;
        }
        page.setPageTotal(pageTotal);
        int begin = (page.getPageNo() - 1) * pageSize;
        List<UserEntity> items = userDao.findRange(begin,pageSize);
        page.setItems(items);
        return page;
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
}

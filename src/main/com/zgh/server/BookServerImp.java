package main.com.zgh.server;

import main.com.zgh.dao.BookDao;
import main.com.zgh.entity.BookEntity;
import main.com.zgh.imp.BookDaoImp;
import main.com.zgh.pojo.Page;
import main.com.zgh.util.PageUtil;

public class BookServerImp implements BookServer{
    BookDao bookDao = new BookDaoImp();
    @Override
    public Page<BookEntity> page(int pageNo, int pageSize) {
        return new PageUtil<BookEntity>().createPage(bookDao,pageNo,pageSize);
    }
}

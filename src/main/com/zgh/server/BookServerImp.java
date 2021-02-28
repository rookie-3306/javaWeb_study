package main.com.zgh.server;

import main.com.zgh.dao.BookDao;
import main.com.zgh.entity.BookEntity;
import main.com.zgh.imp.BookDaoImp;
import main.com.zgh.pojo.Page;

import java.util.List;

public class BookServerImp implements BookServer{
    BookDao bookDao = new BookDaoImp();
    @Override
    public Page<BookEntity> page(int pageNo, int pageSize) {
        //这块都是重复代码
        //准备用实现接口的方式把Dao.recordsNumber与Dao.findRange这两个方法整合到IPage这个接口中
        //就可以实现重复代码的利用
        //下次使用Page的时候就让该实体的Dao实现IPage方法就可
        if(pageNo < 1){
            System.out.println("输入页数开始值小于1!");
            pageNo = 1;
        }
        Page<BookEntity> page = new Page<>();
        page.setPageNo(pageNo);
        page.setPageSize(pageSize);
        int pageTotalCount = bookDao.recordsNumber();
        page.setPageTotalCount(pageTotalCount);
        int pageTotal = pageTotalCount / pageSize;
        if(pageTotalCount % pageSize > 0){
            pageTotal++;
        }
        page.setPageTotal(pageTotal);
        int begin = (page.getPageNo() - 1) * pageSize;
        List<BookEntity> items = bookDao.findRange(begin,pageSize);
        page.setItems(items);
        return page;
    }
}

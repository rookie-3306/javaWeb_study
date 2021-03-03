package main.com.zgh.util;

import main.com.zgh.pojo.IPage;
import main.com.zgh.pojo.Page;
import java.util.List;

public class PageUtil<E> {

    public Page<E> createPage(IPage dao,int pageNo, int pageSize){
        if(pageNo < 1){
            System.out.println("输入页数开始值小于1!");
            pageNo = 1;
        }
        Page<E> page = new Page<>();
        page.setPageNo(pageNo);
        page.setPageSize(pageSize);
        int pageTotalCount = dao.recordsNumber();
        page.setPageTotalCount(pageTotalCount);
        int pageTotal = pageTotalCount / pageSize;
        if(pageTotalCount % pageSize > 0){
            pageTotal++;
        }
        page.setPageTotal(pageTotal);
        int begin = (page.getPageNo() - 1) * pageSize;
        List<E> items = dao.findRange(begin,pageSize);
        page.setItems(items);
        return page;
    }

}

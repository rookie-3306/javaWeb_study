package main.com.zgh.pojo;

import java.util.List;

public class Page<E> {
    public static final Integer PAGE_SIZE = 4;
    //当前页码数
    private Integer pageNo;
    //总页码数
    private Integer pageTotal;
    //当前页码显示数量
    private Integer PageSize;
    //总记录数
    private Integer pageTotalCount;
    //当前页码数据
    private List<E> items;

    public static Integer getPageSize() {
        return PAGE_SIZE;
    }

    public void setPageSize(Integer pageSize) {
        PageSize = pageSize;
    }

    public Integer getPageTotalCount() {
        return pageTotalCount;
    }

    public void setPageTotalCount(Integer pageTotalCount) {
        this.pageTotalCount = pageTotalCount;
    }

    public List<E> getItems() {
        return items;
    }

    public void setItems(List<E> items) {
        this.items = items;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPageTotal() {
        return pageTotal;
    }

    public void setPageTotal(Integer pageTotal) {
        this.pageTotal = pageTotal;
    }
}

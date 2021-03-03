package main.com.zgh.pojo;

import java.util.List;

/*
实现分页功能实体的dao需要实现的分页接口
 */
public interface IPage<E> {
    //返回实体的总个数
    int recordsNumber();
    //返回给定范围内的实体
    List<E> findRange(int begin,int size);
}

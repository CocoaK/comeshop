package com.eshop.serviceapp.mapper;

import com.eshop.serviceapp.vo.DeleteVO;
import com.github.pagehelper.Page;

import java.util.List;

public interface BaseMapper<T> {

    int delete(Integer id);

    int insert(T entity);

    int insertActive(T entity);

    T getOne(Integer id);

    int updateActive(T entity);
    /*** 带乐观锁修改 */
    int updateActiveByLock(T entity);

    int update(T entity);

    List<T> getAll();

    List<T> getList(T entity);

    Page<T> getPageList(T entity);

    Page<T> queryPageList(T entity);

    Page<Object> queryPageListByVO(Object entity);

    Page<Object> getPageListByVO(Object entity);
    /*** 带乐观锁删除 */
    int deleteByLock(DeleteVO deleteVO);
}

package com.eshop.serviceweb.mapper;

import com.eshop.serviceweb.vo.DeleteVO;
import com.github.pagehelper.Page;

import java.util.List;

public interface BaseMapper<T> {

    int delete(Integer id);

    int insert(T entity);

    int insertActive(T entity);

    T getOne(Integer id);

    int updateActive(T entity);

    int update(T entity);

    List<T> getAll();

    List<T> getList(T entity);

    Page<T> getPageList(T entity);

    Page<T> queryPageList(T entity);

    int deleteByIdLock(DeleteVO deleteVO);
}

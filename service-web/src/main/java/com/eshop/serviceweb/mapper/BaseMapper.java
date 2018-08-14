package com.eshop.serviceweb.mapper;

import com.github.pagehelper.Page;

import java.util.List;

public interface BaseMapper<T> {

    int delete(Long id);

    int insert(T entity);

    int insertActive(T entity);

    T getOne(Long id);

    int updateActive(T entity);

    int update(T entity);

    List<T> getAll();

    List<T> getList(T entity);

    Page<T> getPageList(T entity);

    Page<T> queryPageList(T entity);
}

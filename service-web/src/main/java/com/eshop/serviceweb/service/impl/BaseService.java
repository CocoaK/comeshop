package com.eshop.serviceweb.service.impl;

import com.eshop.serviceweb.common.model.ResultEntity;
import com.eshop.serviceweb.common.model.ResultList;
import com.eshop.serviceweb.mapper.BaseMapper;
import com.eshop.serviceweb.service.IBaseService;
import com.eshop.serviceweb.vo.DeleteVO;
import com.eshop.serviceweb.vo.PageVO;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public abstract class BaseService<T> implements IBaseService<T> {

    public abstract BaseMapper<T> getBaseMapper();

    @Override
    public List<T> getList(T entity) {
        return getBaseMapper().getList(entity);
    }

    @Override
    public ResultList<List<T>> getPageList(Page<T> p, T entity) {
        Page page = PageHelper.startPage(p.getPageNum(),p.getPageSize());
        getBaseMapper().getPageList(entity);
        ResultList<List<T>> re = new ResultList<List<T>>(page.getTotal(), System.currentTimeMillis(), page);
        return re;
    }

    @Override
    public ResultList<List<T>> getPageList(Page<T> p, T entity,String orderBy) {
        Page page = PageHelper.startPage(p.getPageNum(),p.getPageSize(),orderBy);
        getBaseMapper().getPageList(entity);
        ResultList<List<T>> re = new ResultList<List<T>>(page.getTotal(), System.currentTimeMillis(), page);
        return re;
    }

    @Override
    public ResultList<List<T>> getPageList(PageVO<T> pageVO){
        Page page = PageHelper.startPage(pageVO.getPageNum(),pageVO.getPageSize(),pageVO.getOrderBy());
        getBaseMapper().getPageList(pageVO.getParams());
        ResultList<List<T>> re = new ResultList<List<T>>(page.getTotal(), System.currentTimeMillis(), page);
        return re;
    }

    @Override
    public ResultList<List<T>> queryPageList(Page<T> p, T entity) {
        Page page = PageHelper.startPage(p.getPageNum(),p.getPageSize());
        getBaseMapper().queryPageList(entity);
        ResultList<List<T>> re = new ResultList<List<T>>(page.getTotal(), System.currentTimeMillis(), page);
        return re;
    }

    @Override
    public ResultList<List<T>> queryPageList(Page<T> p, T entity,String orderBy) {
        Page page = PageHelper.startPage(p.getPageNum(),p.getPageSize(),orderBy);
        getBaseMapper().queryPageList(entity);
        ResultList<List<T>> re = new ResultList<List<T>>(page.getTotal(), System.currentTimeMillis(), page);
        return re;
    }

    @Override
    public ResultList<List<T>> queryPageList(PageVO<T> pageVO){
        Page page = PageHelper.startPage(pageVO.getPageNum(),pageVO.getPageSize(),pageVO.getOrderBy());
        getBaseMapper().queryPageList(pageVO.getParams());
        ResultList<List<T>> re = new ResultList<List<T>>(page.getTotal(), System.currentTimeMillis(), page);
        return re;
    }

    @Override
    public ResultList<List<T>> getPageListByObj(PageVO<Object> pageVO){
        Page page = PageHelper.startPage(pageVO.getPageNum(),pageVO.getPageSize(),pageVO.getOrderBy());
        getBaseMapper().getPageListByVO(pageVO.getParams());
        ResultList<List<T>> re = new ResultList<List<T>>(page.getTotal(), System.currentTimeMillis(), page);
        return re;
    }

    @Override
    public ResultList<List<T>> queryPageListByObj(PageVO<Object> pageVO){
        Page page = PageHelper.startPage(pageVO.getPageNum(),pageVO.getPageSize(),pageVO.getOrderBy());
        getBaseMapper().queryPageListByVO(pageVO.getParams());
        ResultList<List<T>> re = new ResultList<List<T>>(page.getTotal(), System.currentTimeMillis(), page);
        return re;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public int delete(String id) {
        return getBaseMapper().delete(Integer.parseInt(id));
    }

    @Override
    public T getOne(String id) {
        return getBaseMapper().getOne(Integer.parseInt(id));
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public int updateActive(T entity) {
        return getBaseMapper().updateActive(entity);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public int updateActiveByLock(T entity) {
        return getBaseMapper().updateActiveByLock(entity);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public int update(T entity) {
        return getBaseMapper().update(entity);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public int add(T entity) {
        return getBaseMapper().insertActive(entity);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public ResultEntity<String> addForResultEntity(T record) {
        int result = add(record);
        return proccessResultEntity(result > 0 ? ResultEntity.SUCCESS
                : ResultEntity.FAILD, result > 0 ? ResultEntity.MSG_SUCCESS : "", "");
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public ResultEntity<String> addListForResultEntity(List<T> list) {
        if(list!=null && list.size()>0){
            for(T t : list){
                add(t);
            }
        }
        return proccessResultEntity(ResultEntity.SUCCESS,ResultEntity.MSG_SUCCESS,"");
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public ResultEntity<String> deleteForResultEntity(String id) {
        int result = delete(id);
        return proccessResultEntity(result > 0 ? ResultEntity.SUCCESS
                : ResultEntity.FAILD, result > 0 ? ResultEntity.MSG_SUCCESS : "", "");
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public ResultEntity<String> deleteByLockForResultEntity(DeleteVO deleteVO){
        int result = getBaseMapper().deleteByLock(deleteVO);
        return proccessResultEntity(result > 0 ? ResultEntity.SUCCESS
                : ResultEntity.FAILD, result > 0 ? ResultEntity.MSG_SUCCESS : "", "");
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public ResultEntity<T> getOneResultEntity(String id) {
        return proccessResultEntity(ResultEntity.SUCCESS, "", getOne(id));
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public ResultEntity<String> updateForResultEntity(T entity) {
        int result = updateActive(entity);
        return proccessResultEntity(result > 0 ? ResultEntity.SUCCESS
                : ResultEntity.FAILD, result > 0 ? ResultEntity.MSG_SUCCESS : "", "");
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public ResultEntity<String> updateForResultEntityByLock(T entity) {
        int result = updateActiveByLock(entity);
        return proccessResultEntity(result > 0 ? ResultEntity.SUCCESS
                : ResultEntity.FAILD, result > 0 ? ResultEntity.MSG_SUCCESS : "", "");
    }

    @Override
    public <A> ResultEntity<A> proccessResultEntity(int code, String msg, A data) {
        return new ResultEntity<A>(code, msg, data);
    }

    @Override
    public <A> ResultEntity<ResultList<A>> proccessResultList(long total, long timetamp, A info) {
        return proccessResultEntity(ResultEntity.SUCCESS, "",new ResultList<A>(total, timetamp, info));
    }

}

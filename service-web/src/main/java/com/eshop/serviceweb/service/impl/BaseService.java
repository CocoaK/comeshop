package com.eshop.serviceweb.service.impl;

import com.eshop.serviceweb.common.model.ResultEntity;
import com.eshop.serviceweb.common.model.ResultList;
import com.eshop.serviceweb.mapper.BaseMapper;
import com.eshop.serviceweb.service.IBaseService;
import com.eshop.serviceweb.vo.DeleteVO;
import com.eshop.serviceweb.vo.PageVO;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
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
        getBaseMapper().getPageList(pageVO.getEntity());
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
        getBaseMapper().queryPageList(pageVO.getEntity());
        ResultList<List<T>> re = new ResultList<List<T>>(page.getTotal(), System.currentTimeMillis(), page);
        return re;
    }

    @Transactional
    @Override
    public int delete(Integer id) {
        return getBaseMapper().delete(id);
    }

    @Override
    public T getOne(Integer id) {
        return getBaseMapper().getOne(id);
    }

    @Transactional
    @Override
    public int updateActive(T entity) {
        return getBaseMapper().updateActive(entity);
    }

    @Transactional
    @Override
    public int update(T entity) {
        return getBaseMapper().update(entity);
    }

    @Override
    public int add(T entity) {
        return getBaseMapper().insert(entity);
    }

    /**
     * 增加返回格式化结果
     *
     * @param record
     * @return
     */
    @Override
    public ResultEntity<String> addForResultEntity(T record) {
        return proccessResultEntity(add(record) > 0 ? ResultEntity.SUCCESS
                : ResultEntity.FAILD, "", "");
    }

    /**
     * 增加列表返回格式化结果
     *
     * @param list
     * @return
     */
    @Override
    public ResultEntity<String> addListForResultEntity(List<T> list) {
        if(list!=null && list.size()>0){
            for(T t : list){
                add(t);
            }
        }
        return proccessResultEntity(ResultEntity.SUCCESS,"","");
    }

    /**
     * 删除返回格式化结果
     *
     * @param id
     * @return
     */
    @Override
    public ResultEntity<String> deleteForResultEntity(Integer id) {
        return proccessResultEntity(delete(id) > 0 ? ResultEntity.SUCCESS
                : ResultEntity.FAILD, "", "");
    }

    @Override
    public ResultEntity<String> deleteForResultEntity(DeleteVO deleteVO){
        return proccessResultEntity(getBaseMapper().deleteByIdLock(deleteVO) > 0 ? ResultEntity.SUCCESS
                : ResultEntity.FAILD, "", "");
    }

    /**
     * 获取单个实体数据
     *
     * @param id
     * @return
     */
    @Override
    public ResultEntity<T> getOneResultEntity(Integer id) {
        return proccessResultEntity(ResultEntity.SUCCESS, "", getOne(id));
    }

    /**
     * 更新返回格式化结果
     * @return
     */
    @Transactional
    @Override
    public ResultEntity<String> updateForResultEntity(T entity) {
        return proccessResultEntity(updateActive(entity) > 0 ? ResultEntity.SUCCESS: ResultEntity.FAILD, "", "");
    }

    /**
     * 传递常用结果消息
     *
     * @param code
     * @param msg
     * @param data
     * @return
     */
    @Override
    public <A> ResultEntity<A> proccessResultEntity(int code, String msg, A data) {
        return new ResultEntity<A>(code, msg, data);
    }

    @Override
    public <A> ResultEntity<ResultList<A>> proccessResultList(long total, long timetamp, A info) {
        return proccessResultEntity(ResultEntity.SUCCESS, "",new ResultList<A>(total, timetamp, info));
    }
}

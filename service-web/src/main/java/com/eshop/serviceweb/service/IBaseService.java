package com.eshop.serviceweb.service;

import com.eshop.serviceweb.common.model.ResultEntity;
import com.eshop.serviceweb.common.model.ResultList;
import com.eshop.serviceweb.vo.DeleteVO;
import com.eshop.serviceweb.vo.PageVO;
import com.github.pagehelper.Page;

import java.util.List;

/**
 * 基础服务接口
 * @param <T>
 */

public interface IBaseService<T> {

    int delete(String id);

    int add(T entity);

    T getOne(String id);

    int updateActive(T entity);

    int updateActiveByLock(T entity);

    int update(T entity);

    /**
     * 增加返回格式化结果
     * @param record
     * @return
     */
    public ResultEntity<String> addForResultEntity(T record);

    /**
     * 增加List返回格式化结果
     * @param list
     * @return
     */
    public ResultEntity<String> addListForResultEntity(List<T> list);

    /**
     * 删除返回格式化结果
     * @param id
     * @return
     */
    public ResultEntity<String> deleteForResultEntity(String id);

    /**
     * 删除返回格式化结果
     * @param DeleteVO
     * @return
     */
    public ResultEntity<String> deleteByLockForResultEntity(DeleteVO deleteVO);


    /**
     * 获取单个实体数据
     * @param id
     * @return
     */
    public ResultEntity<T> getOneResultEntity(String id);

    /**
     * 更新返回格式化结果
     * @param entity
     * @return
     */
    public ResultEntity<String> updateForResultEntity(T entity);

    /**
     * 更新返回格式化结果,支持乐观锁
     * @param entity
     * @return
     */
    public ResultEntity<String> updateForResultEntityByLock(T entity);

    /**
     * 传递常用结果消息
     * @param code
     * @param message
     * @param data
     * @return
     */
    public <A> ResultEntity<A> proccessResultEntity(int code, String message, A data);

    /**
     * @desc   @param p
     * @desc   @param obj
     * @desc   @return
     * @return Page<T>
     * @return
     */
    ResultList<List<T>> getPageList(Page<T> p, T entity);

    ResultList<List<T>> getPageList(Page<T> p, T entity, String orderBy);

    ResultList<List<T>> getPageList(PageVO<T> pageVO);

    /**
     * 不启用缓存的分页查询
     * @param p
     * @param entity
     * @return
     */
    ResultList<List<T>> queryPageList(Page<T> p, T entity);
    /**
     * 不启用缓存的分页查询
     * @param p
     * @param entity
     * @param orderBy
     * @return
     */
    ResultList<List<T>> queryPageList(Page<T> p, T entity, String orderBy);
    /**
     * 不启用缓存的分页查询
     * @param p
     * @param entity
     * @param orderBy
     * @return
     */
    ResultList<List<T>> queryPageList(PageVO<T> pageVO);

    /**
     * 查询列表
     * @param entity
     * @return
     */
    List<T> getList(T entity);
    /**
     * 传递列表结果
     * @param total
     * @param timetamp
     * @param info
     * @return
     */
    public <A> ResultEntity<ResultList<A>> proccessResultList(long total, long timetamp, A info);

}


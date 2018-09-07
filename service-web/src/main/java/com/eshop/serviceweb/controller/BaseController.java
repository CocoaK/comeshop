package com.eshop.serviceweb.controller;

import com.eshop.serviceweb.common.model.ResultEntity;
import com.eshop.serviceweb.common.model.ResultList;
import com.eshop.serviceweb.common.util.CryptUtil;
import com.eshop.serviceweb.service.IBaseService;
import com.eshop.serviceweb.vo.DeleteVO;
import com.eshop.serviceweb.vo.KeyVO;
import com.eshop.serviceweb.vo.PageVO;
import com.github.pagehelper.Page;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.beans.PropertyEditorSupport;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
/**
 * 基础转接控制器
 */
/**增加跨域支持*/
//@CrossOrigin(origins = "*", maxAge = 3600)
public abstract class BaseController<T> {

    public abstract IBaseService<T> getBaseService();

    @RequestMapping("/get")
    public @ResponseBody
    ResultEntity<T> getOne(@Validated @RequestBody KeyVO keyVO) {
        return getBaseService().getOneResultEntity(keyVO.getId());
    }

    @RequestMapping("/list")
    public @ResponseBody
    ResultList<List<T>> list(Page<T> p, T entity) {
        return getBaseService().getPageList(p, entity);
    }

    @RequestMapping("/add")
    public @ResponseBody
    ResultEntity<String> add(@Validated @RequestBody T entity) {
        return getBaseService().addForResultEntity(entity);
    }

    @RequestMapping("/delete")
    public @ResponseBody ResultEntity<String> delete(@RequestBody String id) {
        return getBaseService().deleteForResultEntity(id);
    }

    @RequestMapping("/deleteByLock")
    public @ResponseBody ResultEntity<String> delete(@Validated @RequestBody DeleteVO deleteVO) {
        return getBaseService().deleteByLockForResultEntity(deleteVO);
    }

    @RequestMapping("/deleteByLocks")
    public @ResponseBody ResultEntity<String> deletes(@Validated @RequestBody List<DeleteVO> list) {
        return getBaseService().deleteByLockForResultEntity(list);
    }

    @RequestMapping("/update")
    public @ResponseBody ResultEntity<String> update(@RequestBody T record) {
        return getBaseService().updateForResultEntityByLock(record);
    }

    @RequestMapping("/updt")
    public @ResponseBody ResultEntity<String> updt(@RequestBody T record) {
        return getBaseService().updateForResultEntity(record);
    }

    /**缓存分页支持*/
    @RequestMapping("/getPageList")
    public ResultList<List<T>> getPageList(@RequestBody PageVO<T> pageVO) {
        ResultList<List<T>> resultList = getBaseService().getPageList(pageVO);
        CryptUtil.crypt(resultList.getData());
        return resultList;
    }

    /**不缓存分页*/
    @RequestMapping("/queryPageList")
    public ResultList<List<T>> queryPageList(@RequestBody PageVO<T> pageVO) {
        ResultList<List<T>> resultList = getBaseService().queryPageList(pageVO);
        CryptUtil.crypt(resultList.getData());
        return resultList;
    }

    /**缓存分页支持*/
    @RequestMapping("/getPageListByObj")
    public ResultList<List<T>> getPageListByObj(@RequestBody PageVO<Object> pageVO) {
        ResultList<List<T>> resultList = getBaseService().getPageListByObj(pageVO);
        CryptUtil.crypt(resultList.getData());
        return resultList;
    }

    /**不缓存分页*/
    @RequestMapping("/queryPageListByObj")
    public ResultList<List<T>> queryPageListByObj(@RequestBody PageVO<Object> pageVO) {
        ResultList<List<T>> resultList = getBaseService().queryPageListByObj(pageVO);
        CryptUtil.crypt(resultList.getData());
        return resultList;
    }

    public <A> ResultEntity<A> proccessResultEntity(int code,String msg,A data){
        return new ResultEntity<A>(code,msg,data);
    }

//	@InitBinder
//	protected  void initBinder(WebDataBinder binder) {
//	    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//	    binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
//	}

//    @InitBinder
//    protected void initBinder(WebDataBinder binder) {
//        binder.registerCustomEditor(Date.class, new PropertyEditorSupport() {
//            @Override
//            public void setAsText(String value) {
//                setValue(new Timestamp(Long.valueOf(value)));
//            }
//        });
//    }
}
package com.eshop.serviceapp.controller;

import com.eshop.serviceapp.common.model.ResultEntity;
import com.eshop.serviceapp.common.model.ResultList;
import com.eshop.serviceapp.common.util.CryptUtil;
import com.eshop.serviceapp.service.IBaseService;
import com.eshop.serviceapp.vo.PageVO;
import com.github.pagehelper.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import java.beans.PropertyEditorSupport;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@RestController
/**
 * 基础转接控制器
 */
/**增加跨域支持*/
@CrossOrigin(origins = "*", maxAge = 3600)
public abstract class BaseController<T> {

    public abstract IBaseService<T> getBaseService();

    @RequestMapping("/list")
    public @ResponseBody
    ResultList<List<T>> list(Page<T> p, T entity) {
        return getBaseService().getPageList(p, entity);
    }

    @RequestMapping("/add")
    public @ResponseBody
    ResultEntity<String> add(@RequestBody T entity) {
        return getBaseService().addForResultEntity(entity);
    }

    @RequestMapping("/delete")
    public @ResponseBody ResultEntity<String> delete(@RequestBody Long id) {
        return getBaseService().deleteForResultEntity(id);
    }

    @RequestMapping("/update")
    public @ResponseBody ResultEntity<String> update(@RequestBody T record) {
        return getBaseService().updateForResultEntity(record);
    }

    /**缓存分页支持*/
    @RequestMapping("/getPageList")
    public ResultList<List<T>> getPageList(@Validated @RequestBody PageVO<T> pageVO) {
        ResultList<List<T>> resultList = getBaseService().getPageList(pageVO);
        CryptUtil.crypt(resultList.getData());
        return resultList;
    }

    /**不缓存分页*/
    @RequestMapping("/queryPageList")
    public ResultList<List<T>> queryPageList(@Validated @RequestBody PageVO<T> pageVO) {
        ResultList<List<T>> resultList = getBaseService().queryPageList(pageVO);
        CryptUtil.crypt(resultList.getData());
        return resultList;
    }

    public <A> ResultEntity<A> proccessResultEntity(int code,String msg,A data){
        return new ResultEntity<A>(code,msg,data);
    }

	/*@InitBinder
	protected  void initBinder(WebDataBinder binder) {
	    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	    binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}*/

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Date.class, new PropertyEditorSupport() {
            @Override
            public void setAsText(String value) {
                setValue(new Timestamp(Long.valueOf(value)));
            }
        });
    }
}
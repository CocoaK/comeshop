package com.eshop.serviceweb.service.impl;

import com.eshop.serviceweb.common.model.ResultEntity;
import com.eshop.serviceweb.mapper.BaseMapper;
import com.eshop.serviceweb.mapper.FuncMapper;
import com.eshop.serviceweb.model.Func;
import com.eshop.serviceweb.service.IFuncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuncService extends BaseService<Func> implements IFuncService {

    @Autowired
    private FuncMapper funcMapper;
    @Override
    public BaseMapper<Func> getBaseMapper() {
        return funcMapper;
    }

    @Override
    public ResultEntity<String> addForResultEntity(Func func) {
        Func f = new Func();
        f.setFuncName(func.getFuncName());
        List<Func> list = funcMapper.getList(f);
        if(list.size()>0){
            return proccessResultEntity(ResultEntity.ALREADY_EXIST, ResultEntity.MSG_FAILED, "func name exist!");
        }
        int result = add(func);
        return proccessResultEntity(result > 0 ? ResultEntity.SUCCESS
                : ResultEntity.FAILD, result > 0 ? ResultEntity.MSG_SUCCESS : "", "");
    }
}

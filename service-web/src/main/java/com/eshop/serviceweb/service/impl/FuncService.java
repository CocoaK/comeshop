package com.eshop.serviceweb.service.impl;

import com.eshop.serviceweb.mapper.BaseMapper;
import com.eshop.serviceweb.mapper.FuncMapper;
import com.eshop.serviceweb.model.Func;
import com.eshop.serviceweb.service.IFuncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FuncService extends BaseService<Func> implements IFuncService {

    @Autowired
    private FuncMapper funcMapper;
    @Override
    public BaseMapper<Func> getBaseMapper() {
        return funcMapper;
    }
}

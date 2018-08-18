package com.eshop.serviceweb.service.impl;

import com.eshop.serviceweb.mapper.BaseMapper;
import com.eshop.serviceweb.mapper.RoleFuncMapper;
import com.eshop.serviceweb.model.RoleFunc;
import com.eshop.serviceweb.service.IRoleFuncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleFuncService extends BaseService<RoleFunc> implements IRoleFuncService {

    @Autowired
    private RoleFuncMapper roleFuncMapper;
    @Override
    public BaseMapper<RoleFunc> getBaseMapper() {
        return roleFuncMapper;
    }
}

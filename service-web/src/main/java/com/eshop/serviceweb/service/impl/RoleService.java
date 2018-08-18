package com.eshop.serviceweb.service.impl;

import com.eshop.serviceweb.mapper.BaseMapper;
import com.eshop.serviceweb.mapper.RoleMapper;
import com.eshop.serviceweb.model.Role;
import com.eshop.serviceweb.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService extends BaseService<Role> implements IRoleService {

    @Autowired
    private RoleMapper roleMapper;
    @Override
    public BaseMapper<Role> getBaseMapper() {
        return roleMapper;
    }
}

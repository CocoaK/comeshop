package com.eshop.serviceweb.controller;

import com.eshop.serviceweb.model.Role;
import com.eshop.serviceweb.service.IBaseService;
import com.eshop.serviceweb.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/role")
public class RoleController extends BaseController<Role>{

    @Autowired
    private IRoleService roleService;

    @Override
    public IBaseService<Role> getBaseService() {
        return roleService;
    }
}

package com.eshop.serviceweb.controller;

import com.eshop.serviceweb.model.RoleFunc;
import com.eshop.serviceweb.service.IBaseService;
import com.eshop.serviceweb.service.IRoleFuncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/role/func")
public class RoleFuncController extends BaseController<RoleFunc>{

    @Autowired
    private IRoleFuncService roleFuncService;

    @Override
    public IBaseService<RoleFunc> getBaseService() {
        return roleFuncService;
    }
}

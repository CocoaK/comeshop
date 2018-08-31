package com.eshop.serviceweb.controller;

import com.eshop.serviceweb.common.model.ResultEntity;
import com.eshop.serviceweb.model.RoleFunc;
import com.eshop.serviceweb.service.IBaseService;
import com.eshop.serviceweb.service.IRoleFuncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
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

    @RequestMapping("/getOne")
    public @ResponseBody
    ResultEntity<RoleFunc> get(@RequestBody RoleFunc roleFunc) {
        return roleFuncService.get(roleFunc);
    }
}

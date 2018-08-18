package com.eshop.serviceweb.controller;

import com.eshop.serviceweb.model.Func;
import com.eshop.serviceweb.service.IBaseService;
import com.eshop.serviceweb.service.IFuncService;
import com.eshop.serviceweb.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/func")
public class FuncController extends BaseController<Func>{

    @Autowired
    private IFuncService funcService;

    @Override
    public IBaseService<Func> getBaseService() {
        return funcService;
    }
}

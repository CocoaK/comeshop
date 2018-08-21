package com.eshop.serviceweb.controller;

import com.eshop.serviceweb.model.User;
import com.eshop.serviceweb.service.IBaseService;
import com.eshop.serviceweb.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/user")
public class UserController extends BaseController<User>{

    @Autowired
    private IUserService userService;

    @Override
    public IBaseService<User> getBaseService() {
        return userService;
    }
}

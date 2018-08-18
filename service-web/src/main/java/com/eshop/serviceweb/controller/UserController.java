package com.eshop.serviceweb.controller;

import com.eshop.serviceweb.common.Constants;
import com.eshop.serviceweb.common.model.ResultEntity;
import com.eshop.serviceweb.model.User;
import com.eshop.serviceweb.service.IBaseService;
import com.eshop.serviceweb.service.IRedisService;
import com.eshop.serviceweb.service.IUserService;
import com.eshop.serviceweb.shiro.JwtTokenUtil;
import com.eshop.serviceweb.vo.LoginResultVO;
import com.eshop.serviceweb.vo.LoginVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

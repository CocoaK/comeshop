package com.eshop.serviceweb.service.impl;

import com.eshop.serviceweb.mapper.BaseMapper;
import com.eshop.serviceweb.mapper.UserMapper;
import com.eshop.serviceweb.model.User;
import com.eshop.serviceweb.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService extends BaseService<User> implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public BaseMapper<User> getBaseMapper() {
        return userMapper;
    }
}

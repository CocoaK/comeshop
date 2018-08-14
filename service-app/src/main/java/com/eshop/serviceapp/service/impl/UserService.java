package com.eshop.serviceapp.service.impl;

import com.eshop.serviceapp.common.model.ResultEntity;
import com.eshop.serviceapp.common.model.ResultList;
import com.eshop.serviceapp.common.util.CryptUtil;
import com.eshop.serviceapp.mapper.BaseMapper;
import com.eshop.serviceapp.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService extends BaseService<User> implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User getById(Long id) {
        User u = new User();
        u.setId(id);
        return userMapper.getList(u).get(0);
    }

    @Override
//    @Decrypt(value=username)
    public User getByUsername(String username) {
        User user = new User();
        user.setUsername(username);
        return userMapper.getList(user).get(0);
    }

    @Override
    public User getByUser(User user) {
//        User user = new User();
//        user.setUsername("123");
        List<User> list = userMapper.getList(user);
        User u = list.get(0);
//        CryptUtil.crypt(u);
        CryptUtil.crypt(list);
        System.out.println("list:"+list);
        return u;
    }

    @Override
    public ResultEntity<ResultList<List<User>>> queryForPageList(User user) {
//        User user = new User();
//        user.setUsername("123");
        List<User> list = userMapper.queryPageList(user);
        User u = list.get(0);
//        CryptUtil.crypt(u);
        CryptUtil.crypt(list);
        System.out.println("list:"+list);
        return null;
    }

    @Override
    public BaseMapper<User> getBaseMapper() {
        return userMapper;
    }
}

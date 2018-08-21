package com.eshop.serviceweb.service.impl;

import com.eshop.serviceweb.common.model.ResultEntity;
import com.eshop.serviceweb.mapper.BaseMapper;
import com.eshop.serviceweb.mapper.UserMapper;
import com.eshop.serviceweb.model.User;
import com.eshop.serviceweb.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;

@Service
public class UserService extends BaseService<User> implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public BaseMapper<User> getBaseMapper() {
        return userMapper;
    }

    @Override
    public ResultEntity<String> addForResultEntity(User user) {
        User u = new User();
        u.setUserName(user.getUserName());
        List<User> list = userMapper.getList(u);
        if(list.size()>0){
            return proccessResultEntity(ResultEntity.ALREADY_EXIST, ResultEntity.MSG_FAILED, "userName exist!");
        }
        int result = add(user);
        return proccessResultEntity(result > 0 ? ResultEntity.SUCCESS
                : ResultEntity.FAILD, result > 0 ? ResultEntity.MSG_SUCCESS : "", "");
    }

//    @Override
//    public int add(User user){
//        if(user != null && !StringUtils.isEmpty(user.getCurrentUser())){
//            user.setCreatedBy(user.getCurrentUser());
//        }
//       return userMapper.insert(user);
//    }

//    @Override
//    public int update(User user){
//        if(user != null){
//            User u = new User();
//            u.setUserId(user.getUserId());
//            u.setLastUpdatedBy(user.getLastUpdatedBy());
//            u.setLastUpdatedDate(user.getLastUpdatedDate());
//            List<User> list = userMapper.getList(u);
//            if(list.size() > 0){
//                user.setLastUpdatedDate(new Date(System.currentTimeMillis()));
//                if(!StringUtils.isEmpty(user.getCurrentUser())){
//                    user.setLastUpdatedBy(user.getCurrentUser());
//                }
//                return userMapper.update(user);
//            }
//        }
//        return 0;
//    }
}

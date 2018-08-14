package com.eshop.serviceapp.service;

import com.eshop.serviceapp.common.model.ResultEntity;
import com.eshop.serviceapp.common.model.ResultList;

import java.util.List;

public interface IUserService extends IBaseService<User>{

    User getById(Long id);

    User getByUsername(String username);

    User getByUser(User user);

    ResultEntity<ResultList<List<User>>> queryForPageList(User user);
}

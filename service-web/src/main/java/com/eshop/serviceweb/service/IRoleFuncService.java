package com.eshop.serviceweb.service;

import com.eshop.serviceweb.common.model.ResultEntity;
import com.eshop.serviceweb.model.RoleFunc;

public interface IRoleFuncService extends IBaseService<RoleFunc>{

    ResultEntity<RoleFunc> get(RoleFunc roleFunc);
}

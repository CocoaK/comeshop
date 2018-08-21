package com.eshop.serviceweb.service.impl;

import com.eshop.serviceweb.common.model.ResultEntity;
import com.eshop.serviceweb.mapper.BaseMapper;
import com.eshop.serviceweb.mapper.RoleFuncMapper;
import com.eshop.serviceweb.model.RoleFunc;
import com.eshop.serviceweb.service.IRoleFuncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleFuncService extends BaseService<RoleFunc> implements IRoleFuncService {

    @Autowired
    private RoleFuncMapper roleFuncMapper;
    @Override
    public BaseMapper<RoleFunc> getBaseMapper() {
        return roleFuncMapper;
    }

    @Override
    public ResultEntity<RoleFunc> get(RoleFunc roleFunc){
        ResultEntity<RoleFunc> reusltEntity = new ResultEntity<RoleFunc>();
        List<RoleFunc> list = this.getList(roleFunc);
        if(list != null && list.size()>0){
            RoleFunc entity = list.get(0);
            if(entity != null){
                reusltEntity.setCode(ResultEntity.SUCCESS);
                reusltEntity.setMsg(ResultEntity.MSG_SUCCESS);
                reusltEntity.setData(entity);
            }
        }
        return reusltEntity;
    }
}

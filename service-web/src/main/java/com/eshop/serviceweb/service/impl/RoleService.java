package com.eshop.serviceweb.service.impl;

import com.eshop.serviceweb.common.model.ResultEntity;
import com.eshop.serviceweb.mapper.BaseMapper;
import com.eshop.serviceweb.mapper.RoleMapper;
import com.eshop.serviceweb.model.Role;
import com.eshop.serviceweb.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService extends BaseService<Role> implements IRoleService {

    @Autowired
    private RoleMapper roleMapper;
    @Override
    public BaseMapper<Role> getBaseMapper() {
        return roleMapper;
    }

    @Override
    public ResultEntity<String> addForResultEntity(Role role) {
        Role r = new Role();
        r.setRoleCode(role.getRoleCode());
        List<Role> list = roleMapper.getList(r);
        if(list.size()>0){
            return proccessResultEntity(ResultEntity.ALREADY_EXIST, ResultEntity.MSG_FAILED, "role code exist!");
        }
        r.setRoleName(role.getRoleName());
        List<Role> roles = roleMapper.getList(r);
        if(roles.size()>0){
            return proccessResultEntity(ResultEntity.ALREADY_EXIST, ResultEntity.MSG_FAILED, "role name exist!");
        }
        int result = add(role);
        return proccessResultEntity(result > 0 ? ResultEntity.SUCCESS
                : ResultEntity.FAILD, result > 0 ? ResultEntity.MSG_SUCCESS : "", "");
    }
}

package com.eshop.serviceweb.service.impl;

import com.eshop.serviceweb.common.model.ResultEntity;
import com.eshop.serviceweb.mapper.BaseMapper;
import com.eshop.serviceweb.mapper.SettleBatchMapper;
import com.eshop.serviceweb.model.SettleBatch;
import com.eshop.serviceweb.service.ISettleBatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SettleBatchService extends BaseService<SettleBatch> implements ISettleBatchService {

    @Autowired
    private SettleBatchMapper settleBatchMapper;

    @Override
    public BaseMapper<SettleBatch> getBaseMapper() {
        return settleBatchMapper;
    }

    @Override
    public ResultEntity<String> addForResultEntity(SettleBatch settleBatch) {
        int result = add(settleBatch);
        return proccessResultEntity(result > 0 ? ResultEntity.SUCCESS
                : ResultEntity.FAILD, result > 0 ? ResultEntity.MSG_SUCCESS : "", "");
    }

}

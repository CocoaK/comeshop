package com.eshop.serviceweb.service.impl;

import com.eshop.serviceweb.mapper.BaseMapper;
import com.eshop.serviceweb.mapper.SettleDetailsMapper;
import com.eshop.serviceweb.model.SettleDetails;
import com.eshop.serviceweb.service.ISettleDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SettleDetailsService extends BaseService<SettleDetails> implements ISettleDetailsService {

    @Autowired
    private SettleDetailsMapper settleDetailsMapper;

    @Override
    public BaseMapper<SettleDetails> getBaseMapper() {
        return settleDetailsMapper;
    }
}

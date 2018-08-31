package com.eshop.serviceweb.service.impl;

import com.eshop.serviceweb.mapper.BaseMapper;
import com.eshop.serviceweb.mapper.RebateDetailsMapper;
import com.eshop.serviceweb.model.RebateDetails;
import com.eshop.serviceweb.service.IRebateDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RebateDetailsService extends BaseService<RebateDetails> implements IRebateDetailsService {

    @Autowired
    private RebateDetailsMapper rebateDetailsMapper;

    @Override
    public BaseMapper<RebateDetails> getBaseMapper() {
        return rebateDetailsMapper;
    }
}

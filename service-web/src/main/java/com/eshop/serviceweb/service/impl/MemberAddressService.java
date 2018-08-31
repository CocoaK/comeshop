package com.eshop.serviceweb.service.impl;

import com.eshop.serviceweb.mapper.BaseMapper;
import com.eshop.serviceweb.mapper.MemberAddressMapper;
import com.eshop.serviceweb.model.MemberAddress;
import com.eshop.serviceweb.service.IMemberAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberAddressService extends BaseService<MemberAddress> implements IMemberAddressService {

    @Autowired
    private MemberAddressMapper memberAddressMapper;

    @Override
    public BaseMapper<MemberAddress> getBaseMapper() {
        return memberAddressMapper;
    }
}

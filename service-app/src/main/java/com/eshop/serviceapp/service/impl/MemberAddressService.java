package com.eshop.serviceapp.service.impl;

import com.eshop.serviceapp.mapper.BaseMapper;
import com.eshop.serviceapp.mapper.MemberAddressMapper;
import com.eshop.serviceapp.model.MemberAddress;
import com.eshop.serviceapp.service.IMemberAddressService;
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

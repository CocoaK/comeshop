package com.eshop.serviceweb.service;

import java.util.List;

import com.eshop.serviceweb.common.model.ResultEntity;
import com.eshop.serviceweb.model.SettleBatch;
import com.eshop.serviceweb.vo.RebateDetailsVO;

public interface ISettleService {

    ResultEntity<String> execute(SettleBatch settleBatch);
    
    ResultEntity<String> executeRebate(List<RebateDetailsVO> rebateDetailsVOList);
}

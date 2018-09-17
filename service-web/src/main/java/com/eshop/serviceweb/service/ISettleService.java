package com.eshop.serviceweb.service;

import java.util.List;
import com.eshop.serviceweb.common.model.ResultEntity;
import com.eshop.serviceweb.common.model.ResultList;
import com.eshop.serviceweb.model.SettleBatch;
import com.eshop.serviceweb.vo.PageVO;
import com.eshop.serviceweb.vo.RebateDetailsVO;
import com.eshop.serviceweb.vo.UnSettledVO;

public interface ISettleService {

    ResultEntity<String> execute(SettleBatch settleBatch);
    
    ResultEntity<String> executeRebate(List<RebateDetailsVO> rebateDetailsVOList);

    ResultEntity<UnSettledVO> queryList(SettleBatch SettleBatch);

    ResultList<List> getUnSettleOrderSumPageList(SettleBatch settleBatch);

    ResultList<List> getUnSettleOrderPageList(PageVO pageVO);
}

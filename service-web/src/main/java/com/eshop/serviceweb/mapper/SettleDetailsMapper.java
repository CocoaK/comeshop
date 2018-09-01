package com.eshop.serviceweb.mapper;

import com.eshop.serviceweb.model.SettleDetails;

import java.math.BigDecimal;

public interface SettleDetailsMapper extends BaseMapper<SettleDetails> {

    BigDecimal getProfitAmtSum(Integer settleBatchId);

    BigDecimal getRebateAmtSum(Integer settleBatchId);
}
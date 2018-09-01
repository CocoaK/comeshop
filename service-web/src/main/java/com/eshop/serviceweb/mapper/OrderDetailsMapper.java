package com.eshop.serviceweb.mapper;

import com.eshop.serviceweb.model.OrderDetails;

import java.math.BigDecimal;

public interface OrderDetailsMapper extends BaseMapper<OrderDetails> {

    BigDecimal getProfitAmtSum(Integer orderId);

    BigDecimal getRebateAmtSum(Integer orderId);
}
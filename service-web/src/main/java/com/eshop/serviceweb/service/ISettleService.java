package com.eshop.serviceweb.service;

import com.eshop.serviceweb.common.model.ResultEntity;
import com.eshop.serviceweb.model.SettleBatch;

public interface ISettleService {

    ResultEntity<String> execute(SettleBatch settleBatch);
}

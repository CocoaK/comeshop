package com.eshop.serviceweb.mapper;

import com.eshop.serviceweb.model.SettleBatch;

public interface SettleBatchMapper extends BaseMapper<SettleBatch> {

    SettleBatch getNewestOne();
}
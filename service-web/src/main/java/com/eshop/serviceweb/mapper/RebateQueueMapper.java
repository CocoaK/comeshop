package com.eshop.serviceweb.mapper;

import java.util.List;

import com.eshop.serviceweb.model.RebateQueue;

public interface RebateQueueMapper extends BaseMapper<RebateQueue> {

    Integer getMaxRebateSeq();

	List<RebateQueue> getAllQueue();
	
	List<RebateQueue> getQueueGroup();
}

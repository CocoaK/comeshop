package com.eshop.serviceweb.service;

import java.util.List;

import com.eshop.serviceweb.common.model.ResultEntity;
import com.eshop.serviceweb.model.RebateQueue;

public interface IRebateQueueService {
	List<RebateQueue> getAllQueue();
	
	List<RebateQueue> getQueueGroup();
}

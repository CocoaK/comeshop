package com.eshop.serviceweb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eshop.serviceweb.mapper.RebateQueueMapper;
import com.eshop.serviceweb.model.RebateQueue;
import com.eshop.serviceweb.service.IRebateQueueService;

@Service
public class RebateQueueService implements IRebateQueueService{
	
	@Autowired
    private RebateQueueMapper rebateQueueMapper;
	
	@Override
	public List<RebateQueue> getAllQueue(){
		return rebateQueueMapper.getAllQueue();
	}
	
	@Override
	public List<RebateQueue> getQueueGroup(){
		return rebateQueueMapper.getQueueGroup();
	}
}

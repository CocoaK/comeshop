package com.eshop.serviceweb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.eshop.serviceweb.model.RebateQueue;
import com.eshop.serviceweb.service.IRebateQueueService;

@RestController
@RequestMapping(value = "/rebatequeue")
public class RebateQueueController {
	
	@Autowired
    private IRebateQueueService rebateQueueService;

    @RequestMapping("/getAllQueue")
    public @ResponseBody
    List<RebateQueue> getAllQueue() {
        return rebateQueueService.getAllQueue();
    }
    
    @RequestMapping("/getQueueGroup")
    public @ResponseBody
    List<RebateQueue> getQueueGroup() {
        return rebateQueueService.getQueueGroup();
    }
}

package com.eshop.serviceweb.controller;

import com.eshop.serviceweb.common.model.ResultEntity;
import com.eshop.serviceweb.model.SettleBatch;
import com.eshop.serviceweb.service.ISettleService;
import com.eshop.serviceweb.vo.RebateDetailsVO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/settle")
public class SettleController {

    @Autowired
    private ISettleService settleService;

    @RequestMapping("/execute")
    public @ResponseBody
    ResultEntity<String> execute(@RequestBody SettleBatch settleBatch) {
//        SettleBatch settleBatch = new SettleBatch();
        return settleService.execute(settleBatch);
    }
    
    @RequestMapping("/executeRebate")
    public @ResponseBody
    ResultEntity<String> executeRebate(@RequestBody List<RebateDetailsVO> rebateDetailsVOList) {
//        SettleBatch settleBatch = new SettleBatch();
        return settleService.executeRebate(rebateDetailsVOList);
    }

}

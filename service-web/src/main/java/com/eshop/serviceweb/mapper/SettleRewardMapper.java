package com.eshop.serviceweb.mapper;

import com.eshop.serviceweb.model.SettleReward;

import java.util.List;
import java.util.Map;

public interface SettleRewardMapper extends BaseMapper<SettleReward> {

    //会员和创客的会员费
    List<Map> getRenewExtract(SettleReward settleReward);

    //直推会员消费
    Map getConsumptionExtract1(SettleReward settleReward);

    //伞下平级会员消费
    Map getConsumptionExtract2(SettleReward settleReward);

    //伞下不平级会员消费
    Map getConsumptionExtract3(SettleReward settleReward);

}
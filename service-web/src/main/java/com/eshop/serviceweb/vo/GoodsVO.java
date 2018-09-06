package com.eshop.serviceweb.vo;

import com.eshop.serviceweb.model.Goods;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

public class GoodsVO extends Goods {

    private String goodsMediaUrl;

    private BigDecimal discontAmt;
    @NotNull
    private Integer goodsQty;
    @NotNull
    private BigDecimal price;
    @NotNull
    private String zoneCode;

    private Boolean isCommend;

    private Boolean isNew;

    private Boolean isHot;

    private Boolean isHighQuality;

    public BigDecimal getDiscontAmt() {
        return discontAmt;
    }

    public void setDiscontAmt(BigDecimal discontAmt) {
        this.discontAmt = discontAmt;
    }

    public Integer getGoodsQty() {
        return goodsQty;
    }

    public void setGoodsQty(Integer goodsQty) {
        this.goodsQty = goodsQty;
    }

    public BigDecimal getPrice() {
        return price;
    }
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Boolean getCommend() {
        return isCommend;
    }

    public void setCommend(Boolean commend) {
        isCommend = commend;
    }

    public Boolean getNew() {
        return isNew;
    }

    public void setNew(Boolean aNew) {
        isNew = aNew;
    }

    public Boolean getHot() {
        return isHot;
    }

    public void setHot(Boolean hot) {
        isHot = hot;
    }

    public Boolean getHighQuality() {
        return isHighQuality;
    }

    public void setHighQuality(Boolean highQuality) {
        isHighQuality = highQuality;
    }

    public String getZoneCode() {
        return zoneCode;
    }

    public void setZoneCode(String zoneCode) {
        this.zoneCode = zoneCode;
    }
}

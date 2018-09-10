package com.eshop.serviceapp.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

public class GoodsModelVO implements Serializable {

    private Integer zoneGoodsId;

    private Integer goodsModelId;

    private String goodsModelName;

    private List<Object> goodsModelImages;

    private BigDecimal price;

    public Integer getZoneGoodsId() {
        return zoneGoodsId;
    }

    public void setZoneGoodsId(Integer zoneGoodsId) {
        this.zoneGoodsId = zoneGoodsId;
    }

    public String getGoodsModelName() {
        return goodsModelName;
    }

    public void setGoodsModelName(String goodsModelName) {
        this.goodsModelName = goodsModelName;
    }

    public List<Object> getGoodsModelImages() {
        return goodsModelImages;
    }

    public void setGoodsModelImages(List<Object> goodsModelImages) {
        this.goodsModelImages = goodsModelImages;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getGoodsModelId() {
        return goodsModelId;
    }

    public void setGoodsModelId(Integer goodsModelId) {
        this.goodsModelId = goodsModelId;
    }
}

package com.eshop.serviceapp.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public class ZoneGoodsDetailVO implements Serializable {

    private Integer zoneGoodsId;

    private Integer goodsId;

    private String goodsName;

    private String goodsCode;

    private String goodsBrief;

    private String goodsDesc;

    private BigDecimal price;

    private List<Object> goodsImage;

    private String zoneCode;

    public String getZoneCode() {
        return zoneCode;
    }

    public void setZoneCode(String zoneCode) {
        this.zoneCode = zoneCode;
    }
    //private List<Object> goodsModelImage;

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getZoneGoodsId() {
        return zoneGoodsId;
    }

    public void setZoneGoodsId(Integer zoneGoodsId) {
        this.zoneGoodsId = zoneGoodsId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getGoodsCode() {
        return goodsCode;
    }

    public void setGoodsCode(String goodsCode) {
        this.goodsCode = goodsCode;
    }

    public String getGoodsBrief() {
        return goodsBrief;
    }

    public void setGoodsBrief(String goodsBrief) {
        this.goodsBrief = goodsBrief;
    }

    public String getGoodsDesc() {
        return goodsDesc;
    }

    public void setGoodsDesc(String goodsDesc) {
        this.goodsDesc = goodsDesc;
    }

    public List<Object> getGoodsImage() {
        return goodsImage;
    }

    public void setGoodsImage(List<Object> goodsImage) {
        this.goodsImage = goodsImage;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }
}

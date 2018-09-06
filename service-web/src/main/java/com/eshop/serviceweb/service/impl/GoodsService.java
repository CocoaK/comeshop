package com.eshop.serviceweb.service.impl;

import com.eshop.serviceweb.common.Constants;
import com.eshop.serviceweb.common.model.ResultEntity;
import com.eshop.serviceweb.mapper.BaseMapper;
import com.eshop.serviceweb.mapper.GoodsMapper;
import com.eshop.serviceweb.mapper.GoodsMediaMapper;
import com.eshop.serviceweb.mapper.ZoneGoodsMapper;
import com.eshop.serviceweb.model.Goods;
import com.eshop.serviceweb.model.GoodsMedia;
import com.eshop.serviceweb.model.GoodsModel;
import com.eshop.serviceweb.model.ZoneGoods;
import com.eshop.serviceweb.service.IGoodsService;
import com.eshop.serviceweb.vo.GoodsVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;

@Service
public class GoodsService extends BaseService<Goods> implements IGoodsService {

    @Autowired
    private GoodsMapper goodsMapper;

    @Autowired
    private GoodsMediaMapper goodsMediaMapper;

    @Value("${file.upload.imageFormat}")
    private String imageFormat;
    @Value("${file.upload.videoFormat}")
    private String videoFormat;

    @Override
    public BaseMapper<Goods> getBaseMapper() {
        return goodsMapper;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public ResultEntity<String> addForResultEntity(Goods goods) {
        ResultEntity<String> re = new ResultEntity<String>();
        if(null == goods){
            return re;
        }
        goods.setGoodsCode("g"+System.currentTimeMillis());
        int result = add(goods);
        String urls = goods.getGoodsMediaUrl();
        if(urls != null){
            for(String url : urls.split(",")){
                GoodsMedia goodsMedia = new GoodsMedia();
                goodsMedia.setBuCode(goods.getBuCode());
                goodsMedia.setCurrentUser(goods.getCurrentUser());
                goodsMedia.setGoodsId(goods.getGoodsId());
                goodsMedia.setMediaType(getMediaType(url));
                goodsMedia.setMediaUrl(url);
                goodsMedia.setRowId(goods.getRowId());
                result = goodsMediaMapper.insertActive(goodsMedia);
            }
        }
        return proccessResultEntity(result > 0 ? ResultEntity.SUCCESS
                : ResultEntity.FAILD, result > 0 ? ResultEntity.MSG_SUCCESS : "", "");
    }

    private String getMediaType(String fileName){
        String mediaType = null;
        if(fileName!=null){
            String extName = fileName.substring(fileName.indexOf(".")+1, fileName.length());
            if(Arrays.asList(imageFormat.split(",")).contains(extName)){
                mediaType = Constants.GOODS_MEDIA_TYPE_IMAGE;
            }else if(Arrays.asList(videoFormat.split(",")).contains(extName)){
                mediaType = Constants.GOODS_MEDIA_TYPE_VIDEO;
            }
        }
        return mediaType;
    }
}

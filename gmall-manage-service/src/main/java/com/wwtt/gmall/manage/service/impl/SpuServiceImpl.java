package com.wwtt.gmall.manage.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.wwtt.gmall.bean.PmsProductImage;
import com.wwtt.gmall.bean.PmsProductInfo;
import com.wwtt.gmall.bean.PmsProductSaleAttr;
import com.wwtt.gmall.bean.PmsProductSaleAttrValue;
import com.wwtt.gmall.manage.mapper.SpuImageMapper;
import com.wwtt.gmall.manage.mapper.SpuInfoMapper;
import com.wwtt.gmall.manage.mapper.SpuSaleAttrMapper;
import com.wwtt.gmall.manage.mapper.SpuSaleAttrValueMapper;
import com.wwtt.gmall.service.SpuService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class SpuServiceImpl implements SpuService {

    @Autowired
    SpuInfoMapper spuInfoMapper;
    
    @Autowired
    SpuSaleAttrMapper spuSaleAttrMapper;
    
    @Autowired
    SpuSaleAttrValueMapper spuSaleAttrValueMapper;

    @Autowired
    SpuImageMapper spuImageMapper;

    @Override
    public List<PmsProductInfo> getSpuList(String catalog3Id) {
        PmsProductInfo pmsProductInfo = new PmsProductInfo();
        pmsProductInfo.setCatalog3Id(catalog3Id);
        List<PmsProductInfo> pmsProductInfos = spuInfoMapper.select(pmsProductInfo);
        return pmsProductInfos;
    }

    @Override
    public String saveSpuInfo(PmsProductInfo pmsProductInfo) {
        spuInfoMapper.insertSelective(pmsProductInfo);

        List<PmsProductImage> pmsProductImages = pmsProductInfo.getSpuImageList();
        for (PmsProductImage pmsProductImage : pmsProductImages) {
            pmsProductImage.setProductId(pmsProductInfo.getId());
            spuImageMapper.insertSelective(pmsProductImage);
        }

        List<PmsProductSaleAttr> pmsProductSaleAttrs = pmsProductInfo.getSpuSaleAttrList();
        for (PmsProductSaleAttr pmsProductSaleAttr : pmsProductSaleAttrs) {
            pmsProductSaleAttr.setProductId(pmsProductInfo.getId());
            spuSaleAttrMapper.insertSelective(pmsProductSaleAttr);
            
            List<PmsProductSaleAttrValue> pmsProductSaleAttrValues = pmsProductSaleAttr.getSpuSaleAttrValueList();
            for (PmsProductSaleAttrValue pmsProductSaleAttrValue : pmsProductSaleAttrValues) {
                pmsProductSaleAttrValue.setProductId(pmsProductInfo.getId());
                spuSaleAttrValueMapper.insertSelective(pmsProductSaleAttrValue);
            }
        }
        
        
        return "success";
    }
}

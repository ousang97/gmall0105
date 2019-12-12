package com.wwtt.gmall.manage.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.wwtt.gmall.bean.PmsProductInfo;
import com.wwtt.gmall.manage.mapper.SpuInfoMapper;
import com.wwtt.gmall.service.SpuService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class SpuServiceImpl implements SpuService {

    @Autowired
    SpuInfoMapper spuInfoMapper;

    @Override
    public List<PmsProductInfo> getSpuList(String catalog3Id) {
        PmsProductInfo pmsProductInfo = new PmsProductInfo();
        pmsProductInfo.setCatalog3Id(catalog3Id);
        List<PmsProductInfo> pmsProductInfos = spuInfoMapper.select(pmsProductInfo);
        return pmsProductInfos;
    }
}

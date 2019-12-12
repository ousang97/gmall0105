package com.wwtt.gmall.service;

import com.wwtt.gmall.bean.PmsProductInfo;

import java.util.List;

public interface SpuService {

    List<PmsProductInfo> getSpuList(String catalog3Id);
}

package com.wwtt.gmall.service;

import com.wwtt.gmall.bean.PmsBaseAttrInfo;
import com.wwtt.gmall.bean.PmsBaseAttrValue;

import java.util.List;

public interface AttrService {

    List<PmsBaseAttrInfo> getAttrListInfo(String catalog3Id);

    List<PmsBaseAttrValue> getAttrValueList(String attrId);

    String saveAttrInfo(PmsBaseAttrInfo pmsBaseAttrInfo);
}

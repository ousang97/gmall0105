package com.wwtt.gmall.manage.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.wwtt.gmall.bean.PmsBaseAttrInfo;
import com.wwtt.gmall.bean.PmsBaseAttrValue;
import com.wwtt.gmall.bean.PmsBaseSaleAttr;
import com.wwtt.gmall.service.AttrService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@CrossOrigin
public class AttrController {

    @Reference
    AttrService attrService;

    @RequestMapping("attrInfoList")
    @ResponseBody
    public List<PmsBaseAttrInfo> getAttrListInfo(String catalog3Id){
        List<PmsBaseAttrInfo> attrInfos = attrService.getAttrListInfo(catalog3Id);
        return attrInfos;
    }

    @RequestMapping("getAttrValueList")
    @ResponseBody
    public List<PmsBaseAttrValue> getAttrValueList(String attrId){
        List<PmsBaseAttrValue> attrValues = attrService.getAttrValueList(attrId);
        return attrValues;
    }

    @RequestMapping("saveAttrInfo")
    @ResponseBody
    public String saveAttrInfo(@RequestBody PmsBaseAttrInfo pmsBaseAttrInfo){

        String sueeess = attrService.saveAttrInfo(pmsBaseAttrInfo);

        return "seccess";
    }

    @RequestMapping("baseSaleAttrList")
    @ResponseBody
    public List<PmsBaseSaleAttr> getBaseSaleAttrList(){
        List<PmsBaseSaleAttr> baseSaleAttrs = attrService.getBaseSaleAttrList();
        return baseSaleAttrs;
    }
}

package com.wwtt.gmall.manage.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.wwtt.gmall.bean.PmsProductInfo;
import com.wwtt.gmall.service.SpuService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@CrossOrigin
public class SpuController {

    @Reference
    SpuService spuService;

    @RequestMapping("spuList")
    @ResponseBody
    public List<PmsProductInfo> getSpuList(String catalog3Id){
        List<PmsProductInfo> pmsProductInfos = spuService.getSpuList(catalog3Id);
        return pmsProductInfos;
    }

}

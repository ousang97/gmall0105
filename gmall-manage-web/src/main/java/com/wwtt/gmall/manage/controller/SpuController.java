package com.wwtt.gmall.manage.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.wwtt.gmall.bean.PmsProductInfo;
import com.wwtt.gmall.service.SpuService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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

    @RequestMapping("saveSpuInfo")
    @ResponseBody
    public  String saveSpuInfo(@RequestBody PmsProductInfo pmsProductInfo){

        String success = spuService.saveSpuInfo(pmsProductInfo);
        return "succes";
    }

    @RequestMapping("fileUpload")
    @ResponseBody
    public String fileUpload(@RequestParam("file") MultipartFile multipartFile){

        //将图片或者视频上传到分布式的文件存储系统

        //将图片的存储路径返回给页面
        String imgUrl ="";
        return imgUrl;
    }


}

package com.wwtt.gmall.user.controller;


import com.wwtt.gmall.bean.UmsMember;
import com.wwtt.gmall.bean.UmsMemberReceiveAddress;
import com.wwtt.gmall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    UserService userService ;

    @RequestMapping("index")
    @ResponseBody
    public String index(){
        return "hello user";
    }

    @RequestMapping("getAllUser")
    @ResponseBody
    public List<UmsMember> getAllUser(){
       List<UmsMember> umsMember = userService.getAllUser();
        return umsMember;
    }

    @RequestMapping("getReceiveAddressByMemberId")
    @ResponseBody
    public List<UmsMemberReceiveAddress>  getReceiveAddressByMemberId(String memberId){
        List<UmsMemberReceiveAddress>  receiveAddresses = userService.getReceiveAddressByMemberId(memberId);
        return receiveAddresses;
    }
}

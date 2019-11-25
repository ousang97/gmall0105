package com.wwtt.gmall.service;

import com.wwtt.gmall.bean.UmsMember;
import com.wwtt.gmall.bean.UmsMemberReceiveAddress;

import java.util.List;


public interface UserService {
    List<UmsMember> getAllUser();

    List<UmsMemberReceiveAddress> getReceiveAddressByMemberId(String memberId);
}

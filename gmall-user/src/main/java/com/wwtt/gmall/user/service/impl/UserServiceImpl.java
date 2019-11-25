package com.wwtt.gmall.user.service.impl;

import com.wwtt.gmall.bean.UmsMember;
import com.wwtt.gmall.bean.UmsMemberReceiveAddress;
import com.wwtt.gmall.service.UserService;
import com.wwtt.gmall.user.mapper.UmsMemberReceiveAddressMapper;
import com.wwtt.gmall.user.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;
    @Autowired
    UmsMemberReceiveAddressMapper umsMemberReceiveAddressMapper;


    @Override
    public List<UmsMember> getAllUser() {

        List<UmsMember> umsMembers = userMapper.selectAll();//userMapper.selectAllUser();
        return umsMembers;
    }

    @Override
    public List<UmsMemberReceiveAddress> getReceiveAddressByMemberId(String memberId) {
       /* Example e = new Example(UmsMemberReceiveAddress.class);
        e.createCriteria().andEqualTo("memberId",memberId);*/
       UmsMemberReceiveAddress umsMemberReceiveAddress = new UmsMemberReceiveAddress();
        umsMemberReceiveAddress.setMemberId(memberId);
        List<UmsMemberReceiveAddress> receiveAddresses = umsMemberReceiveAddressMapper.select(umsMemberReceiveAddress);
        return receiveAddresses;
    }
}

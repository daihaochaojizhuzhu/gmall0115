package com.ww.gmall.user.service.impl;

import com.ww.gmall.user.bean.UmsMember;
import com.ww.gmall.user.bean.UmsMemberReceiveAddress;
import com.ww.gmall.user.mapper.UmsMemberReceiveAddressMapper;
import com.ww.gmall.user.mapper.UserMapper;
import com.ww.gmall.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UmsMemberReceiveAddressMapper umsMemberReceiveAddressMapper;

    @Override
    public List<UmsMember> getAllUser() {
        List<UmsMember> umsMemberList=userMapper.selectAll();
        return umsMemberList;
    }

    @Override
    public List<UmsMemberReceiveAddress> getReceiveAddressByMemberId(String memberId) {
        //UmsMemberReceiveAddress umsMemberReceiveAddress=new UmsMemberReceiveAddress();
        //umsMemberReceiveAddress.setMemberId(memberId);
        //List<UmsMemberReceiveAddress> umsMemberReceiveAddressList=umsMemberReceiveAddressMapper.select(umsMemberReceiveAddress);
        Example example=new Example(UmsMemberReceiveAddress.class);
        example.createCriteria().andEqualTo("memberId",memberId);
        List<UmsMemberReceiveAddress> umsMemberReceiveAddressList=umsMemberReceiveAddressMapper.selectByExample(example);
        return umsMemberReceiveAddressList;
    }
}

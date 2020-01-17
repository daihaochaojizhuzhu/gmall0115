package com.ww.gmall.user.service;

import com.ww.gmall.user.bean.UmsMember;
import com.ww.gmall.user.bean.UmsMemberReceiveAddress;

import java.util.List;

public interface UserService {
    List<UmsMember> getAllUser();

    List<UmsMemberReceiveAddress> getReceiveAddressByMemberId(String memberId);
}

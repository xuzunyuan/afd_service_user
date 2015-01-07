package com.afd.user.dao;

import com.afd.model.user.UserAddress;

public interface UserAddressMapper {
    int deleteByPrimaryKey(Integer addrId);

    int insert(UserAddress record);

    int insertSelective(UserAddress record);

    UserAddress selectByPrimaryKey(Integer addrId);

    int updateByPrimaryKeySelective(UserAddress record);

    int updateByPrimaryKey(UserAddress record);
}
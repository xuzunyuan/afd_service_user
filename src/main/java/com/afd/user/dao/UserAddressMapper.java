package com.afd.user.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.afd.model.user.UserAddress;

public interface UserAddressMapper {
    int deleteByPrimaryKey(Integer addrId);

    int insert(UserAddress record);

    int insertSelective(UserAddress record);

    UserAddress selectByPrimaryKey(Integer addrId);

    int updateByPrimaryKeySelective(UserAddress record);

    int updateByPrimaryKey(UserAddress record);

	List<UserAddress> getAddressByUserId(@Param("userId")long userId);
}
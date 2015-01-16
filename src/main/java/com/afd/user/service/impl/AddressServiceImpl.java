package com.afd.user.service.impl;

import java.util.List;

import com.afd.common.util.DateUtils;
import com.afd.constants.user.UserConstants;
import com.afd.model.user.UserAddress;
import com.afd.service.user.IAddressService;
import com.afd.user.dao.UserAddressMapper;

public class AddressServiceImpl implements IAddressService {
	
	private UserAddressMapper userAddressMapper;

	@Override
	public UserAddress getAddressById(int addressId) {
		return this.userAddressMapper.selectByPrimaryKey(addressId);
	}

	@Override
	public List<UserAddress> getAddressesByUserId(long userId) {
		return this.userAddressMapper.getAddressByUserId(userId);
	}

	@Override
	public int addAddress(UserAddress address) {
		if(address !=null){
			address.setCreateDate(DateUtils.currentDate());
			return this.userAddressMapper.insertSelective(address);
		}
		return 0;
	}

	@Override
	public int delAddress(int addrId) {
		UserAddress address = new UserAddress();
		address.setAddrId(addrId);
		address.setUpdateDate(DateUtils.currentDate());
		address.setStatus(UserConstants.ADDRESS_STATUS_INVALID);
		return this.userAddressMapper.updateByPrimaryKeySelective(address);
	}

	@Override
	public int updateAddress(UserAddress address) {
		if(address!=null&&address.getAddrId()!=null){
			address.setUpdateDate(DateUtils.currentDate());
			return this.userAddressMapper.updateByPrimaryKeySelective(address);
		}
		return 0;
	}

}

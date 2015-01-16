package com.afd.user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.afd.model.user.User;
import com.afd.service.user.IUserService;
import com.afd.user.dao.UserMapper;

public class UserServiceImpl implements IUserService {

	@Autowired
	private UserMapper userMapper;
	@Override
	public boolean uniqueUserName(String userName) {
		int count = this.userMapper.userCount(userName);
		if(count >1){
			return false;
		}
		return true;
	}
	@Override
	public User getUserById(Long userId){
		return this.userMapper.selectByPrimaryKey(userId);
	}
}

package com.afd.user.service.impl;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.afd.common.util.DateUtils;
import com.afd.constants.SystemConstants;
import com.afd.model.user.User;
import com.afd.service.user.IUserService;
import com.afd.user.dao.UserMapper;

@Service("userService")
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
	@Override
	public Long register(User user) {
		if(user!=null){
			//注册日期
			user.setRegDate(DateUtils.currentDate());
			String userKey = RandomStringUtils.randomAlphanumeric(20);
			String pwd = DigestUtils.md5Hex(DigestUtils.md5Hex(userKey+SystemConstants.WEB_KEY)+user.getPwd());
			user.setPwdKey(userKey);
			user.setPwd(pwd);
			this.userMapper.insertSelective(user);
			return user.getUserId();
		}
		return null;
	}
	
	public static void main(String[] args) {
		System.out.println(RandomStringUtils.randomAlphanumeric(20));
	}
	
	@Override
	public User getUserByUserName(String userName) {
		return this.userMapper.selectUserByUserName(userName);
	}
}

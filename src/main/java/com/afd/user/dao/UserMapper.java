package com.afd.user.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.afd.model.user.User;

public interface UserMapper {
    int deleteByPrimaryKey(Integer userId);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Long userId);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    @Select("SELECT count(*) FROM t_user WHERE user_name = #{userName}")
	int userCount(String userName);
    
    User selectUserByUserName(@Param("userName")String userName);

    @Select("SELECT count(*) FROM t_user WHERE mobile = #{mobile}")
	int mobileCount(String mobile);

	User selectUserByMobile(@Param("mobile")String mobile);
}
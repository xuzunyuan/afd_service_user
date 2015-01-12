package com.afd.user.dao;

import org.apache.ibatis.annotations.Select;

import com.afd.model.user.User;

public interface UserMapper {
    int deleteByPrimaryKey(Integer userId);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    @Select("SELECT count(*) FROM t_user WHERE user_name = #{userName}")
	int userCount(String userName);
}
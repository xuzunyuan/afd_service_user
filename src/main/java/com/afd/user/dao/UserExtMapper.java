package com.afd.user.dao;

import com.afd.model.user.UserExt;

public interface UserExtMapper {
    int deleteByPrimaryKey(Long userId);

	UserExt selectByPrimaryKey(Long userId);

	int updateByPrimaryKeySelective(UserExt record);

	int updateByPrimaryKey(UserExt record);

	int insert(UserExt record);

    int insertSelective(UserExt record);
}
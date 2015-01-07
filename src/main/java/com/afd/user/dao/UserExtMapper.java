package com.afd.user.dao;

import com.afd.model.user.UserExt;

public interface UserExtMapper {
    int insert(UserExt record);

    int insertSelective(UserExt record);
}
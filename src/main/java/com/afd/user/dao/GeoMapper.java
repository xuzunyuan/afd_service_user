package com.afd.user.dao;

import com.afd.model.user.Geo;

public interface GeoMapper {
    int deleteByPrimaryKey(Integer geoId);

    int insert(Geo record);

    int insertSelective(Geo record);

    Geo selectByPrimaryKey(Integer geoId);

    int updateByPrimaryKeySelective(Geo record);

    int updateByPrimaryKey(Geo record);
}
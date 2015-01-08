package com.afd.user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.afd.model.user.Geo;
import com.afd.user.dao.GeoMapper;

@Service
public class TestService {
	@Autowired
	GeoMapper geoMapper;

	public Geo selectGeoById(Integer geoId) {
		return geoMapper.selectByPrimaryKey(geoId);
	}
}

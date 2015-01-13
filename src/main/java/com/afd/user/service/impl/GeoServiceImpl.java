package com.afd.user.service.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.afd.constants.SystemConstants;
import com.afd.constants.user.UserConstants;
import com.afd.model.user.Geo;
import com.afd.service.user.IGeoService;
import com.afd.user.dao.GeoMapper;

@Service("geoService")
public class GeoServiceImpl implements IGeoService {
	private Logger log = LoggerFactory.getLogger(GeoServiceImpl.class); 
	
	@Autowired
	private RedisTemplate<String, Object> redisTemplate;
	@Autowired
	private GeoMapper geoMapper;

	@SuppressWarnings("unchecked")
	@Override
	public List<Geo> getGeoProvince() {
		List<Geo> provinces = new ArrayList<Geo>();
		try{
			provinces = (List<Geo>)this.redisTemplate.opsForValue().get(SystemConstants.CACHE_PREFIX+UserConstants.GEO_PROVINCE);
			if(provinces==null||provinces.size()==0){
				provinces = this.geoMapper.getGeoByLevel(UserConstants.GEO_LEVEL_PROVINCE);
				this.redisTemplate.opsForValue().set(SystemConstants.CACHE_PREFIX+UserConstants.GEO_PROVINCE, provinces);
			}
		}catch(Exception e){
			log.error(e.getMessage(),e);
			provinces = this.geoMapper.getGeoByLevel(UserConstants.GEO_LEVEL_PROVINCE);
		}
		return provinces;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Geo> getGeoByFId(long fid) {
		List<Geo> geos = new ArrayList<Geo>();
		try{
			geos = (List<Geo>) this.redisTemplate.opsForValue().get(SystemConstants.CACHE_PREFIX+UserConstants.GEO_BY_FID+fid);
			if(geos==null||geos.size()==0){
				geos = this.geoMapper.getGeoByFid(fid);
				if(geos!=null&&geos.size()>0){
					this.redisTemplate.opsForValue().set(SystemConstants.CACHE_PREFIX+UserConstants.GEO_BY_FID+fid,geos);
				}
			}
		}catch(Exception e){
			log.error(e.getMessage(), e);
			geos = this.geoMapper.getGeoByFid(fid);
		}
		
		return geos;
	}

	@Override
	public Geo getGeoById(int id) {
		Geo geo = null;
		try{
			geo = (Geo) this.redisTemplate.opsForValue().get(SystemConstants.CACHE_PREFIX+UserConstants.GEO+id);
			if(geo == null){
				geo = this.geoMapper.selectByPrimaryKey(id);
				if(geo!=null){
					this.redisTemplate.opsForValue().set(SystemConstants.CACHE_PREFIX+UserConstants.GEO+geo.getGeoId(),geo);
				}
			}
		}catch(Exception e){
			log.error(e.getMessage(), e);
			geo = this.geoMapper.selectByPrimaryKey(id);
		}
		return geo;
	}

}

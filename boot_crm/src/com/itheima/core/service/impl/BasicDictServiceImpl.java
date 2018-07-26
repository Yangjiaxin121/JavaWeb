package com.itheima.core.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itheima.core.dao.BaseDictDao;
import com.itheima.core.po.BaseDict;
import com.itheima.core.service.BaseDictService;

/**
 * 数据字典Service接口实现类
 * @author yangjiaxin
 *
 */
@Service("baseDictService")
public class BasicDictServiceImpl implements BaseDictService{
	
	@Autowired
	private BaseDictDao baseDictDao;
	@Override
	public List<BaseDict> findBaseDictByTypeCode(String typecode) {
		// TODO Auto-generated method stub
		return this.baseDictDao.selectBaseDictByTypeCode(typecode);
	}

}

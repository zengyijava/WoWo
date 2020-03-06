package com.yc.dao;

import java.util.List;

import com.yc.po.GoodTypePO;

public interface IGoodTypeDAO {
	/*
	 * 浏览商品类型
	 */
	public List<GoodTypePO> find(GoodTypePO po)throws Exception;
	
	/*
	 * 添加商品类型
	 */
	public int addGoodType(GoodTypePO po) throws Exception;
	

}

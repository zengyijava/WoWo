package com.yc.dao;

import java.util.List;

import com.yc.po.GroupBuyPO;

public interface IGroupBuyDAO {
	/*
	 * 添加团购信息
	 */
	public int addGroupBuy(GroupBuyPO po) throws Exception;
	/*
	 * 分页查询
	 */
	
	public List<GroupBuyPO> findBypage(GroupBuyPO po,Integer pageNum,Integer pageSize) 
			throws Exception;
	
	/*
	 * 分页总条数
	 */
	public int totalPage(GroupBuyPO po)throws Exception;

}

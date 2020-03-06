package com.yc.dao;

import java.util.List;

import com.yc.po.GoodPO;
import com.yc.vo.GoodVO;

public interface IGoodDAO {
	/*
	 * 添加菜品信息
	 */
	public int addGood(GoodPO po) throws Exception;
	
	/*
	 * 查看数据
	 */
	public List<GoodVO> findByPage(GoodVO vo,Integer pageNum,Integer pageSize)
			throws Exception;
	
	/*
	 * 分页查询的总条数
	 */
	public int totalPage(GoodVO vo) throws Exception;
	
	/*
	 * 查看商品对应的商品
	 */
	public List<GoodVO> findByType(GoodVO vo)throws Exception;
	
	/*
	 * 根据id字符串查看商品信息
	 */
	public List<GoodVO> findByIds(GoodVO vo,String ids)throws Exception;

}

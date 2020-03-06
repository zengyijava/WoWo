package com.yc.dao;

import java.util.List;

import com.yc.po.SellerPO;


public interface ISellerDAO {
	/*
	 * 用户登录
	 */
	public SellerPO login(SellerPO po) throws Exception;
	
	/*
	 * 分页查询
	 */
	public List<SellerPO> findByPage(SellerPO po,Integer pageNum,Integer pageSize) throws Exception;
    
	/*
	 * 分页查询总条数
	 */
	public int totalPage(SellerPO po) throws Exception;
	
	/*
	 * 商家注册
	 */
	public int regSeller(SellerPO po) throws Exception;
	
	/*
	 * 修改自己密码
	 */
	public int updatePwd(SellerPO po) throws Exception;
	/*
	 * 检查用户是否已经注册
	 */
	public List<SellerPO> findByTrem(SellerPO po) throws Exception;
}

package com.yc.dao;

import java.util.List;

import com.yc.po.AdminPO;

public interface IAdminDAO {
	/*
	 * 管理员登录
	 */
	public AdminPO login(AdminPO po) throws Exception;
	/*
	 * 修改管理员状态
	 */
	public int updateState(AdminPO po)throws Exception;
	/*
	 * 查看管理员信息 1.查看所有 2.根据状态查看
	 */
	public List<AdminPO> find(AdminPO po) throws Exception;
	
	/*
	 * 分页查询
	 */
	public List<AdminPO> findByPage(AdminPO po,Integer pageNum,Integer pageSize)
	throws Exception;
	
	/*
	 * 分页查询时总条数
	 */
	public int totalPage(AdminPO po)throws Exception;
	

}

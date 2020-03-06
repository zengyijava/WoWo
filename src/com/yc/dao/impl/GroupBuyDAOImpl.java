package com.yc.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.yc.commons.DbHelper;
import com.yc.dao.IGroupBuyDAO;
import com.yc.po.GroupBuyPO;
import com.yc.vo.GoodVO;

public class GroupBuyDAOImpl implements IGroupBuyDAO{
	DbHelper db=new DbHelper();
	@Override
	public int addGroupBuy(GroupBuyPO po) throws Exception {
		String sql="insert into tb_groupbuy values(null,?,?,?,?,?,?,?,?,0,0,?,?,?,?)";
		return db.upDate(sql,po.getG_id(),po.getGd_name(),
				po.getGb_price(),po.getGd_start(),po.getGd_end(),po.getGd_prompt(),
				po.getGd_hottip(),po.getGd_desc(),po.getGd_type(),po.getGd_typedesc(),
				po.getGd_tishi(),po.getS_id());
	}

	@Override
	public List<GroupBuyPO> findBypage(GroupBuyPO po, Integer pageNum, Integer pageSize) throws Exception {
		StringBuffer sb=new StringBuffer();
		sb.append("select * from tb_groupbuy where 1=1");
		List<Object> params=null;
		if(null!=po) {
			//团购编号
			params=new ArrayList<Object>();
			if(null!=po.getGb_id()) {
				params.add(po.getGb_id());
				sb.append(" and gb_id = ? ");
				}
			if(null!=po.getGd_name()) {
				//团购名称 模糊查询
				sb.append(" and like '%"+po.getGd_name()+"%' ");
				}
			if(null!=po.getGd_type()) {
				params.add(po.getGd_type());
				sb.append(" and gd_type=? ");
				}
			//商家编号
			if(null!=po.getS_id()) {
				params.add(po.getS_id());
				sb.append(" and s_id= ? ");
				}			
		}
		sb.append(" order by gd_num asc");
		if(null!=pageSize && null!=pageNum) {
			sb.append(" limit "+(pageNum-1)*pageSize+","+pageSize);
		}
		System.out.println(params);
		return db.findMutil(sb.toString(), params,GroupBuyPO.class);
	}

	@Override
	public int totalPage(GroupBuyPO po) throws Exception {
		StringBuffer sb=new StringBuffer();
		sb.append("select count(*) from tb_groupbuy where 1=1");
		List<Object> params=null;
		if(null!=po) {
			params=new ArrayList<Object>();
			if(null!=po.getGb_id()) {
				params.add(po.getGb_id());
				sb.append(" and gb_id = ? ");
				}
			if(null!=po.getGd_name()) {
				//团购名称 模糊查询
				sb.append(" and like '%"+po.getGd_name()+"%' ");
				}
			if(null!=po.getGd_type()) {
				params.add(po.getGd_type());
				sb.append(" and gd_type=? ");
				}
		}
		return (int) db.getPromer(sb.toString(), params);
	}

}

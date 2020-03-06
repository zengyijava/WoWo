package com.yc.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.yc.commons.DbHelper;
import com.yc.dao.ISellerDAO;
import com.yc.po.SellerPO;

public class SellerDAOImpl implements ISellerDAO{
DbHelper db=new DbHelper();
	@Override
	public SellerPO login(SellerPO po) throws Exception {
		String sql="select*from tb_seller where s_state =1 and s_tel=? and s_pwd=?";
		List<Object> params=new ArrayList<Object>();
		params.add(po.getS_tel());
		params.add(po.getS_pwd());
		List<SellerPO> list=db.findMutil(sql, params, SellerPO.class);
		if(null!=list && list.size()>0) {
			return list.get(0);
		}
		return null;
	}

	@Override
	public List<SellerPO> findByPage(SellerPO po, Integer pageNum, Integer pageSize) throws Exception {
		StringBuffer sb=new StringBuffer();
		sb.append("select *from tb_seller where 1=1");
		List<Object> params=null;
		if(null!=po) {
			params=new ArrayList<Object>();
			if(null!=po.getS_state()) {
				params.add(po.getS_state());
				sb.append(" and s_state = ? ");
				}
			if(null!=po.getS_tel()) {
				params.add(po.getS_tel());
				sb.append(" and s_tel= ? ");
				}
			}
		sb.append(" order by s_state asc, s_id asc ");
		if(null!=pageNum &&  null!=pageSize) {
			sb.append(" limit "+(pageNum-1)*pageSize+","+pageSize);
		}
		System.out.println(sb.toString());
		return db.findMutil(sb.toString(), params,SellerPO.class);
		
	}

	@Override
	public int totalPage(SellerPO po) throws Exception {
		StringBuffer sb=new StringBuffer();
		sb.append("select count(*) from tb_seller where 1=1");
		List<Object> params=null;
		if(null!=po) {
			params=new ArrayList<Object>();
			if(null!=po.getS_state()) {
				params.add(po.getS_state());
					sb.append(" and s_state = ? ");
				}
				if(null!=po.getS_tel()) {
					params.add(po.getS_tel());
					sb.append(" and s_tel= ? ");
				}
			}
		return (int) db.getPromer(sb.toString(), params);
	}

	@Override
	public int regSeller(SellerPO po) throws Exception {
		String sql="insert into tb_seller values(null,?,?,?,?,?,?,1)";
		return db.upDate(sql, po.getS_name(),po.getS_pwd(),po.getS_tel(),
				po.getS_licence(),po.getS_addr(),po.getS_Pic());
	}

	@Override
	public int updatePwd(SellerPO po) throws Exception {
		String sql="update tb_seller set s_pwd=? where s_id=?";
		return db.upDate(sql,po.getS_pwd(), po.getS_id());
	}

	@Override
	public List<SellerPO> findByTrem(SellerPO po) throws Exception {
		StringBuffer sb=new StringBuffer();
		sb.append("select*from tb_seller where 1=1");
		List<Object> params=null;
		if(null!=po) {
			params=new ArrayList<Object>();
			if(null!=po.getS_name()) {
				sb.append(" and s_name=? ");
				params.add(po.getS_name());
			}
		}
		//System.out.println(sb.toString());
		return db.findMutil(sb.toString(), params, SellerPO.class);
	}

}

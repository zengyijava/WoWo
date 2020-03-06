package com.yc.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.yc.commons.DbHelper;
import com.yc.dao.IAdminDAO;
import com.yc.po.AdminPO;

public class AdminDAOImpl implements IAdminDAO {
	DbHelper db = new DbHelper();

	@Override
	public AdminPO login(AdminPO po) throws Exception {
		String sql = "select a_id,a_name,a_pwd,a_mark,a_state from tb_admin where"
				+ " a_name=? and a_pwd=? and a_state=1";
		List<Object> params = new ArrayList<Object>();
		params.add(po.getA_name());
		params.add(po.getA_pwd());
		List<AdminPO> list = db.findMutil(sql, params, AdminPO.class);
		if (null != list && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

	@Override
	public int updateState(AdminPO po) throws Exception {
		String sql = "update tb_admin set a_state=? where a_id=?";
		return db.upDate(sql, po.getA_state(), po.getA_id());
	}

	@Override
	public List<AdminPO> find(AdminPO po) throws Exception {
		StringBuffer sb = new StringBuffer();
		sb.append("select *from tb_admin where 1=1");
		List<Object> params = null;
		if (null != po) {
			params = new ArrayList<Object>();
			if (null != po.getA_state()) {
				sb.append(" and a_state=? ");
			}
		}
		sb.append(" order by a_state asc");
		return db.findMutil(sb.toString(), params, AdminPO.class);
	}

	@Override
	public List<AdminPO> findByPage(AdminPO po, Integer pageNum, Integer pageSize) throws Exception {
		//System.err.println(po.getA_state());
		//System.out.println(po.getA_state().getClass().getTypeName());
		StringBuffer sb = new StringBuffer();
		sb.append("select *from tb_admin where 1=1");
		List<Object> params = null;
		if (null != po) {
			params = new ArrayList<Object>();
			if (null != po.getA_state()) {
				params.add(po.getA_state());
				sb.append(" and a_state=? ");
			}
		}
		sb.append(" limit " + (pageNum - 1) * pageSize + "," + pageSize);
		//System.err.println(sb);
		return db.findMutil(sb.toString(), params, AdminPO.class);
	}

	
	
	@Override
	public int totalPage(AdminPO po) throws Exception {
		StringBuffer sb = new StringBuffer();
		sb.append("select count(*) from tb_admin where 1=1");
		List<Object> params = null;
		if (null != po) {
			params = new ArrayList<Object>();
			if (null != po.getA_state()) {
				params.add(po.getA_state());
				sb.append(" and a_state=? ");
			}
		}
		//System.out.println(sb.toString());
		return (int) db.getPromer(sb.toString(), params);
	}

}

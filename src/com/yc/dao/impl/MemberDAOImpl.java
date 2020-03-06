package com.yc.dao.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.yc.commons.DbHelper;
import com.yc.dao.IMemberDAO;
import com.yc.po.MemberPO;

public class MemberDAOImpl  implements  IMemberDAO{
DbHelper db = new DbHelper();
	@Override
	public int regMember(MemberPO po) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public MemberPO login(MemberPO po) throws Exception {
		StringBuffer sb = new StringBuffer();
		sb.append("select m_id,m_name,m_pwd,m_tel,m_sex,m_email,m_date,m_score,"
				+ "m_rank,m_money,m_pic  from tb_member where 1=1 ");
		List<Object> params =new ArrayList<Object>();
		if(po.getM_name()!=null){
			sb.append(" and m_name =?  ");
			params.add(po.getM_name());
		}else if(null!=po.getM_email()){
			sb.append(" and m_email =? ");
			params.add(po.getM_email());
		}else if(null!=po.getM_tel()){
			sb.append(" and m_tel =? ");
			params.add(po.getM_tel());
		}
		sb.append(" and m_pwd =? ");
		params.add(po.getM_pwd());
		//System.out.println(sb.toString());
		List<MemberPO> list =db.findMutil(sb.toString(), params, MemberPO.class);
		if(null==list || list.isEmpty()){
			return null;
		}else{
			return list.get(0);
		}
	}
}

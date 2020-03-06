package com.yc.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.yc.commons.DbHelper;
import com.yc.dao.IGoodTypeDAO;
import com.yc.po.GoodTypePO;
import com.yc.po.SellerPO;

public class GoodTypeDAOImpl implements IGoodTypeDAO{
	DbHelper db=new DbHelper();
	@Override
	public List<GoodTypePO> find(GoodTypePO po) throws Exception {
		StringBuffer sb=new StringBuffer();
		sb.append("select t_id,t_name,t_disc,t_parent from tb_goodtype where 1=1");
		List<Object> params=null;
		if(null!=po) {
			params=new ArrayList<Object>();
			if(null!=po.getT_id()) {
				params.add(po.getT_id());
				sb.append(" and t_id = ? ");
				}
			if(null!=po.getT_name()) {
				params.add(po.getT_name());
				sb.append(" and t_name= ? ");
				}
			if(null!=po.getT_parent()) {
				params.add(po.getT_parent());
				sb.append(" and t_parent= ? ");
				}
		}
		sb.append(" order by t_parent asc,t_id asc");
		//System.out.println(sb.toString());
		return db.findMutil(sb.toString(), params,GoodTypePO.class);
		
	}

	@Override
	public int addGoodType(GoodTypePO po) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

}

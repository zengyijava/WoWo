package com.yc.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.yc.commons.DbHelper;
import com.yc.dao.IGoodDAO;
import com.yc.po.GoodPO;
import com.yc.po.GoodTypePO;
import com.yc.util.StringUtil;
import com.yc.vo.GoodVO;

public class GoodDAOImpl implements IGoodDAO{
	DbHelper db=new DbHelper();
	
	@Override
	public int addGood(GoodPO po) throws Exception {
		String sql="insert into tb_good values(null,?,?,?,?,?,?)";
		return db.upDate(sql, po.getS_id(),po.getT_id(),
				po.getG_name(),po.getG_mark(),
				po.getG_price(),po.getG_temp1());
	}

	@Override
	public List<GoodVO> findByPage(GoodVO vo, Integer pageNum, Integer pageSize) throws Exception {
		StringBuffer sb=new StringBuffer();
		sb.append("select g_id,g_name,s_id,g_mark,g_price,g_temp1,t.t_id,t_name,t_disc,t_parent from "
				+ "tb_good g inner join tb_goodtype t on g.t_id=t.t_id where 1=1");
		List<Object> params=null;
		if(null!=vo) {
			params=new ArrayList<Object>();
			if(null!=vo.getG_id()) {
				params.add(vo.getG_id());
				sb.append(" and g_id = ? ");
				}
			if(null!=vo.getG_name()) {
				params.add(vo.getG_name());
				sb.append(" and g_name= ? ");
				}
			if(null!=vo.getS_id()) {
				params.add(vo.getS_id());
				sb.append(" and s_id= ? ");
				}
			if(null!=vo.getT_id()) {
				params.add(vo.getT_id());
				sb.append(" and g.t_id= ? ");
				}
			if(null!=vo.getT_parent()) {
				params.add(vo.getT_parent());
				sb.append(" and t_parent= ? ");
				}
			if(null!=vo.getT_name()) {
				params.add(vo.getT_name());
				sb.append(" and t_name= ? ");
				}
		}
		sb.append(" order by s_id asc");
		if(null!=pageSize && null!=pageNum) {
			sb.append(" limit "+(pageNum-1)*pageSize+","+pageSize);
		}
		return db.findMutil(sb.toString(), params,GoodVO.class);
		
	}

	@Override
	public int totalPage(GoodVO vo) throws Exception {
		StringBuffer sb=new StringBuffer();
		sb.append("select count(*) from "
				+ "tb_good g inner join tb_goodtype t on g.t_id=t.t_id where 1=1");
		List<Object> params=null;
		if(null!=vo) {
			params=new ArrayList<Object>();
			if(null!=vo.getG_id()) {
				params.add(vo.getG_id());
				sb.append(" and g_id = ? ");
				}
			if(null!=vo.getG_name()) {
				params.add(vo.getG_name());
				sb.append(" and g_name= ? ");
				}
			if(null!=vo.getS_id()) {
				params.add(vo.getS_id());
				sb.append(" and s_id= ? ");
				}
			if(null!=vo.getT_id()) {
				params.add(vo.getT_id());
				sb.append(" and t_id= ? ");
				}
			if(null!=vo.getT_parent()) {
				params.add(vo.getT_parent());
				sb.append(" and t_parent= ? ");
				}
			if(null!=vo.getT_name()) {
				params.add(vo.getT_name());
				sb.append(" and t_name= ? ");
				}
		}
		return (int) db.getPromer(sb.toString(), params);
	}

	@Override
	public List<GoodVO> findByType(GoodVO vo) throws Exception {
		StringBuffer sb=new StringBuffer();
		sb.append("select g.t_id,t_name from tb_good g inner join tb_goodtype t on g.t_id =t.t_id where 1=1 ");
		List<Object> params=null;
		if(null!=vo) {
			params=new ArrayList<Object>();
			if(null!=vo.getS_id()) {
				params.add(vo.getS_id());
				sb.append(" and s_id = ? ");
				}
		}
		System.out.println(sb.toString());
		return db.findMutil(sb.toString(), params, GoodVO.class);
	}

	@Override
	public List<GoodVO> findByIds(GoodVO vo,String ids) throws Exception {
		if(StringUtil.isEmpty(ids)){
			return null;
		}
		String [] gids=ids.split(",");
		StringBuffer sb = new StringBuffer();
		sb.append("select g_id,g_name,s_id,g_mark,g_price,g_temp1,t.t_id,t_name,t_disc,t_parent from "
				+ " tb_good g inner join tb_goodtype t on g.t_id =t.t_id where 1= 1 ");
		List<Object> params=new ArrayList<Object>();
		sb.append(" and g_id in (");
		for(int i =0;i<gids.length;i++){
			sb.append("?");
			params.add(gids[i]);
			if(i!=gids.length-1){
				sb.append(",");
			}
		}
		sb.append(")");
		 if(null!=vo &&null!=vo.getT_parent()){
			 params.add(vo.getT_parent());
			 sb.append(" and t_parent =? ");
		 }
		 sb.append(" order by t_id desc ");
		 System.out.println(sb.toString());
		return db.findMutil(sb.toString(), params, GoodVO.class);
	}

}

package com.yc.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.yc.commons.DbHelper;
import com.yc.dao.IOrderDAO;
import com.yc.po.OrderPO;
import com.yc.util.StringUtil;
import com.yc.vo.OrderVO;

public class OrderDAOImpl implements IOrderDAO{
	DbHelper db = new DbHelper();

	@Override
	public int UpdateOrderList(String []oids) throws Exception {
		String sql ="update tb_order set o_state =2,o_date =now() where o_id =? "; 
		List<String> sqls = new ArrayList<String>();
		List<List<Object>> params = new ArrayList<List<Object>>();
		List<Object> param =null;
		 for(String oid:oids){
			 param =new ArrayList<Object>();
			 param.add(oid);
			 params.add(param);
			 sqls.add(sql);
		 }
		 return db.upDate(sqls, params);
	}

	@Override
	public List<OrderVO> findByPage(OrderVO vo, Integer pageNum, Integer pageSize) throws Exception {
		 StringBuffer sb = new StringBuffer();
		 sb.append("select o.*,g.* from tb_order o inner join tb_groupbuy g on o.sm_id =g.gb_id where 1=1 ") ;
		 List<Object> params =null;
		 if(null!=vo){
			 params = new ArrayList<Object>();
			 if(null!=vo.getO_id()){
				 sb.append(" and o_id =? ");
				 params.add(vo.getO_id());
			 }
			 if(null!=vo.getM_id()){
				 sb.append(" and m_id =? ");
				 params.add(vo.getM_id());
			 }
			 if(null!=vo.getS_id()){
				 sb.append(" and s_id =? ");
				 params.add(vo.getS_id());
			 }
			 if(null!=vo.getGb_id()){
				 sb.append(" and gb_id =? ");
				 params.add(vo.getGb_id());
			 }
			 if(null!=vo.getO_state()){
				 sb.append(" and o_state =? ");
				 params.add(vo.getO_state());
			 }
			 if(null!=vo.getSm_id()){
				 sb.append(" and sm_id =? ");
				 params.add(vo.getSm_id());
			 }
			 
		 }
		 if(null!=pageSize && null!=pageNum){
				sb.append(" limit "+(pageNum-1)*pageSize+","+pageSize);
		 }
		 sb.append("order by o_state desc,o_date desc ");
		 System.out.println(sb.toString());
		return db.findMutil(sb.toString(), params, OrderVO.class);
	}

	@Override
	public List<OrderVO> totalPage(OrderVO vo) throws Exception {
		 
		return null;
	}

	@Override
	public int addOrder(OrderPO po) throws Exception {
		String sql ="insert into tb_order values(?,?,?,?,?,now(),1,?)"; 
		String oid =StringUtil.genOrderId(po.getSm_id());
		return db.upDate(sql, oid,po.getM_id(),po.getSm_id(),po.getO_num(),
				po.getO_price(),po.getO_dis());
	}

	@Override
	public int updateNum(OrderVO vo) throws Exception {
		String sql ="update tb_order set o_num=o_num+1 ,o_price =?  where sm_id =? ";
		double price = vo.getO_num()*vo.getGb_price();
		return db.upDate(sql, price,vo.getSm_id());
	}

	 

}

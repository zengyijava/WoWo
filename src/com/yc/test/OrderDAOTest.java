package com.yc.test;

import java.util.List;

import org.junit.Test;

import com.yc.dao.IOrderDAO;
import com.yc.dao.impl.OrderDAOImpl;
import com.yc.po.OrderPO;
import com.yc.vo.OrderVO;

public class OrderDAOTest {
	IOrderDAO dao = new OrderDAOImpl();

	@Test
	public void testAdd()throws Exception{
		OrderPO po = new OrderPO();
		po.setM_id(2);
		po.setSm_id(2);
		po.setO_num(2);
		po.setO_price(89.0);
		dao.addOrder(po);
	}
	
	@Test
	public void testFindPage()throws Exception{
		OrderVO vo =new OrderVO();
		vo.setSm_id(1);
		 List<OrderVO> list  =dao.findByPage(vo, null, null);
		 for(OrderVO v:list){
			 System.out.println(v.getO_date());
		 }
	}
	
}

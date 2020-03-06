package com.yc.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yc.dao.IOrderDAO;
import com.yc.dao.impl.OrderDAOImpl;
import com.yc.po.MemberPO;
import com.yc.po.OrderPO;
import com.yc.vo.OrderVO;

@WebServlet("/order.action")
public class OrderServlet extends BaseServlet{

	IOrderDAO dao = new OrderDAOImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String op =request.getParameter("op");
		if("add".equals(op)){
			doAdd(request, response);
		}else if("find".equals(op)){
			doFind(request, response);
		}
	}

	private void doFind(HttpServletRequest req, HttpServletResponse resp) {
		MemberPO memberPO = (MemberPO)req.getSession().getAttribute("member");
		try {
			if(null==memberPO){
				toPrintString(2,resp);
				return ;
			}
			OrderVO vo = new OrderVO();
			vo.setM_id(memberPO.getM_id());
			vo.setO_state(1);
			List<OrderVO> list =dao.findByPage(vo, null, null);
			toPrintString(list,resp);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

	private void doAdd(HttpServletRequest req, HttpServletResponse resp) {
		OrderVO vo =parserRequestToObject(req, OrderVO.class);
		//System.out.println(vo);
		MemberPO memberPO = (MemberPO)req.getSession().getAttribute("member");
		try {
			if(null==memberPO){
				toPrintString(2,resp);
				return ;
			}
			vo.setM_id(memberPO.getM_id());
			//根据传入的套餐编号查询订单表中是否有改数据 有则修改  
			vo.setO_state(1);
			List<OrderVO> list =dao.findByPage(vo, null, null);
			int i =0;
			if(null==list || list.isEmpty()){
				OrderPO po =new OrderPO();
				po.setM_id(memberPO.getM_id());
				po.setO_num(1);
				po.setSm_id(vo.getSm_id());
				po.setO_price(vo.getO_price());
				 i =dao.addOrder(po);
			}else{
				 vo.setGb_price(list.get(0).getGb_price());
				 vo.setO_num(list.get(0).getO_num()+1);
				//修改数量 
				  i=dao.updateNum(vo);
			}
			toPrintString(i,resp);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}

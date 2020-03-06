package com.yc.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yc.dao.IGoodDAO;
import com.yc.dao.IGroupBuyDAO;
import com.yc.dao.impl.GoodDAOImpl;
import com.yc.dao.impl.GroupBuyDAOImpl;
import com.yc.po.GroupBuyPO;
import com.yc.po.SellerPO;
import com.yc.util.StringUtil;
import com.yc.vo.GoodVO;

@WebServlet("/groupBuy.action")
public class GroupBuyServlet  extends BaseServlet{
	
	IGroupBuyDAO dao =new GroupBuyDAOImpl();
	IGoodDAO  goodDAO = new GoodDAOImpl();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String op =request.getParameter("op");
		if("find".equals(op)){
			doFind(request, response);
		}else if("findDetail".equals(op)){
			doFindDetail(request, response);
		}
	}
	
	private  void doFindDetail(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		GroupBuyPO po =parserRequestToObject(req, GroupBuyPO.class);
		try {
			List<GroupBuyPO> list =dao.findBypage(po, null, null);
			if(null!=list && !list.isEmpty()){
				String gids= list.get(0).getG_id();
				List<GoodVO> goods =goodDAO.findByIds(null, gids);
				toPrintString(goods, resp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private  void doFind(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		 GroupBuyPO po =parserRequestToObject(req, GroupBuyPO.class);
		 String page=req.getParameter("page");
		 String rows =req.getParameter("rows");
		 //如果是商家  
		 SellerPO sellerPO =(SellerPO)req.getSession().getAttribute("seller");
		 if(null!=sellerPO){
			 po.setS_id(sellerPO.getS_id());
		 }
		 List<GroupBuyPO> list =null;
		  try {
			if(!StringUtil.isEmpty(page)&&!StringUtil.isEmpty(rows)){
				 list = dao.findBypage(po, Integer.parseInt(page), Integer.parseInt(rows)); 
				 toPrintString(list, resp,dao.totalPage(po));
			}else{
				 list=dao.findBypage(po, null, null);
				 toPrintString(list, resp);
			  }
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

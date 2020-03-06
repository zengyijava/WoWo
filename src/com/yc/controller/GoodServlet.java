package com.yc.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yc.dao.IGoodDAO;
import com.yc.dao.impl.GoodDAOImpl;
import com.yc.po.EasyUITreeNode;
import com.yc.po.SellerPO;
import com.yc.util.EasyuiUtil;
import com.yc.vo.GoodVO;
@WebServlet("/good.action")
public class GoodServlet extends BaseServlet{
	IGoodDAO dao=new GoodDAOImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String op=req.getParameter("op");
		if("find".equals(op)) {
			doFind(req,resp);
		}else if("findtype".equals(op)) {
			doFindType(req,resp);
		}
	}

	private void doFindType(HttpServletRequest req, HttpServletResponse resp) {
		GoodVO vo=parserRequestToObject(req, GoodVO.class);
		
		SellerPO sellerPO=(SellerPO)req.getSession().getAttribute("seller");
		if(null!=sellerPO) {
			vo.setS_id(sellerPO.getS_id());
		}
		try {
			//查询商家所拥有的商品类型
			List<GoodVO>list=dao.findByType(vo);
			//System.out.println(list);
			//商品类型转为easyuinode list
			List<EasyUITreeNode> nodes=EasyuiUtil.asTreeNodeList(list, "t_id","t_name","p_attr");
			//循环类型
			for(int i=0;i<list.size();i++) {
				GoodVO g=new GoodVO();
				g.setS_id(list.get(i).getS_id());
				g.setT_id(list.get(i).getT_id());
				//根据商品类型编号和商检编号查看商品信息
				
				
				List<GoodVO> children=dao.findByPage(g, null, null);
				//商品集合设置为类型的子节点
				nodes.get(i).setChildren(EasyuiUtil.asTreeNodeList(children, "g_id","g_name","c_attr"));
						
			}
			toPrintString(nodes, resp);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void doFind(HttpServletRequest req, HttpServletResponse resp) {
		GoodVO vo=parserRequestToObject(req, GoodVO.class);
		String page=req.getParameter("page");
		String rows=req.getParameter("rows");
		SellerPO sellerPO=(SellerPO)req.getSession().getAttribute("seller");
		if(null!=sellerPO) {
			vo.setS_id(sellerPO.getS_id());
		}
		List<GoodVO>list=null;
		
			try {
				if(null!=page && null!=rows && !"".equals(page) && !"".equals(rows)) {
				list=dao.findByPage(vo, Integer.parseInt(page), Integer.parseInt(rows));
				toPrintString(list, resp,dao.totalPage(vo));
				}else {
					list=dao.findByPage(vo, null, null);
					toPrintString(list, resp);
				}
			} catch (NumberFormatException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
		
	

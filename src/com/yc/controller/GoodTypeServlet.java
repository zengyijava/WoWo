package com.yc.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yc.dao.IGoodTypeDAO;
import com.yc.dao.impl.GoodTypeDAOImpl;
import com.yc.po.GoodTypePO;
@WebServlet("/goodType.action")
public class GoodTypeServlet extends BaseServlet{
	IGoodTypeDAO dao=new GoodTypeDAOImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String op=req.getParameter("op");
		if("find".equals(op)) {
			doFind(req,resp);
		}
	}

	private void doFind(HttpServletRequest req, HttpServletResponse resp)  {
		GoodTypePO po=parserRequestToObject(req, GoodTypePO.class);		
		try {
			List<GoodTypePO> list = dao.find(po);
			toPrintString(list, resp);
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
	

}

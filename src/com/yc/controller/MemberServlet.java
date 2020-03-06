package com.yc.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yc.dao.IMemberDAO;
import com.yc.dao.impl.MemberDAOImpl;
import com.yc.po.MemberPO;
@WebServlet("/member.action")
public class MemberServlet extends BaseServlet {

	IMemberDAO dao = new MemberDAOImpl();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String op =request.getParameter("op");
		if("login".equals(op)){
			doLogin(request, response);
		} 
	}

	private void doLogin(HttpServletRequest req, HttpServletResponse resp) {
		MemberPO po = parserRequestToObject(req, MemberPO.class);
		try {
			MemberPO member =dao.login(po);
			if(null==member){
				toPrintString(0, resp);
			}else{
				req.getSession().setAttribute("member", member);
				toPrintString(1,resp);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	
	 
}

package com.yc.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yc.dao.IAdminDAO;
import com.yc.dao.impl.AdminDAOImpl;
import com.yc.po.AdminPO;
import com.yc.util.LogUtil;
@WebServlet("/admin.action")
public class AdminServlet extends BaseServlet {
	IAdminDAO dao=new AdminDAOImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String op=req.getParameter("op");
		if("adminLogin".equals(op)) {
			doAdminLogin(req,resp);
		}else if("find".equals(op)) {
			doFind(req,resp);
		}else if("update".equals(op)) {
			doUpdate(req,resp);
		}
	}

	private void doFind(HttpServletRequest req, HttpServletResponse resp) {
		
			try {
				AdminPO po=parserRequestToObject(req, AdminPO.class);
				String pageNum=req.getParameter("page"); //2
				String pageSize=req.getParameter("rows"); //6
				List<AdminPO>list=null;
				if(null==pageNum  || "".equals(pageNum)) {
					//未分页的查询
				list=dao.find(po);
				toPrintString(list, resp);
				}else {
					//分页查询
					//System.out.println(Integer.parseInt(pageNum)+"===="+Integer.parseInt(pageSize));
					list=dao.findByPage(po, Integer.parseInt(pageNum), Integer.parseInt(pageSize));
					int total=dao.totalPage(po);
					toPrintString(list, resp,total);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	

	
	private void doUpdate(HttpServletRequest req, HttpServletResponse resp) {
		AdminPO po=parserRequestToObject(req, AdminPO.class);
		try {
			List<AdminPO> list=dao.find(po);
			int state=list.get(0).getA_state();//获取当前管理员状态   
			if(state==1) {
				po.setA_state(2);
			}else {
				po.setA_state(1);
			}
			int i=dao.updateState(po);
			toPrintString(i, resp);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
	
		  

	private void doAdminLogin(HttpServletRequest req, HttpServletResponse resp) {
		AdminPO po=parserRequestToObject(req, AdminPO.class);
		
		try {
			AdminPO admin= dao.login(po);
			if(null==admin) {
				resp.sendRedirect("back/adminLogin.html");
				//resp.sendRedirect("back/manage/index.jsp");
			}else {
				req.getSession().setAttribute("admin", admin);
				resp.sendRedirect("back/manage/index.jsp");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}

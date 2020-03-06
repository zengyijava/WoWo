package com.yc.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.yc.dao.ISellerDAO;
import com.yc.dao.impl.SellerDAOImpl;
import com.yc.po.SellerPO;
@WebServlet("/seller.action")
public class SellerServlet extends BaseServlet{
	ISellerDAO dao=new SellerDAOImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String op=req.getParameter("op");
		if("login".equals(op)) {
			doLogin(req,resp);
		}else if("register".equals(op)) {
			doRegister(req,resp);
		}
	}

	private void doRegister(HttpServletRequest req, HttpServletResponse resp) {		
		SellerPO po=parserRequestToObject(req,SellerPO.class);
		try {
			int reg=dao.regSeller(po);
			if(reg>0) {
				resp.sendRedirect("back/register.html");
			}else {
				resp.sendRedirect("back/login.html");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	
	
	private void doLogin(HttpServletRequest req, HttpServletResponse resp) {
		SellerPO po=parserRequestToObject(req,SellerPO.class);
		try {
			SellerPO seller=dao.login(po);
			//System.out.println("************************8"+seller);
			if(null==seller) {
				toPrintString(0, resp);
			}else {
				req.getSession().setAttribute("seller", seller);
				toPrintString(1, resp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	
	

}

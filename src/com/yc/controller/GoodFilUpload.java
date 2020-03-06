package com.yc.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.yc.dao.IGoodDAO;
import com.yc.dao.impl.GoodDAOImpl;
import com.yc.po.GoodPO;
import com.yc.po.SellerPO;
@WebServlet("/goodFileUpload.action")
public class GoodFilUpload extends BaseServlet {
	IGoodDAO dao = new GoodDAOImpl();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 创建磁盘文件项目工厂
		DiskFileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);
		String g_name = null;
		String t_id = null;
		String g_disc = null;
		String g_price = null;
		String g_mark = null;
		String image_path = null;
		SellerPO po = (SellerPO) req.getSession().getAttribute("seller");
		try {
			List<FileItem> list = upload.parseRequest(req);
			if (null != list) {
				for (FileItem item : list) {
					// item.isFormField() //判断是否为普通的元素
					if (item.isFormField()) {
						if ("g_name".equals(item.getFieldName())) {
							g_name = item.getString("utf-8");
						} else if ("t_id".equals(item.getFieldName())) {
							t_id = item.getString("utf-8");
						} else if ("g_disc".equals(item.getFieldName())) {
							g_disc = item.getString("utf-8");
						} else if ("g_price".equals(item.getFieldName())) {
							g_price = item.getString("utf-8");
						} else if ("g_mark".equals(item.getFieldName())) {
							g_mark = item.getString("utf-8");
						}
					} else {
						// 是一个文件
						String path = req.getServletContext().getRealPath("/");
						String fileName =po.getS_id()+"" + System.currentTimeMillis() + item.getName();
						File file = new File(path, "../wowo_image/" + fileName);
						item.write(file);
						image_path = "../wowo_image/" + file.getName();
					}
				}
			}
			GoodPO goodPO=new GoodPO();
			goodPO.setG_mark(g_mark);
			goodPO.setG_name(g_name);
			goodPO.setG_price(Double.parseDouble(g_price));
			goodPO.setG_temp1(image_path);
			goodPO.setS_id(po.getS_id());
			goodPO.setT_id(Integer.parseInt(t_id));
			int i=dao.addGood(goodPO);
			toPrintString(i, resp);
			
		} catch (FileUploadException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

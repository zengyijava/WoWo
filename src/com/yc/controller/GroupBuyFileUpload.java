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

import com.yc.dao.IGroupBuyDAO;
import com.yc.dao.impl.GroupBuyDAOImpl;
import com.yc.po.GroupBuyPO;
import com.yc.po.SellerPO;
@WebServlet("/groupbuyFileUpload.action")
public class GroupBuyFileUpload extends BaseServlet {
	IGroupBuyDAO dao = new GroupBuyDAOImpl();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		DiskFileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);
		String g_id = null;
		String gd_name = null;
		String gb_price = null;
		String gd_start = null;
		String gd_end = null;
		String gd_prompt = null;
		String gd_hottip = null;
		String image_path = null;
		String gd_type = null;
		String gd_typedesc = null;
		String gd_tishi = null;

		SellerPO seller = (SellerPO) req.getSession().getAttribute("seller");
		try {
			List<FileItem> list = upload.parseRequest(req);
			if (null != list) {
				for (FileItem item : list) {
					if (item.isFormField()) {
						//普通的表达元素
						if ("g_id".equals(item.getFieldName())) {
							g_id = item.getString("utf-8");
						}
						if ("gd_name".equals(item.getFieldName())) {
							gd_name = item.getString("utf-8");
						}
						if ("gb_price".equals(item.getFieldName())) {
							gb_price = item.getString("utf-8");
						}
						if ("gd_start".equals(item.getFieldName())) {
							gd_start = item.getString("utf-8");
						}
						if ("gd_end".equals(item.getFieldName())) {
							gd_end = item.getString("utf-8");
						}
						if ("gd_prompt".equals(item.getFieldName())) {
							gd_prompt = item.getString("utf-8");
						}
						if ("gd_hottip".equals(item.getFieldName())) {
							gd_hottip = item.getString("utf-8");
						}
						if ("gd_type".equals(item.getFieldName())) {
							gd_type = item.getString("utf-8");
						}
						if ("gd_typedesc".equals(item.getFieldName())) {
							gd_typedesc = item.getString("utf-8");
						}
						if ("gd_tishi".equals(item.getFieldName())) {
							gd_tishi = item.getString("utf-8");
						}
					} else {
						// 是一个文件
						String path = req.getServletContext().getRealPath("/");
						String fileName = seller.getS_id() + "" + System.currentTimeMillis() + item.getName();
						//System.out.println(fileName + "********************");

						File file = new File(path, "../wowo_image/" + fileName);
						item.write(file);
						image_path = "../wowo_image/" + file.getName();
					}
				}
			}

			GroupBuyPO po = new GroupBuyPO();
			po.setG_id(g_id);
			po.setGd_name(gd_name);
			po.setGb_price(Double.parseDouble(gb_price));
			po.setGd_start(gd_start);
			po.setGd_end(gd_end);
			po.setGd_prompt(gd_prompt);
			po.setGd_hottip(gd_hottip);
			
			po.setGd_desc(image_path);// 图片路径
			po.setGd_type(gd_typedesc);
			po.setGd_typedesc(gd_typedesc);
			po.setGd_tishi(gd_tishi);
			po.setS_id(seller.getS_id());
			int i = dao.addGroupBuy(po);
			toPrintString(i, resp);
		} catch (FileUploadException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}

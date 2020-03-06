<%@page import="com.yc.dao.impl.SellerDAOImpl"%>
<%@page import="com.yc.po.SellerPO"%>
<%@page import="com.yc.util.WebUtil"%>
<%@page import="java.util.Random"%>
<%@page import="java.io.File"%>
<%@page import="org.apache.commons.fileupload.FileItem"%>
<%@page import="org.apache.commons.fileupload.servlet.ServletFileUpload"%>
<%@page import="org.apache.commons.fileupload.disk.DiskFileItemFactory"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
//request.setCharacterEncoding("utf-8");
//response.setCharacterEncoding("utf-8");
//WebUtil.setCharacterEncoding(request, response, "utf-8");
//创建磁盘文件项目工厂
		DiskFileItemFactory factory=new DiskFileItemFactory();
		ServletFileUpload upload=new ServletFileUpload(factory);
		//解释请求对象
		List<FileItem> items=upload.parseRequest(request);
		if(null==items){
			return;
		}
		String sname=null;
		String spwd=null;
		String stel=null;
		String slicence=null;
		String saddr=null;
		String spic=null;
		//循环items，获取每个文件项对应的数据
		for(FileItem item:items){
			//item.isFormField() //判断是否为普通的元素
			if(item.isFormField()){
				if("s_name".equals(item.getFieldName())){
					sname=item.getString("utf-8");			
				}else if("s_pwd".equals(item.getFieldName())){
					spwd=item.getString("utf-8");
				}else if("s_tel".equals(item.getFieldName())){
					stel=item.getString("utf-8");
				}else if("s_licence".equals(item.getFieldName())){
					slicence=item.getString("utf-8");
				}else if("s_addr".equals(item.getFieldName())){
					saddr=item.getString("utf-8");
				}				
			}else{
				//是一个文件
				String path=pageContext.getServletContext().getRealPath("/");
				System.out.println(path);
				//path=path+"../images/";
				//解决文件重名问题
				String childPath="../images/"+System.currentTimeMillis()+""+new Random().nextInt(1000)+item.getName();
				
				
				
				//重启服务器图片丢失
				//新建项目，专门放在图片的 
				//File file=new File(path,"upload/"+item.getName());
				File file=new File(path,childPath);
				item.write(file);
				spic=childPath;
			}
		}
	//将数据存储对象中
	SellerPO user=new SellerPO();
	
	//注册
	SellerDAOImpl dao=new SellerDAOImpl();
//	int i=dao.register(user);
	



%>


<%@page import="java.util.List"%>
<%@page import="com.yc.dao.impl.SellerDAOImpl"%>
<%@page import="com.yc.po.SellerPO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%


String sname=request.getParameter("sname");
SellerPO po=new SellerPO();
SellerDAOImpl dao=new SellerDAOImpl();
po.setS_name(sname);
List<SellerPO> list=dao.findByTrem(po);
if(null==list || list.size()<=0){
	out.print("success");//用户名没有注册，用户名和数据库名字不一致
}else{
	out.print("error");
}


%>

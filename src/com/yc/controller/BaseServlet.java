package com.yc.controller;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.yc.util.LogUtil;

public class BaseServlet extends HttpServlet{


	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req,resp);
	}
	/*
	 * 将对象转为json字符串
	 */
	public  void toPrintString(Object obj, HttpServletResponse resp) throws  IOException {
		
		Gson gson=new Gson();
		String info=gson.toJson(obj);
		resp.getWriter().print(info);
	}
	
	public  void toPrintString(Integer i, HttpServletResponse resp) throws  IOException {
		Gson gson=new Gson();
		String info=gson.toJson(i);
		resp.getWriter().print(info);
	}
	
	public  void toPrintString(String str, HttpServletResponse resp) throws  IOException {
		Gson gson=new Gson();
		String info=gson.toJson(str);
		resp.getWriter().print(info);
	}
	
	/*
	 * easyui分页json格式数据
	 */
	public  void toPrintString(Object obj, HttpServletResponse resp,int total) throws  IOException {
		Gson gson=new Gson();
		String info=gson.toJson(obj);
		StringBuffer sb=new StringBuffer();
		sb.append("{");
		sb.append("\"total\":"+total+",\"rows\":");
		sb.append(info);
		sb.append("}");
		System.out.println(sb.toString());
		resp.getWriter().print(sb.toString());
	}
	
	
	
	
	
	/*
	 * 解释请求将数据封装装到javaBean 对象
	 */
	public <T> T parserRequestToObject(HttpServletRequest request,Class<T> cls) {
		T t=null;
		
		try {
			//获取所有属性
			Field[] fields=cls.getDeclaredFields();
			//获取所有的方法
			Method[] methods=cls.getDeclaredMethods();
			//根据cls创建对象
			t=cls.newInstance();
			String value=null;
			String fieldName=null;
			for(Field field:fields) {
				fieldName=field.getName();
				//根据属性取值 页面的name属性值必须和javaBean对象属性名一致
				value=request.getParameter(fieldName);
				//当页面没有传入值的时候
				if(null==value || "".equalsIgnoreCase(value)) {
					continue;
				}
				for(Method m:methods) {
					if(("set"+fieldName).equalsIgnoreCase(m.getName())){
						String paramType=m.getParameterTypes()[0].getName();
						System.out.println(paramType);
						if("java.lang.Integer".equals(paramType)) {
							m.invoke(t, Integer.parseInt(value));
						}else if("java.lang.Double".equals(paramType)) {
							m.invoke(t, Double.parseDouble(value));
						}else if("java.lang.Float".equals(paramType)) {
							m.invoke(t, Float.parseFloat(value));
						}else if("java.lang.String".equals(paramType)) {
							m.invoke(t,value);
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			LogUtil.log.debug(e.getMessage());		
		}
		return t;		
	}
	

}

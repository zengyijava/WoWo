<%@page import="com.yc.po.AdminPO"%>
<%@page import="com.yc.po.SellerPO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String path =pageContext.getServletContext().getContextPath();
 	path=path+"/";
	System.out.println(path);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<base href="<%=path%>">
<title>后台</title>
<link rel="stylesheet" type="text/css" href="back/easyui/css/easyui.css"/>
<link rel="stylesheet" type="text/css" href="back/easyui/css/icon.css"/>
<script type="text/javascript" src="back/easyui/js/jquery.min.js"></script>
<script type="text/javascript" src="back/easyui/js/jquery.easyui.min.js"></script>
<script type="text/javascript" src="back/easyui/js/easyui-lang-zh_CN.js"></script>
<style type="text/css">
ul{
list-style: none;
width: 150px;
margin: 0px;
}
li{
width:148px;
margin-bottom: 6px;
}

</style>
<%
	SellerPO  seller =(SellerPO)session.getAttribute("seller");
	AdminPO admin =(AdminPO)session.getAttribute("admin");
%>
</head>
<body class="easyui-layout">
    <div data-options="region:'north'" style="height:100px;"></div>
    <div data-options="region:'south',title:'South Title',split:true" style="height:100px;"></div>
    <div data-options="region:'east',title:'East',split:true" style="width:100px;"></div>
    <div data-options="region:'west',title:'导航菜单'" style="width:200px;">
    <div id="aa" class="easyui-accordion" data-options="fit:true" style="width:300px;height:200px;">
    	<%
    		if(null!=seller){
    	%>
    	<!-- 商家处理的超链接  -->
    	<div title="商品管理">
		 <ul>
			<li><a class="easyui-linkbutton btn" data-options="plain:true" href="back/manage/addgood.html">添加商品信息</a></li>
			<li><a class="easyui-linkbutton btn" data-options="plain:true" href="back/manage/showgood.html">浏览商品信息</a></li>
		</ul>
    	</div>
    	<div title="套餐管理"  style="padding:10px;">
		 <ul>
			<li><a class="easyui-linkbutton btn" data-options="plain:true" href="back/manage/addgroupbuy.html">添加套餐信息</a></li>
			<li><a class="easyui-linkbutton btn" data-options="plain:true" href="back/manage/findgroupbuy.html">浏览套餐信息</a></li>
		 </ul> 
    	 </div> 
    	 <div title="订单管理"  style="padding:10px;">
		 <ul>
			<li><a class="easyui-linkbutton btn" data-options="plain:true" href="back/manage/addgroupbuy.html">浏览订单信息</a></li>
			<li><a class="easyui-linkbutton btn" data-options="plain:true" href="back/manage/findgroupbuy.html">退款订单信息</a></li>
		 </ul> 
    	 </div> 
    	 <div title="商家中心"  style="padding:10px;">
		 <ul>
			<li><a class="easyui-linkbutton btn" data-options="plain:true" href="back/manage/addgroupbuy.html">个人信息</a></li>
		 </ul> 
    	 </div> 
    	<%		
    		}else if(null!=admin){
    	%>
    	
    	<!-- 管理员超链接  -->
    	<div title="类型管理" data-options="selected:true">
		 <ul>
			<li><a class="easyui-linkbutton btn" data-options="plain:true" href="back/manage/goodtype.html">商品类型信息</a></li>
		</ul>
    	</div>
    	<div title="商家管理"  style="padding:10px;">
		 <ul>
			<li><a class="easyui-linkbutton btn" data-options="plain:true" href="back/manage/findgroupbuy.html">浏览套餐信息</a></li>
		 	<li><a class="easyui-linkbutton btn" data-options="plain:true" href="back/manage/findgroupbuy.html">浏览商家信息</a></li>
		 </ul> 
    	 </div> 
    	  <div title="用户管理">
		<ul>
			<li><a class="easyui-linkbutton btn" data-options="plain:true" href="back/manage/showadmin.html">管理员管理</a></li>
			<li><a class="easyui-linkbutton btn" data-options="plain:true" href="">权限管理</a></li>
			<li><a class="easyui-linkbutton btn" data-options="plain:true" href="">商家管理</a></li>
		</ul> 
    </div>
    	<%
    		}
    	%>
    
    
    
    
    
    
     <div title="评论管理"  style="padding:10px;">
		 
     </div>
   
</div>  
    </div>
    <div data-options="region:'center'">
    	<div id="show_content" class="easyui-tabs" data-options="fit:true"></div>
    </div>
</body>
<script type="text/javascript">
$(function(){
	$('.btn').click(function(){
		var href=$(this).attr('href');
		var title=$(this).text();
		if(!$('#show_content').tabs('exists', title)){
			$('#show_content').tabs('add',{
			    title:title,
			    href:href,
			    closable:true
			});
		}else{
			$('#show_content').tabs('select',title);
		}
		return false;
	});
});
</script>
</html>
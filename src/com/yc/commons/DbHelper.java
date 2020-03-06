package com.yc.commons;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class DbHelper {
	private  Connection conn;
	private  PreparedStatement pstmt;
	private  ResultSet rs;
	static {
		try {
			Class.forName(MyProperties.getInstance().getProperty("driver"));
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 获取连接对象
	 * @throws SQLException 
	 */
	public  Connection getConn() throws SQLException {
		conn=DriverManager.getConnection(MyProperties.getInstance().getProperty("url"),MyProperties.getInstance());
		
		return conn;
	}
	
	//关闭所有资源
	public void closeAll(Connection conn,PreparedStatement pstmt,ResultSet rs) {
		if(null!=rs) {
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(null!=pstmt) {
			try {
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(null!=conn) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	/**
	 * 更新操作 批处理
	 * @throws SQLException 
	 */
	public int upDate(List<String> sqls,List<List<Object>> params) throws SQLException {
		int result = 0;
		try {
			conn = getConn();
			conn.setAutoCommit(false);
			if (null == sqls || sqls.size() <= 0) {
				return result;
			}
			// 循环sql语句
			for (int i = 0; i < sqls.size(); i++) {
				String sql = sqls.get(i);
				pstmt = conn.prepareStatement(sql);
				List<Object> param = (List<Object>) params.get(i);
				setparams(pstmt, param);
				result = pstmt.executeUpdate();

			}
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			// 回滚事物
			conn.rollback();
			return result;
		} finally {
			conn.setAutoCommit(true);
			closeAll(conn, pstmt, rs);
		}
		return result;
	}
	/**
	 * 更新操作
	 * @throws SQLException 
	 */
	public int upDate(String sql,Object...params) throws SQLException {
		int result = 0;
		try {
			conn = getConn();
			pstmt = conn.prepareStatement(sql);
			setParamterObject(pstmt, params);
			result = pstmt.executeUpdate();
		} finally {
			closeAll(conn, pstmt, rs);
		}
		return result;
	}

	private void setParamterObject(PreparedStatement pstmt2, Object[] params) throws SQLException {
		if (pstmt2 == null || params.length <= 0) {
			return;
		}
		for (int i = 0; i < params.length; i++) {
			pstmt.setObject(i + 1, params[i]);
		}

	}
	
	/**
	 * 查询 返回多条语句
	 * @throws SQLException 
	 * @throws IOException 
	 */
		public <E>List<E> findMutil(String sql,List<Object>params,Class<E> cls)throws Exception{
			List<E>list=new ArrayList<E>();
			conn=getConn();
			pstmt=conn.prepareStatement(sql);
			setparams(pstmt,params);
			rs=pstmt.executeQuery();
			List<String> columnNames=getCloumnNames(rs);
			E e;
			Object obj;
			Method []methods=cls.getDeclaredMethods();
			while(rs.next()) {
				e=cls.newInstance();
				for(String columnName:columnNames) {
					String typeName=null;
					obj=rs.getObject(columnName);
					if(null==obj) {
						continue;
					}
					typeName=obj.getClass().getName();
					//激活sexXXX 完成赋值操作
					for(Method m:methods) {
						if(("set"+columnName).equalsIgnoreCase(m.getName())) {
							//值的数据类型与固定类型字符串比较
							if("java.math.BigDecimal".equals(typeName)) {		        				m.invoke(e, rs.getInt(columnName));
							}else if("java.lang.Integer".equals(typeName)) {
								m.invoke(e, rs.getInt(columnName));//invoke(class,method)
							}else if("java.lang.Long".equals(typeName)) {
								m.invoke(e, rs.getLong(columnName));	
							}else if("java.lang.Double".equals(typeName)) {
								m.invoke(e, rs.getDouble(columnName));
							}else if("java.lang.Float".equals(typeName)) {
								m.invoke(e, rs.getFloat(columnName));
							}else if("java.lang.String".equals(typeName)) {
								m.invoke(e, rs.getString(columnName));
							}else if("oracle.sql.BLOB".equals(typeName)) {
//								BLOB blob=(BLOB) obj;
//								InputStream in=blob.getBinaryStream();
//								byte[] bt=new byte[(int) blob.length()];
//								in.read(bt);
//								m.invoke(e, bt);
						}else {
							m.invoke(e, obj.toString());
						}
							break;
					}
				}
			}
				list.add(e);
			}
			return list;
		}
		
		
		/*
		 * 聚合函数的查询 
		 * 
		 */
		public double getPromer(String sql,List<Object>params) throws SQLException {
			double result=0;
			try {
			conn=getConn();
			pstmt=conn.prepareStatement(sql);
			//setParamterObject(pstmt, params);
			setparams(pstmt,params);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				result=rs.getDouble(1);
			}
		}finally {
			closeAll(conn,pstmt,rs);
		}
		return result;
}

		
	
	
	
	
//	private void setParamterObject(PreparedStatement pstmt2, List<Object> params) {
//			// TODO Auto-generated method stub
//			
//		}

	public List<Map<String,Object>> selectMutil(String sql,List<Object> params) throws SQLException, IOException{
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		Map<String, Object> map = null;
		try {
			conn = getConn();
			pstmt = conn.prepareStatement(sql);
			setparams(pstmt, params);
			rs = pstmt.executeQuery();
			List<String> columnNames = getCloumnNames(rs);
			while (rs.next()) {
				map = new HashMap<String, Object>();
				for (String name : columnNames) {
					// 获取该列的值
					Object obj = rs.getObject(name);
					if (null == obj) {
						map.put(name, null);
						continue;
					}
					// 获取值类型
					String typeName = obj.getClass().getName();
					if ("oracle.sql.BLOB".equals(typeName)) {
//						// 将blob转为字节数组
//						BLOB blob = (BLOB) obj;
//						InputStream in = blob.getBinaryStream();
//						byte[] bt = new byte[(int) blob.length()];
//						in.read(bt);
//						map.put(name, obj);
					} else {
						// 循环结果集的所有列，逐一获取每列的值并保存到 map中，列名作为键
						map.put(name, obj);
					}
				}
				// map添加到list集合中
				list.add(map);
			}
		} finally {
			closeAll(conn, pstmt, rs);
		}
		return list;
	}
	
	/**
	 * 查询结果只返回一条结果
	 * @throws SQLException 
	 * @throws IOException 
	 */

	public Map<String,Object> selectSingle(String sql,List<Object> prams) throws SQLException, IOException{
		Map<String, Object> map = null;
		try {
			conn = getConn();
			pstmt = conn.prepareStatement(sql);
			// 设置参数
			setparams(pstmt, prams);
			rs = pstmt.executeQuery();
			List<String> columnNames = getCloumnNames(rs);

			if (rs.next()) {
				map = new HashMap<String, Object>();
				for (String name : columnNames) {
					// 获取该列的值
					Object obj = rs.getObject(name);
					if (null == obj) {
						map.put(name, null);
						continue;
					}
					// 获取值的类型
					String typeName = obj.getClass().getName();
					if ("oracle.sql.BLOB".equals(typeName)) {
						// 将blob转为字节数组
//						BLOB blob = (BLOB) obj;
//						InputStream in = blob.getBinaryStream();
//						byte[] bt = new byte[(int) blob.length()];
//						in.read(bt);
//						// 将字节数组存到map中
//						map.put(name, bt);
					} else {
						// 循环结果集的所有列，逐一获取每列的值并保存到map中，列名作为键
						map.put(name, obj);
					}
				}
			}
		} finally {
			closeAll(conn, pstmt, rs);
		}
		return map;
	}
	/**
	 * 获取列名
	 * @param rs
	 * @return
	 * @throws SQLException 
	 */
	private List<String> getCloumnNames(ResultSet rs) throws SQLException {
		ResultSetMetaData data =rs.getMetaData();//获取到表中的字段 等信息
		int count=data.getColumnCount();//获取到结果集几列数据
		List<String> columnNames=new ArrayList<String>();
		for(int i=1;i<=count;i++) {
			columnNames.add(data.getColumnName(i));//获取到第i列字段名并添加list集合
		}
		return columnNames;
	}

	/**
	 * 设置参数
	 * @param preparedStatement pstmt 预编译对象
	 * @param params  sql语句中的？ 的值  list集合值的顺序一定和？顺序一致
	 */
	private void setparams(PreparedStatement pstmt, List<Object> params) {
		if(null==params || params.size()<=0) {
			return;
		}
		for(int i=0;i<params.size();i++) {
			try {
				pstmt.setObject(i+1, params.get(i));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}

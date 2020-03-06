package com.yc.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StringUtil {

	public static boolean isEmpty(String str) {
		/*
		 * 判断是否为空
		 */
			if(null==str  || "".equals(str)) {
				return true;
			}
		return false;
	}
		/*
		 * 根据团购编号生成订单编号
		 */
		public static String genOrderId(int gbid) {
			Date date=new Date();
			DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			return "a"+format.format(date)+gbid;
		}

}

package com.yc.util;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WebUtil {
	public static void  setEncoding(HttpServletRequest req,
			HttpServletResponse resp,String charset) throws UnsupportedEncodingException {
		req.setCharacterEncoding(charset);
		resp.setCharacterEncoding(charset);
	}

}

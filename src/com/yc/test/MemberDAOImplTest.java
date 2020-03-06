package com.yc.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.yc.dao.IMemberDAO;
import com.yc.dao.impl.MemberDAOImpl;
import com.yc.po.MemberPO;

class MemberDAOImplTest {
	IMemberDAO dao=new MemberDAOImpl();
	@Test
	void testLogin() throws Exception {
		MemberPO po=new MemberPO();
		po.setM_name("zhangsan");		
		//po.setM_email("67898789@qq.com");
		//po.setM_tel("18978786767");
		
		po.setM_pwd("a");
		dao.login(po);
	}

}

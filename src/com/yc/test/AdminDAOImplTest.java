package com.yc.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.yc.dao.IAdminDAO;
import com.yc.dao.impl.AdminDAOImpl;
import com.yc.po.AdminPO;

class AdminDAOImplTest {
	IAdminDAO dao = new AdminDAOImpl();

	@Test
	void testLogin() throws Exception {
		AdminPO po = new AdminPO();
		po.setA_name("yc");
		po.setA_pwd("a");
		AdminPO admin = dao.login(po);
		System.out.println(admin.getA_mark());
	}

	@Test
	void testUpdateState() throws Exception {
		AdminPO po = new AdminPO();
		po.setA_state(1);
		po.setA_id(1);
		int i = dao.updateState(po);
		System.out.println(i);
	}

	@Test
	void testFind() throws Exception {
		AdminPO po = new AdminPO();
		List<AdminPO> list = dao.find(po);
		for (AdminPO p : list) {
			System.out.println(p.getA_name());
		}
	}

	@Test
	void testFindPage() throws Exception {
		AdminPO po = new AdminPO();
		po.setA_state(1);
		List<AdminPO> list = dao.findByPage(po, 2, 3);
		for (AdminPO p : list) {
			System.out.println(p.getA_name() + "\t" + p.getA_id());
		}

		//System.out.println(dao.totalPage(po));

	}

	@Test
	void testFindTotal() throws Exception {
		AdminPO po = new AdminPO();
		po.setA_state(1);
		System.out.println(dao.totalPage(po));

	}
}

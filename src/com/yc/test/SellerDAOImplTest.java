package com.yc.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.yc.dao.ISellerDAO;
import com.yc.dao.impl.SellerDAOImpl;
import com.yc.po.SellerPO;


class SellerDAOImplTest {
	ISellerDAO dao=new SellerDAOImpl();

	@Test
	void testLogin() throws Exception {
		SellerPO po=new SellerPO();
		po.setS_tel("15717347348");
		po.setS_pwd("a");
		dao.login(po);
		System.out.println(po.getS_tel());
	}
	
	@Test
	void testFindBypage() throws Exception {
		SellerPO po=new SellerPO();
		List<SellerPO> list=dao.findByPage(po, 1, 2);
		for(SellerPO p:list) {
		System.out.println(p.getS_name()+"\t"+p.getS_tel());
	}
}
		
	@Test
	void testTotalPage() throws Exception {
		SellerPO po=new SellerPO();
		po.setS_state(1);				
		System.out.println(dao.totalPage(po));
	}
	
	
		@Test
		void testRegSeller() throws Exception {
			SellerPO po=new SellerPO();
			po.setS_addr("长沙7天连锁");
			po.setS_name("天天酒店");
			po.setS_tel("1234567890");
			po.setS_pwd("a");
			dao.regSeller(po);
		}	
		
		
		@Test
		void testUpdatePwd() throws Exception {
			SellerPO po=new SellerPO();
			po.setS_id(1);
			po.setS_pwd("a");
			dao.updatePwd(po);
			System.out.println(po.getS_pwd());
		}

}

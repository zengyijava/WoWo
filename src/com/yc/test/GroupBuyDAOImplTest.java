package com.yc.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.yc.dao.IGroupBuyDAO;
import com.yc.dao.impl.GroupBuyDAOImpl;
import com.yc.po.GroupBuyPO;

class GroupBuyDAOImplTest {
	IGroupBuyDAO dao=new GroupBuyDAOImpl();

	@Test
	void testAdd() throws Exception {
		GroupBuyPO po=new GroupBuyPO();
		po.setG_id("1,2");
		po.setGd_name("湘菜双人套餐");
		po.setGb_price(88.0);
		po.setGd_typedesc("1-2人用餐");
		
		po.setS_id(1);
		po.setGd_type("2人套餐");		
		po.setGd_start("2018-01-01");
		po.setGd_end("2019-01-01");
		
		po.setGd_tishi("免费加饭");
		po.setGd_prompt("***");				
		
		dao.addGroupBuy(po);
	}
	
	@Test
	void testFindByPage() throws Exception {
		GroupBuyPO po=new GroupBuyPO();
		List<GroupBuyPO> list=dao.findBypage(po, 2, 3);
		System.out.println(list.size());
	
	}

}

package com.yc.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.yc.dao.IGoodTypeDAO;
import com.yc.dao.impl.GoodTypeDAOImpl;
import com.yc.po.GoodTypePO;

class GoodTypeDAOImplTest {
	IGoodTypeDAO dao=new GoodTypeDAOImpl();
	@Test
	void testFindGoodType() throws Exception {
		GoodTypePO po=new GoodTypePO();
		po.setT_parent(0);
		List<GoodTypePO> list=dao.find(po);
		for(GoodTypePO g:list) {
			System.out.print(g.getT_name()+",");
		}
	}

}

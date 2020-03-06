package com.yc.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.yc.dao.IGoodDAO;
import com.yc.dao.impl.GoodDAOImpl;
import com.yc.po.GoodPO;
import com.yc.vo.GoodVO;

class GoodDAOImplTest {
	IGoodDAO dao=new GoodDAOImpl();
	@Test
	void testAddGood() throws Exception {
		GoodPO po=new GoodPO();
		po.setS_id(2);
		po.setT_id(2);
		po.setG_name("旺旺饼干");
		po.setG_mark("美味");
		po.setG_price((double) 28);
		po.setG_temp1(null);
		dao.addGood(po);
		System.out.println(po.getG_name());
				
	}
	
	@Test
	void testFindByPage() throws Exception {
		GoodVO vo=new GoodVO();
		vo.setS_id(1);
		List<GoodVO> list02=dao.findByPage(vo, 1, 3);
		for(GoodVO v:list02) {
			System.out.println(v.getG_name());
		}
				
	}
	
	
	@Test
	void testFindByType() throws Exception {
		GoodVO vo=new GoodVO();
		vo.setS_id(2);
		List<GoodVO> list03=dao.findByType(vo);
		for(GoodVO g:list03) {
			System.out.println(g.getT_name());
		}
				
	}
	
	
	
	@Test
	void testFindByIds() throws Exception {
		GoodVO vo=new GoodVO();
		List<GoodVO> list=dao.findByIds(vo, "1");
		for(GoodVO i:list) {
			System.out.println(i.getG_name()+"\t"+i.getG_id()+"\t"+i.getT_name());
		}
				
	}

}


	

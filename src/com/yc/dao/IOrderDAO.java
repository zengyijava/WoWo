package com.yc.dao;

import java.util.List;

import com.yc.po.OrderPO;
import com.yc.vo.OrderVO;
/**
 * 订单 
 * @author Administrator
 *
 */
public interface  IOrderDAO {

	/**
	 * 下单
	 * @param oids
	 * @return
	 * @throws Exception
	 */
	public int UpdateOrderList(String []oids) throws Exception;
	
	/**
	 * 分页查询  
	 * @param vo
	 * @param pageNum
	 * @param pageSize
	 * @return
	 * @throws Exception
	 */
	public List<OrderVO> findByPage(OrderVO vo,Integer pageNum,Integer pageSize) throws Exception;

	/**
	 * 分页总数量
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	public List<OrderVO> totalPage(OrderVO vo)throws Exception;
	
	/**
	 * 添加订单
	 * @param po
	 * @return
	 * @throws Exception
	 */
	public int addOrder(OrderPO po) throws Exception;
	
	/**
	 * 修改数量
	 * @param po
	 * @return
	 * @throws Exception
	 */
	public int updateNum(OrderVO vo) throws Exception;
	
}

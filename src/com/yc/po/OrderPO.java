package com.yc.po;

import java.io.Serializable;
/**
 * 订单表
 * @author Lydia
 *
 */
public class OrderPO  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8018069070856578426L;
	private String o_id;
	private Integer m_id;//会员编号
	private Integer sm_id; //团购编号
	private Integer o_num; //数量
	private Double o_price; //价格
	private String o_date;  //下单时间
	private Integer o_state; //订单状态
	private String o_dis;   //消费密码   
	public String getO_id() {
		return o_id;
	}
	public void setO_id(String o_id) {
		this.o_id = o_id;
	}
	public Integer getM_id() {
		return m_id;
	}
	public void setM_id(Integer m_id) {
		this.m_id = m_id;
	}
	public Integer getSm_id() {
		return sm_id;
	}
	public void setSm_id(Integer sm_id) {
		this.sm_id = sm_id;
	}
	public Integer getO_num() {
		return o_num;
	}
	public void setO_num(Integer o_num) {
		this.o_num = o_num;
	}
	public Double getO_price() {
		return o_price;
	}
	public void setO_price(Double o_price) {
		this.o_price = o_price;
	}
	public String getO_date() {
		return o_date;
	}
	public void setO_date(String o_date) {
		this.o_date = o_date;
	}
	public Integer getO_state() {
		return o_state;
	}
	public void setO_state(Integer o_state) {
		this.o_state = o_state;
	}
	public String getO_dis() {
		return o_dis;
	}
	public void setO_dis(String o_dis) {
		this.o_dis = o_dis;
	}
	
	
	
	
}

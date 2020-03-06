package com.yc.po;

import java.io.Serializable;

public class GoodPO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer g_id;
	private Integer s_id;
	private Integer t_id;
	private String g_name;
	private String g_mark;
	private Double g_price;
	private String g_temp1;
	public Integer getG_id() {
		return g_id;
	}
	public void setG_id(Integer g_id) {
		this.g_id = g_id;
	}
	public Integer getS_id() {
		return s_id;
	}
	public void setS_id(Integer s_id) {
		this.s_id = s_id;
	}
	public Integer getT_id() {
		return t_id;
	}
	public void setT_id(Integer t_id) {
		this.t_id = t_id;
	}
	public String getG_name() {
		return g_name;
	}
	public void setG_name(String g_name) {
		this.g_name = g_name;
	}
	public String getG_mark() {
		return g_mark;
	}
	public void setG_mark(String g_mark) {
		this.g_mark = g_mark;
	}
	public Double getG_price() {
		return g_price;
	}
	public void setG_price(Double g_price) {
		this.g_price = g_price;
	}
	public String getG_temp1() {
		return g_temp1;
	}
	public void setG_temp1(String g_temp1) {
		this.g_temp1 = g_temp1;
	}
	

}

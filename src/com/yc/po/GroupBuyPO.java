package com.yc.po;

import java.io.Serializable;

public class GroupBuyPO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer gb_id;//团购编号
	private String g_id;//商品编号
	private String gd_name;//团购名称
	private Double gb_price;//团购价格
	private String gd_start;
	private String gd_end;
	private String gd_prompt;//温馨提示
	private String gd_hottip;//原价格
	private String gd_desc;//团购图片
	private Integer gd_click;//点击数量
	private Integer gd_num;//团购数量，多少人购买
	private String gd_type;//套餐类型
	private String gd_typedesc;//套餐描述
	private String gd_tishi;
	private Integer s_id;//商家编号
	public Integer getGb_id() {
		return gb_id;
	}
	public void setGb_id(Integer gb_id) {
		this.gb_id = gb_id;
	}
	public String getG_id() {
		return g_id;
	}
	public void setG_id(String g_id) {
		this.g_id = g_id;
	}
	public String getGd_name() {
		return gd_name;
	}
	public void setGd_name(String gd_name) {
		this.gd_name = gd_name;
	}
	public Double getGb_price() {
		return gb_price;
	}
	public void setGb_price(Double gb_price) {
		this.gb_price = gb_price;
	}
	public String getGd_start() {
		return gd_start;
	}
	public void setGd_start(String gd_start) {
		this.gd_start = gd_start;
	}
	public String getGd_end() {
		return gd_end;
	}
	public void setGd_end(String gd_end) {
		this.gd_end = gd_end;
	}
	public String getGd_prompt() {
		return gd_prompt;
	}
	public void setGd_prompt(String gd_prompt) {
		this.gd_prompt = gd_prompt;
	}
	public String getGd_hottip() {
		return gd_hottip;
	}
	public void setGd_hottip(String gd_hottip) {
		this.gd_hottip = gd_hottip;
	}
	public String getGd_desc() {
		return gd_desc;
	}
	public void setGd_desc(String gd_desc) {
		this.gd_desc = gd_desc;
	}
	public Integer getGd_click() {
		return gd_click;
	}
	public void setGd_click(Integer gd_click) {
		this.gd_click = gd_click;
	}
	public Integer getGd_num() {
		return gd_num;
	}
	public void setGd_num(Integer gd_num) {
		this.gd_num = gd_num;
	}
	public String getGd_type() {
		return gd_type;
	}
	public void setGd_type(String gd_type) {
		this.gd_type = gd_type;
	}
	public String getGd_typedesc() {
		return gd_typedesc;
	}
	public void setGd_typedesc(String gd_typedesc) {
		this.gd_typedesc = gd_typedesc;
	}
	public String getGd_tishi() {
		return gd_tishi;
	}
	public void setGd_tishi(String gd_tishi) {
		this.gd_tishi = gd_tishi;
	}
	public Integer getS_id() {
		return s_id;
	}
	public void setS_id(Integer s_id) {
		this.s_id = s_id;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	
	
}

package com.yc.po;

import java.io.Serializable;

public class SellerPO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer s_id;
	private String s_name;
	private String s_pwd;
	private String s_tel;
	private String s_licence;
	private String s_addr;
	private String s_Pic;
	private Integer s_state;
	
	public Integer getS_id() {
		return s_id;
	}
	public void setS_id(Integer s_id) {
		this.s_id = s_id;
	}
	public String getS_name() {
		return s_name;
	}
	public void setS_name(String s_name) {
		this.s_name = s_name;
	}
	public String getS_pwd() {
		return s_pwd;
	}
	public void setS_pwd(String s_pwd) {
		this.s_pwd = s_pwd;
	}
	public String getS_tel() {
		return s_tel;
	}
	public void setS_tel(String s_tel) {
		this.s_tel = s_tel;
	}
	public String getS_licence() {
		return s_licence;
	}
	public void setS_licence(String s_licence) {
		this.s_licence = s_licence;
	}
	public String getS_addr() {
		return s_addr;
	}
	public void setS_addr(String s_addr) {
		this.s_addr = s_addr;
	}
	public String getS_Pic() {
		return s_Pic;
	}
	public void setS_Pic(String s_Pic) {
		this.s_Pic = s_Pic;
	}
	
	public Integer getS_state() {
		return s_state;
	}
	public void setS_state(Integer s_state) {
		this.s_state = s_state;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}

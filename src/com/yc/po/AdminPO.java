package com.yc.po;

import java.io.Serializable;

public class AdminPO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer a_id;
	private String a_name;
	private String a_pwd;
	private String a_mark;
	private Integer a_state;
	
	public Integer getA_id() {
		return a_id;
	}
	public void setA_id(Integer a_id) {
		this.a_id = a_id;
	}
	public String getA_name() {
		return a_name;
	}
	public void setA_name(String a_name) {
		this.a_name = a_name;
	}
	public String getA_pwd() {
		return a_pwd;
	}
	public void setA_pwd(String a_pwd) {
		this.a_pwd = a_pwd;
	}
	public String getA_mark() {
		return a_mark;
	}
	public void setA_mark(String a_mark) {
		this.a_mark = a_mark;
	}
	public Integer getA_state() {
		return a_state;
	}
	public void setA_state(Integer a_state) {
		this.a_state = a_state;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	 

}

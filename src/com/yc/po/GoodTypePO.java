package com.yc.po;

import java.io.Serializable;

public class GoodTypePO implements Serializable{
	private Integer t_id;
	private String t_name;
	private String t_disc;
	private Integer t_parent;
	public Integer getT_id() {
		return t_id;
	}
	public void setT_id(Integer t_id) {
		this.t_id = t_id;
	}
	public String getT_name() {
		return t_name;
	}
	public void setT_name(String t_name) {
		this.t_name = t_name;
	}
	public String getT_disc() {
		return t_disc;
	}
	public void setT_disc(String t_disc) {
		this.t_disc = t_disc;
	}
	public Integer getT_parent() {
		return t_parent;
	}
	public void setT_parent(Integer t_parent) {
		this.t_parent = t_parent;
	}
	
	

}

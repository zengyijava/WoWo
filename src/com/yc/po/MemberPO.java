package com.yc.po;

import java.io.Serializable;
import java.util.Date;

public class MemberPO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer m_id;
	private String m_name;
	private String m_pwd;
	private String m_tel;
	private String m_sex;
	private String m_email;
	private String m_date;
	private Integer m_score;
	private Integer m_rank;
	private Double m_money;
	private String m_pic;
	
	
	public String getM_date() {
		return m_date;
	}
	public void setM_date(String m_date) {
		this.m_date = m_date;
	}
	public Integer getM_id() {
		return m_id;
	}
	public void setM_id(Integer m_id) {
		this.m_id = m_id;
	}
	public String getM_name() {
		return m_name;
	}
	public void setM_name(String m_name) {
		this.m_name = m_name;
	}
	public String getM_pwd() {
		return m_pwd;
	}
	public void setM_pwd(String m_pwd) {
		this.m_pwd = m_pwd;
	}
	public String getM_tel() {
		return m_tel;
	}
	public void setM_tel(String m_tel) {
		this.m_tel = m_tel;
	}
	public String getM_sex() {
		return m_sex;
	}
	public void setM_sex(String m_sex) {
		this.m_sex = m_sex;
	}
	public String getM_email() {
		return m_email;
	}
	public void setM_email(String m_email) {
		this.m_email = m_email;
	}
	
	public Integer getM_score() {
		return m_score;
	}
	public void setM_score(Integer m_score) {
		this.m_score = m_score;
	}
	public Integer getM_rank() {
		return m_rank;
	}
	public void setM_rank(Integer m_rank) {
		this.m_rank = m_rank;
	}
	public Double getM_money() {
		return m_money;
	}
	public void setM_money(Double m_money) {
		this.m_money = m_money;
	}
	public String getM_pic() {
		return m_pic;
	}
	public void setM_pic(String m_pic) {
		this.m_pic = m_pic;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}

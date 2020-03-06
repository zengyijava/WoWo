package com.yc.po;

import java.io.Serializable;
import java.util.List;

public class EasyUITreeNode implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Object id;
	private String text;
	private String iconCls;
	private String checked;
	private String state;
	private Object attributes;
	private List<EasyUITreeNode> children;
	public Object getId() {
		return id;
	}
	public void setId(Object id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getIconCls() {
		return iconCls;
	}
	public void setIconCls(String iconCls) {
		this.iconCls = iconCls;
	}
	public String getChecked() {
		return checked;
	}
	public void setChecked(String checked) {
		this.checked = checked;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public Object getAttributes() {
		return attributes;
	}
	public void setAttributes(Object attributes) {
		this.attributes = attributes;
	}
	public List<EasyUITreeNode> getChildren() {
		return children;
	}
	public void setChildren(List<EasyUITreeNode> children) {
		this.children = children;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
}

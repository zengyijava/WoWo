package com.yc.dao;

import com.yc.po.MemberPO;

public interface IMemberDAO {
	
	public int regMember(MemberPO po) throws Exception;
	
	
	public MemberPO login(MemberPO po) throws Exception;

}

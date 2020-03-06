package com.yc.util;

import java.util.ArrayList;
import java.util.List;

import com.yc.po.EasyUITreeNode;
import com.yc.vo.GoodVO;

public class EasyuiUtil {
	public static List<EasyUITreeNode> asTreeNodeList(List<GoodVO> list, String... fileds) {
		List<EasyUITreeNode> ret = new ArrayList<EasyUITreeNode>();
		for (GoodVO vo : list) {
			EasyUITreeNode node = new EasyUITreeNode();
			for (String s : fileds) {
				if ("t_id".equals(s)) {
					System.out.println(1);
					node.setId(vo.getT_id());
				} else if ("t_name".equals(s)) {
					System.out.println(2);
					node.setText(vo.getT_name());
				} else if ("g_id".equals(s)) {
					node.setId(vo.getG_id());
				} else if ("g_name".equals(s)) {
					node.setText(vo.getG_name());
				} else if ("P_attr".equals(s)) {
					node.setState("closed");
					node.setAttributes("parent");
				} else if ("c_attr".equals(s)) {
					node.setAttributes("child");
				}
			}
			ret.add(node);
		}
		return ret;

	}
}

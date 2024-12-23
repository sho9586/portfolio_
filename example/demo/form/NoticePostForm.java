package com.example.demo.form;

import lombok.Data;

/*
 * お知らせフォーム
 */
@Data
public class NoticePostForm{
	
	//グループID
	private String groupId;
	
	//お知らせ内容
	private String osirase2;

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	public String getOsirase2() {
		return osirase2;
	}

	public void setOsirase2(String osirase2) {
		this.osirase2 = osirase2;
	}

	
}

package com.example.demo.entity;

import lombok.Data;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDateTime;

import com.example.demo.form.NoticePostForm;

@Entity
@Table(name = "notice")
public class Notice {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name= "group_id")
	private String groupId;
	
	@Column(name= "active_flag")
	private boolean activeFlag;	
	
	@Column(name= "content")
	private String content;	
	
	//inserttableとupdatetableにfalseを設定して、INSERTやUPDATE時にクエリにデータが含まれないようにする
    @Column(name = "created_at", insertable = false, updatable = false)
    private LocalDateTime createdAt; //作成日時
    
    @Column(name = "updated_at", insertable = false, updatable = false)
    private LocalDateTime updatedAt; //更新日時
	
	
	//デフォルトコンストラクタ（無いとエラーになるので追加する。）
	public Notice(){
		
	}
	
	//NoticePostForm（お知らせ登録フォーム）からお知らせEntityを起こす。
	public Notice(NoticePostForm form){
		//フォームのグループIDをEntityのグループIDにセットする。
		this.groupId = form.getGroupId();
		//フォームのお知らせ内容をContentに値を設定する。
		this.content = form.getOsirase2();
		//静的に有効フラグをtrueにする。
		this.activeFlag = true;
			
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	public boolean isActiveFlag() {
		return activeFlag;
	}

	public void setActiveFlag(boolean activeFlag) {
		this.activeFlag = activeFlag;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}


	}

	
	

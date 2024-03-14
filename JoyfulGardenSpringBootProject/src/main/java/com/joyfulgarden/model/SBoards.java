package com.joyfulgarden.model;

import java.util.List;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@SuppressWarnings("deprecation")
@Entity
@Table(name = "SBoards")
@SQLDelete(sql = "UPDATE product SET isDeleted = true WHERE id = ?") //@SQLDelete註解用來覆寫delete指令，每次我們執行delete指令時，我們會將其轉換成清單3.1.2中的UPDATE語句，這條指令將isDeleted欄位改為true，而不是永久刪除資料。
@Where(clause = "isDeleted = false")
public class SBoards {
	
	@Id
	@Column(name = "SBOARDID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer sboardID;
	
	@Column(name = "SBOARDTITLE")
	private String sboardTitle;
	
	@Column(name = "SBULLETIN")
	private String sbulletin;
	
	@Column(name = "MBOARDID")
	private Integer mboardID;
	
	@Column(name = "CREATETIME")
	private String createTime;
	
	@Column(name = "ISDELETED")
	private boolean isDeleted = Boolean.FALSE;
	
	
	/*一對多 多對一 多對多*/
	
	//@JsonIgnoreProperties({ "" })
	@JsonIgnore //但我不知道為何要加這行
	@ManyToOne
	@JoinColumn(name = "MBOARDID", insertable = false, updatable = false)
	private MBoards mBoards;
	
	@OneToMany(mappedBy = "sBoards",cascade = CascadeType.ALL)
	private List<Posts> posts;
	

	/*建構子
	 * 多對多
	 * 多對一
	 * 一對多*/
	
	public SBoards() {}


	public Integer getSboardID() {
		return sboardID;
	}

	public String getSboardTitle() {
		return sboardTitle;
	}

	public String getSbulletin() {
		return sbulletin;
	}

	public Integer getMboardID() {
		return mboardID;
	}

	public String getCreateTime() {
		return createTime;
	}

	public boolean isDeleted() {
		return isDeleted;
	}

	public MBoards getmBoards() {
		return mBoards;
	}

	public List<Posts> getPosts() {
		return posts;
	}

	public void setSboardID(Integer sboardID) {
		this.sboardID = sboardID;
	}

	public void setSboardTitle(String sboardTitle) {
		this.sboardTitle = sboardTitle;
	}

	public void setSbulletin(String sbulletin) {
		this.sbulletin = sbulletin;
	}
	
	public void setMboardID(Integer mboardID) {
		this.mboardID = mboardID;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	public void setmBoards(MBoards mBoards) {
		this.mBoards = mBoards;
	}

	public void setPosts(List<Posts> posts) {
		this.posts = posts;
	}
	
	
	

	

}

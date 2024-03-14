package com.joyfulgarden.model;

import java.util.List;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.springframework.stereotype.Component;

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

@SuppressWarnings("deprecation") //告訴spring忽視警告
@Entity
@Table(name = "Posts")
@Component
@SQLDelete(sql = "UPDATE product SET isDeleted = true WHERE id = ?") //@SQLDelete註解用來覆寫delete指令，每次我們執行delete指令時，我們會將其轉換成清單3.1.2中的UPDATE語句，這條指令將isDeleted欄位改為true，而不是永久刪除資料。
@Where(clause = "isDeleted = false") //@where註解將會提供一個過濾器，當我們需要讀取Product資料時，結果中不會包含is_deleted = true的資料。在資料庫中false是0，true是1，但回傳是false和true
public class Posts {
	
	@Id
	@Column(name = "POSTID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer postID;
	
	@Column(name = "POSTTITLE")
	private String postTitle;
	
	@Column(name = "POSTCONTENT")
	private String postContent;

	@Column(name = "AUTHORID")
	private Integer authorID;
	
	@Column(name = "SBOARDID") // 加了"insertable = false, updatable = false"這裡才能存在
	private Integer sboardID;
	
	@Column(name = "LIKESCOUNT")
	private Integer likesCount;
	
	@Column(name = "POSTTIME")
	private String postTime;

	@Column(name = "ISDELETED")
	private boolean isDeleted = Boolean.FALSE;
	
	
//	//@JsonIgnoreProperties({ "" })
//	@JsonIgnore //但我不知道為何要加這行
//	@ManyToOne
//	@JoinColumn(name = "AUTHORID", referencedColumnName = "MEMBERID")
//	private Members members;

	
	//@JsonIgnoreProperties({ "" })
	@JsonIgnore //但我不知道為何要加這行
	@ManyToOne
	@JoinColumn(name = "SBOARDID", insertable = false, updatable = false) //加了這行就能和sboardID實例共存
	private SBoards sBoards;
	
	@OneToMany(mappedBy = "posts",cascade = CascadeType.ALL)
	private List<Replies> replies;
	
	@OneToMany(mappedBy = "posts",cascade = CascadeType.ALL)
	private List<Comments> comments;
	
	/*建構子
	 * 多對多
	 * 多對一
	 * 一對多*/
	
	public Posts() {}
	
	

	public Posts(Integer postID, String postTitle, String postContent, Integer authorID, Integer sboardID,
			Integer likesCount, String postTime, boolean isDeleted, SBoards sBoards, List<Replies> replies,
			List<Comments> comments) {
		super();
		this.postID = postID;
		this.postTitle = postTitle;
		this.postContent = postContent;
		this.authorID = authorID;
		this.sboardID = sboardID;
		this.likesCount = likesCount;
		this.postTime = postTime;
		this.isDeleted = isDeleted;
		this.sBoards = sBoards;
		this.replies = replies;
		this.comments = comments;
	}



	public Integer getPostID() {
		return postID;
	}

	public String getPostTitle() {
		return postTitle;
	}

	public String getPostContent() {
		return postContent;
	}

	public Integer getAuthorID() {
		return authorID;
	}
	

	public Integer getSboardID() {
		return sboardID;
	}


	public Integer getLikesCount() {
		return likesCount;
	}

	public String getPostTime() {
		return postTime;
	}

	public boolean isDeleted() {
		return isDeleted;
	}

	public SBoards getsBoards() {
		return sBoards;
	}

	public List<Replies> getReplies() {
		return replies;
	}

	public List<Comments> getComments() {
		return comments;
	}

	public void setPostID(Integer postID) {
		this.postID = postID;
	}

	public void setPostTitle(String postTitle) {
		this.postTitle = postTitle;
	}

	public void setPostContent(String postContent) {
		this.postContent = postContent;
	}

	public void setAuthorID(Integer authorID) {
		this.authorID = authorID;
	}
	
	public void setSboardID(Integer sboardID) {
		this.sboardID = sboardID;
	}

	public void setLikesCount(Integer likesCount) {
		this.likesCount = likesCount;
	}

	public void setPostTime(String postTime) {
		this.postTime = postTime;
	}

	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	public void setsBoards(SBoards sBoards) {
		this.sBoards = sBoards;
	}

	public void setReplies(List<Replies> replies) {
		this.replies = replies;
	}

	public void setComments(List<Comments> comments) {
		this.comments = comments;
	}
	
	
	
	
	
	
	
	


	
	
}

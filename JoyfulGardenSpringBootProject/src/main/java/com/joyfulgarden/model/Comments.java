package com.joyfulgarden.model;


import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@SuppressWarnings("deprecation")
@Entity
@Table(name = "COMMENTS")
@SQLDelete(sql = "UPDATE product SET isDeleted = true WHERE id = ?") //@SQLDelete註解用來覆寫delete指令，每次我們執行delete指令時，我們會將其轉換成清單3.1.2中的UPDATE語句，這條指令將isDeleted欄位改為true，而不是永久刪除資料。
@Where(clause = "isDeleted = false")
public class Comments {
	
	@Id
	@Column(name = "COMMENTID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer commentID;
	
	@Column(name = "COMMENTCONTENT")
	private String commentContent;

	@Column(name = "AUTHORID")
	private Integer authorID;
	
	@Column(name = "TARGETTYPE")
	private String targetType;
	
	@Column(name = "POSTID")
	private Integer postID;
	
	@Column(name = "REPLYID")
	private Integer replyID;
	
	@Column(name = "LIKESCOUNT")
	private Integer likesCount;
	
	@Column(name = "COMMENTTIME")
	private String commentTime;
	
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
	@JoinColumn(name = "POSTID", insertable = false, updatable = false)
	private Posts posts;
	
	//@JsonIgnoreProperties({ "" })
	@JsonIgnore //但我不知道為何要加這行
	@ManyToOne
	@JoinColumn(name = "REPLYID", insertable = false, updatable = false)
	private Replies replies;

	/*建構子
	 * 多對多
	 * 多對一
	 * 一對多*/
	
	public Comments() {}

	
	public Integer getCommentID() {
		return commentID;
	}

	public String getCommentContent() {
		return commentContent;
	}

	public Integer getAuthorID() {
		return authorID;
	}

	public String getTargetType() {
		return targetType;
	}
	
	public Integer getPostID() {
		return postID;
	}

	public Integer getReplyID() {
		return replyID;
	}

	public Integer getLikesCount() {
		return likesCount;
	}

	public String getCommentTime() {
		return commentTime;
	}

	public boolean isDeleted() {
		return isDeleted;
	}

	public Posts getPosts() {
		return posts;
	}

	public Replies getReplies() {
		return replies;
	}

	public void setCommentID(Integer commentID) {
		this.commentID = commentID;
	}

	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}

	public void setAuthorID(Integer authorID) {
		this.authorID = authorID;
	}

	public void setTargetType(String targetType) {
		this.targetType = targetType;
	}
	
	public void setPostID(Integer postID) {
		this.postID = postID;
	}

	public void setReplyID(Integer replyID) {
		this.replyID = replyID;
	}

	public void setLikesCount(Integer likesCount) {
		this.likesCount = likesCount;
	}

	public void setCommentTime(String commentTime) {
		this.commentTime = commentTime;
	}

	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	public void setPosts(Posts posts) {
		this.posts = posts;
	}

	public void setReplies(Replies replies) {
		this.replies = replies;
	}
	
	
	
	
	
	
	
	
	

	

}

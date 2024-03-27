package com.joyfulgarden.util;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "PostsCK")
public class PostsCK {
	
	@Id
	@Column(name = "postID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer postID;
	
	@Column(name = "post_title")
	private String post_title;
	
	@Column(name = "post_content")
	private String post_content;

	@Column(name = "authorID")
	private Integer authorID;
	
	@Column(name = "sboardID")
	private Integer sboardID;
	
	@Column(name = "likes_count")
	private Integer likes_count;
	
	@Column(name = "post_time")
	private String post_time;
	
	/*建構子
	 * 多對多
	 * 多對一
	 * 一對多*/

	public Integer getPostID() {
		return postID;
	}

	public String getPost_title() {
		return post_title;
	}

	public String getPost_content() {
		return post_content;
	}

	public Integer getAuthorID() {
		return authorID;
	}

	public Integer getSboardID() {
		return sboardID;
	}

	public Integer getLikes_count() {
		return likes_count;
	}

	public String getPost_time() {
		return post_time;
	}

	public void setPostID(Integer postID) {
		this.postID = postID;
	}

	public void setPost_title(String post_title) {
		this.post_title = post_title;
	}

	public void setPost_content(String post_content) {
		this.post_content = post_content;
	}

	public void setAuthorID(Integer authorID) {
		this.authorID = authorID;
	}

	public void setSboardID(Integer sboardID) {
		this.sboardID = sboardID;
	}

	public void setLikes_count(Integer likes_count) {
		this.likes_count = likes_count;
	}

	public void setPost_time(String post_time) {
		this.post_time = post_time;
	}
	
}

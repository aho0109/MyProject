package com.joyfulgarden.model;

import java.util.List;

import org.springframework.stereotype.Component;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Forummembers")
@Component
public class Forummembers {

	@Id
	@Column(name = "FORUMMEMBERID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer forummemberID;
	
	@Column(name = "NICKNAME")
	private String nickname;
	
	@Column(name = "PASSWORD")
	private String password;
	
	@OneToMany(mappedBy = "forummembers", cascade = CascadeType.ALL)
	private List<Posts> posts;
	
	@OneToMany(mappedBy = "forummembers", cascade = CascadeType.ALL)
	private List<Replies> replies;
	
	@OneToMany(mappedBy = "forummembers", cascade = CascadeType.ALL)
	private List<Comments> comments;
	

	/*建構子
	 * 多對多
	 * 多對一
	 * 一對多*/
	
	public Forummembers() {}
	

	public Integer getForummemberID() {
		return forummemberID;
	}

	public String getNickname() {
		return nickname;
	}

	public String getPassword() {
		return password;
	}

	public List<Posts> getPosts() {
		return posts;
	}

	public void setForummemberID(Integer forummemberID) {
		this.forummemberID = forummemberID;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setPosts(List<Posts> posts) {
		this.posts = posts;
	}

	
	
	
	
	
	
	
	
	
}

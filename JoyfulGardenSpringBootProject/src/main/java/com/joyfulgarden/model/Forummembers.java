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
	
	// 增加一個方法用於根據 forummemberID 獲取對應的 nickname
    public String getNicknameByForummemberID(Integer forummemberID) {
        // 遍歷所有的 forummembers，找到對應的 forummemberID，返回其 nickname
        for (Replies reply : replies) {
            if (reply.getForummembers().getForummemberID().equals(forummemberID)) {
                return reply.getForummembers().getNickname();
            }
        }
        // 如果找不到對應的 forummemberID，返回 null 或者 throw Exception，視情況而定
        return null;
    }
	

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

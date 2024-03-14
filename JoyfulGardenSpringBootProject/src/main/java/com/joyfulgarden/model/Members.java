//package com.joyfulgarden.model;
//
//import java.util.List;
//
//import jakarta.persistence.CascadeType;
//import jakarta.persistence.Column;
//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//import jakarta.persistence.OneToMany;
//import jakarta.persistence.Table;
//
//@Entity
//@Table(name = "Members")
//public class Members {
//
//	@Id
//	@Column(name = "MEMBERID")
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private Integer MemberID;
//	
//	@Column(name = "MEMBERNAME")
//	private String MemberName;
//	
//	@OneToMany(mappedBy = "members", cascade = CascadeType.ALL)
//	private List<Posts> posts;
//
//	
//	/*建構子
//	 * 多對多
//	 * 多對一
//	 * 一對多*/
//	
//	
//	public Integer getMemberID() {
//		return MemberID;
//	}
//
//	public String getMemberName() {
//		return MemberName;
//	}
//
//	public void setMemberID(Integer memberID) {
//		MemberID = memberID;
//	}
//
//	public void setMemberName(String memberName) {
//		MemberName = memberName;
//	}
//
//	public List<Posts> getPosts() {
//		return posts;
//	}
//
//	public void setPosts(List<Posts> posts) {
//		this.posts = posts;
//	}
//	
//	
//	
//	
//	
//	
//}

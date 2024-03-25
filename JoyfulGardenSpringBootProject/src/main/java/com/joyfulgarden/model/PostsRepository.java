package com.joyfulgarden.model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PostsRepository extends JpaRepository<Posts, Integer> {
	
	//內建 查全 新增o 修改o
	
	// 查全由新到舊
	public List<Posts> findAllByOrderByPostIDDesc();
	
	
	//查bymembernameo
	//public List<Posts> findByMembers_MemberName(String memberName);
	
	//查全by sboardID
	public List<Posts> findBySboardID(Integer sboardID);
	
	// 作者查全
	public List<Posts> findByAuthorNicknameOrderByPostIDDesc(String authorNickname);
	
	//查全by sboardID由新到舊
	public List<Posts> findBySboardIDOrderByPostIDDesc(Integer sboardID);
	
	//查詢標題like
	public List<Posts> findByPostTitleContaining(String xxxtitle);
	
	//查詢內文like，不知可不可行
	public List<Posts> findByPostContentContaining(String xxxcontent);
	
	 
	// 關鍵字模糊搜尋
	// 但目前bug:文章刪了但 回覆沒刪或留言沒刪 找的時候還是會跑出來 點進去就消失
	@Query(value = "SELECT p.postID AS postID, p.postTitle AS postTitle, p.postContent AS postContent, " +
            "p.authorNickname AS authorNickname, p.sboardID AS sboardID, p.likesCount AS likesCount, " +
            "p.postTime AS postTime, p.isDeleted AS isDeleted " +
            "FROM Posts p LEFT JOIN Replies r ON p.postID = r.postID " +
            "WHERE (p.postTitle LIKE %:keyword% OR " +
            "p.postContent LIKE %:keyword% OR " +
            "r.replyContent LIKE %:keyword% OR " +
            "r.replyContent LIKE %:keyword%) " +
            "AND p.isDeleted = 0 " +
            "AND (r.isDeleted = 0 OR r.isDeleted IS NULL)", nativeQuery = true)
	List<Posts> findByKeywords(@Param("keyword") String keyword);
	
	
	// 沒用到
	@Query(value = "SELECT p.postID AS postID, p.postTitle AS postTitle, p.postContent AS postContent, " +
            "p.authorNickname AS authorNickname, p.sboardID AS sboardID, p.likesCount AS likesCount, " +
            "p.postTime AS postTime, p.isDeleted AS isDeleted " +
            "FROM Posts p LEFT JOIN Replies r ON p.postID = r.postID " +
            "WHERE (p.postTitle LIKE %:keyword% OR " +
            "p.postContent LIKE %:keyword% OR " +
            "r.replyContent LIKE %:keyword% OR " +
            "r.replyContent LIKE %:keyword%) " +
            "AND (:sboardID IS NULL OR p.sboardID = :sboardID)", nativeQuery = true) 
	//如果 sboardID 是空值（即 NULL），則忽略對 sboardID 的條件限制；否則，將 sboardID 與傳入的參數進行比較。這樣，你就可以同時根據 keyword 和 sboardID 進行搜尋。
	List<Posts> findByKeywordsAndSboardID(@Param("keyword") String keyword, @Param("sboardID") Integer sboardID);

	
	//刪除o(更換狀態) 那管理人該如何看到假刪除的資料?


}


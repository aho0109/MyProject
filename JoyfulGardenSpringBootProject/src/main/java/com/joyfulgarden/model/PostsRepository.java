package com.joyfulgarden.model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PostsRepository extends JpaRepository<Posts, Integer> {
	
	//內建 查全 新增o 修改o
	
	//查bymembernameo
	//public List<Posts> findByMembers_MemberName(String memberName);
	
	//查全by sboardID
	public List<Posts> findBySboardID(Integer sboardID); 
	
	//查詢標題like
	public List<Posts> findByPostTitleContaining(String xxxtitle);
	
	//查詢內文like，不知可不可行
	public List<Posts> findByPostContentContaining(String xxxcontent);
	
	 
	// 關鍵字模糊搜尋
	@Query(value = "SELECT p.postID AS postID, p.postTitle AS postTitle, p.postContent AS postContent, " +
            "p.authorID AS authorID, p.sboardID AS sboardID, p.likesCount AS likesCount, " +
            "p.postTime AS postTime, p.isDeleted AS isDeleted " +
            "FROM Posts p LEFT JOIN Replies r ON p.postID = r.postID " +
            "WHERE p.postTitle LIKE %:keyword% OR " +
            "p.postContent LIKE %:keyword% OR " +
            "r.replyContent LIKE %:keyword% OR " +
            "r.replyContent LIKE %:keyword%", nativeQuery = true)
	List<Posts> findByKeywords(@Param("keyword") String keyword);
	
	
	
	@Query(value = "SELECT p.postID AS postID, p.postTitle AS postTitle, p.postContent AS postContent, " +
            "p.authorID AS authorID, p.sboardID AS sboardID, p.likesCount AS likesCount, " +
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


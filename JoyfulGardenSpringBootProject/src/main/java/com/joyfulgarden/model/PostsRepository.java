package com.joyfulgarden.model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PostsRepository extends JpaRepository<Posts, Integer> {
	
	//內建 查全 新增o 修改o
	
	//查bymembernameo
	//public List<Posts> findByMembers_MemberName(String memberName);
	
	//查詢標題like
	public List<Posts> findByPostTitleContaining(String xxxtitle);
	
	//查詢內文like，不知可不可行
	public List<Posts> findByPostContentContaining(String xxxcontent);
	
	//刪除o(更換狀態) 那管理人該如何看到假刪除的資料?


}


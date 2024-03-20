package com.joyfulgarden.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

//import com.joyfulgarden.model.MembersRepository;
import com.joyfulgarden.model.Posts;
import com.joyfulgarden.model.PostsRepository;


@Service
@Transactional
public class PostsService {
	
	@Autowired
	private PostsRepository poRepos;
	
//	@Autowired
//	private MembersRepository memRepos; 
	
	//新增Ppsto
	public Posts insert(Posts post) {
		return poRepos.save(post);
	}
	
	//修改Post
	public Posts update(Posts post) {
		return poRepos.save(post);
	}
	
	// 刪除
	public void deleteById(Integer postID) {
		poRepos.deleteById(postID);
	}
	
	//找單一
	public Posts findById(Integer postID) {
		Optional<Posts> optional = poRepos.findById(postID);
		if(optional.isPresent()) {
			return optional.get();
		}else {
			return null ;
		}
	}
	
	//找全o
	public List<Posts> findAllPosts() {
		return poRepos.findAll();
	}
	
	// 找by sboardID
	public List<Posts> findAllPostsBySboardID(Integer sboardID) {
		return poRepos.findBySboardID(sboardID);
		
	}
	
	// 關鍵字模糊搜尋
	public List<Posts> findAllByKeywords(String keyword) {
		return poRepos.findByKeywords(keyword);
	}

//	public List<Posts> findByMemberName(String memberName) {
//		return poRepos.findByMembers_MemberName(memberName);
//	}
}

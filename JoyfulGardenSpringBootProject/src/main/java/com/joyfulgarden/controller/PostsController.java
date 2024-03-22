package com.joyfulgarden.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.joyfulgarden.model.Posts;
import com.joyfulgarden.service.PostsService;

@RestController
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class PostsController {

	@Autowired
	private PostsService postsService;
	
	// 刪除
	@DeleteMapping("/forum/posts/{postID}")
	public String doDeletetReplies(@PathVariable(name = "postID") Integer postID) {;
		postsService.deleteById(postID);
		return "已刪除文章";
	}
	
	// 找單一
	@GetMapping("/forum/posts/{postID}")
	public Posts doPostsByID(@PathVariable(name = "postID")Integer postID) {
		return postsService.findById(postID);
	}
	
	// 找全by sboardID
	@GetMapping("/forum/sboard={sboardID}/posts")
	public List<Posts> doAllPostsBySboardID(@PathVariable(name = "sboardID") Integer sboardID) {
		return postsService.findAllPostsBySboardID(sboardID);
	}
	
	// 找全o
	@GetMapping("/forum/posts")
	public List<Posts> doAllPosts() {
		return postsService.findAllPosts();
	}
	
	
	
	// 關鍵字模糊搜尋
	@GetMapping("/forum/search/{keyword}")
	public List<Posts> doKeywordSearch(@PathVariable String keyword) {
		return postsService.findAllByKeywords(keyword);
	}
	
	// 新增o
	@PostMapping("/forum/posts")
	public Posts doInsertPosts(/*@PathVariable(name = "sboardID") Integer sboardID,*/
									@RequestBody Posts post) {
		Posts npost = new Posts();
		npost.setPostTitle(post.getPostTitle());
		npost.setPostContent(post.getPostContent());
		//npost.setForummembers(post.getForummembers());
		npost.setAuthorID(post.getAuthorID());
		npost.setSboardID(post.getSboardID());// 有fk所以不能輸入不存在之sboardID
		//npost.setSboardID(sboardID);
		npost.setLikesCount(post.getLikesCount());
		npost.setPostTime(LocalDateTime.now());
		npost.setDeleted(false);
		postsService.insert(npost);
		return npost;
		//return postsService.insert(npost);
	}
	
	// 修改o
	@PutMapping("/forum/posts/{postID}")  //某某使修改某某使用者的文
	public Posts doUpdatePosts(@PathVariable(name = "postID") Integer postID, @RequestBody Posts post) {
		Posts upost = postsService.findById(postID);
		upost.setPostTitle(post.getPostTitle());
		upost.setPostContent(post.getPostContent());
		//upost.setMembers(members);
		upost.setAuthorID(post.getAuthorID());
		upost.setSboardID(post.getSboardID());// 有fk所以不能輸入不存在之sboardID
		upost.setLikesCount(post.getLikesCount());
		upost.setPostTime(post.getPostTime());
		//npost.setDeleted(true);
		postsService.update(upost);
		return upost;		
	}
	
}

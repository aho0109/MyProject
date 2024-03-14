package com.joyfulgarden.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.joyfulgarden.model.Posts;
import com.joyfulgarden.service.PostsService;

@RestController
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class PostsController {

	@Autowired
	private PostsService postsService;
	
	//修改o
	@PostMapping("/forum/posts/update/{postID}")  //某某使修改某某使用者的文
	public Posts doUpdatePosts(@PathVariable(name = "postID") Integer postID, @RequestBody Posts post) {
		Posts upost = postsService.findById(postID);
		upost.setPostTitle(post.getPostTitle());
		upost.setPostContent(post.getPostContent());
		//upost.setMembers(members);
		upost.setAuthorID(post.getAuthorID());
		upost.setsBoards(post.getsBoards());// 有fk所以不能輸入不存在之sboardID
		upost.setLikesCount(post.getLikesCount());
		upost.setPostTime(post.getPostTime());
		//npost.setDeleted(true);
		postsService.update(upost);
		return upost;		
	}
	
	//找全o
	@GetMapping("/forum/posts/all")
	public List<Posts> doAllPosts() {
		return postsService.findAllPosts();
	}
	
	//新增o
	@PostMapping("/forum/{sboardID}/posts/insert")
	public Posts doInsertPosts(@PathVariable(name = "sboardID") Integer sboardID,@RequestBody Posts post) {
		//Posts post = new Posts();
//		post.getPostTitle();
//		post.getPostContent();
//		//post.setMembers(members);
//		post.getAuthorID();
//		post.getSboardID();
//		post.getLikesCount();
//		post.getPostTime();
		
		Posts npost = new Posts();
		npost.setPostTitle(post.getPostTitle());
		npost.setPostContent(post.getPostContent());
		//post.setMembers(members);
		npost.setAuthorID(post.getAuthorID());
		//npost.setSboardID(post.getsBoards().getSboardID());// 有fk所以不能輸入不存在之sboardID
		npost.setSboardID(sboardID);
		npost.setLikesCount(post.getLikesCount());
		npost.setPostTime(post.getPostTime());
		npost.setDeleted(false);
		postsService.insert(npost);
		return npost;
		//return postsService.insert(npost);
	}
	
}

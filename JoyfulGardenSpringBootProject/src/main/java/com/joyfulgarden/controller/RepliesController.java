package com.joyfulgarden.controller;

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

import com.joyfulgarden.model.Replies;
import com.joyfulgarden.service.RepliesService;

@RestController
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class RepliesController { 

	

	@Autowired
	private RepliesService repliesService;
	
	// 刪除
	@DeleteMapping("/forum/replies/{replyID}")
	public String doDeletetReplies(@PathVariable(name = "replyID") Integer replyID) {;
	repliesService.deleteById(replyID);
		return "已刪除回覆";
	}
	
	// 找單一
	@GetMapping("/forum/replies/{replyID}")
	public Replies doRepliesByID(@PathVariable(name = "replyID")Integer replyID) {
		return repliesService.findById(replyID);
	}
	
	// 找全by postID
	@GetMapping("/forum/post={postID}/replies")
	public List<Replies> doAllRepliesByPostID(@PathVariable(name = "postID") Integer postID) {
		return repliesService.findAllRepliesByPostsID(postID);
	}
	
	// 新增o
	@PostMapping("/forum/post={postID}/replies")
	public Replies doInsertReplies(@PathVariable(name = "postID") Integer postID,
									@RequestBody Replies reply) {
		Replies nreplies = new Replies();
		nreplies.setReplyContent(reply.getReplyContent());
		//post.setMembers(members);
		nreplies.setAuthorID(reply.getAuthorID());
		//nreplies.setSboardID(replies.getSboardID());// 有fk所以不能輸入不存在之sboardID
		nreplies.setPostID(postID);
		nreplies.setLikesCount(reply.getLikesCount());
		nreplies.setReplyTime(reply.getReplyTime());
		nreplies.setDeleted(false);
		repliesService.insert(nreplies);
		return nreplies;
		//return postsService.insert(npost);
	}
	
	// 修改o
	@PutMapping("/forum/post={postID}/replies/{replyID}")  //某某使修改某某使用者的文
	public Replies doUpdateReplies(/*@PathVariable(name = "postID") Integer postID,*/
									@PathVariable(name = "replyID") Integer replyID, 
									@RequestBody Replies reply) {
		Replies ureplies = repliesService.findById(replyID);
		ureplies.setReplyContent(reply.getReplyContent());
		//upost.setMembers(members);
		ureplies.setAuthorID(reply.getAuthorID());
		//upost.setSboards(replies.getSboards());// 有fk所以不能輸入不存在之sboardID
		ureplies.setLikesCount(reply.getLikesCount());
		ureplies.setReplyTime(reply.getReplyTime());
		//npost.setDeleted(true);
		repliesService.update(ureplies);
		return ureplies;		
	}
	
}

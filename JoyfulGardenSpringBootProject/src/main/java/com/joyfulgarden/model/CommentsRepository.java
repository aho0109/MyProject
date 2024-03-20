package com.joyfulgarden.model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentsRepository extends JpaRepository<Comments, Integer> {

	List<Comments> findByTargetTypeAndPostIDAndReplyID(String targetType, Integer postID, Integer replyID);
	
	//List<Comments> findByTargetTypeAndReplyID(String targetType, Integer replyID);

}

package com.joyfulgarden.model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RepliesRepository extends JpaRepository<Replies, Integer> {

	List<Replies> findByPostID(Integer postID);
	
}

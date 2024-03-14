package com.joyfulgarden.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.joyfulgarden.model.RepliesRepository;

@Service
@Transactional
public class RepliesService {

	@Autowired
	private RepliesRepository repRepos;
}

package com.joyfulgarden.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.joyfulgarden.model.SBoards;
import com.joyfulgarden.model.SBoardsRepository;

@Service
@Transactional
public class SBoardsService {

	@Autowired
	private SBoardsRepository sbRepos;
	
	// 找全
	public List<SBoards> findAllMBoards() {
		return sbRepos.findAll();
	}
	
	// 新增
	public SBoards insert(SBoards sBoards) {
		return sbRepos.save(sBoards);
	}
	
	// 修改
	public SBoards update(SBoards sBoards) {
		return sbRepos.save(sBoards);
	}
	
	// 刪除
	public void deleteById(Integer sboardID) {
		sbRepos.deleteById(sboardID);
	}
	
	
	public SBoards findById(Integer sboardID) {
		Optional<SBoards> optional = sbRepos.findById(sboardID);
		if(optional.isPresent()) {
			return optional.get();
		}else {
			return null ;
		}
	}
	
	
}

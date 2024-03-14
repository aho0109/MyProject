package com.joyfulgarden.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.joyfulgarden.model.MBoards;
import com.joyfulgarden.model.MBoardsRepository;

@Service
@Transactional
public class MBoardsService {
	
	@Autowired
	private MBoardsRepository mbRepos;
	//管理者才看的到
	
	//[管理主板]--列出所有主板
	//增
	//刪by名稱
	//改
	
	// 找全
	public List<MBoards> findAllMBoards() {
		return mbRepos.findAll();
	}
	
	// 新增
	public MBoards insert(MBoards mBoards) {
		return mbRepos.save(mBoards);
	}
	
	//修改
	public MBoards update(MBoards mBoards) {
		return mbRepos.save(mBoards);
	}
	
	//刪除
	public void deleteById(Integer mboardID) {
		mbRepos.deleteById(mboardID);
	}
	
	
	public MBoards findById(Integer mboardID) {
		Optional<MBoards> optional = mbRepos.findById(mboardID);
		if(optional.isPresent()) {
			return optional.get();
		}else {
			return null ;
		}
	}
	
}

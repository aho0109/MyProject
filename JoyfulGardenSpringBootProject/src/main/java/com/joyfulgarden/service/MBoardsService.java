package com.joyfulgarden.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.joyfulgarden.model.Mboards;
import com.joyfulgarden.model.MboardsRepository;

@Service
@Transactional
public class MboardsService {
	
	@Autowired
	private MboardsRepository mbRepos;
	//管理者才看的到
	
	//[管理主板]--列出所有主板
	//增
	//刪by名稱
	//改
	
	// 找全
	public List<Mboards> findAllMBoards() {
		return mbRepos.findAll();
	}
	
	// 新增
	public Mboards insert(Mboards mboards) {
		return mbRepos.save(mboards);
	}
	
	//修改
	public Mboards update(Mboards mboards) {
		return mbRepos.save(mboards);
	}
	
	//刪除
	public void deleteById(Integer mboardID) {
		mbRepos.deleteById(mboardID);
	}
	
	
	public Mboards findById(Integer mboardID) {
		Optional<Mboards> optional = mbRepos.findById(mboardID);
		if(optional.isPresent()) {
			return optional.get();
		}else {
			return null ;
		}
	}
	
}

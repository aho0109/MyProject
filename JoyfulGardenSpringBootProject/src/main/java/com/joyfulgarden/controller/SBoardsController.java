package com.joyfulgarden.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.joyfulgarden.model.SBoards;
import com.joyfulgarden.service.SBoardsService;

@RestController
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class SBoardsController {
	
	@Autowired
	private SBoardsService sBoardsService;
	
	//找全
	@GetMapping("/forum/xxxmboards/sboards/all")
	public List<SBoards> doAllSBoards() {
		return sBoardsService.findAllMBoards();
	}
	
	// 新增
	@PostMapping("/forum/xxxmboards/sboards/insert")
	public SBoards doInsertSBoards(@PathVariable(name ="mboardID") Integer mboardID, @RequestBody SBoards sBoards) {
		SBoards nsBoards = new SBoards();
		nsBoards.setSboardTitle(sBoards.getSboardTitle());
		nsBoards.setSbulletin(sBoards.getSbulletin());
		nsBoards.setMboardID(mboardID);
		nsBoards.setCreateTime(sBoards.getCreateTime());
		nsBoards.setDeleted(false);
		sBoardsService.insert(nsBoards);
		return nsBoards;
		
	}

}

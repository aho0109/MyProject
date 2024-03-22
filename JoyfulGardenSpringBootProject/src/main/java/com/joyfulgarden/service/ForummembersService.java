package com.joyfulgarden.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.joyfulgarden.model.Forummembers;
import com.joyfulgarden.model.ForummembersRepository;


@Service
@Transactional
public class ForummembersService {
	
	@Autowired
	private ForummembersRepository forummemRepos;
	
	public Forummembers register(Forummembers forummembers) {
        // 檢查帳號是否已存在
        if (forummemRepos.findByNickname(forummembers.getNickname()) != null) {
            throw new RuntimeException("帳號已存在");
        }
        // 其他驗證邏輯可在此處加入

        // 密碼加密等處理可在此處加入
        
        // 儲存會員資料
        return forummemRepos.save(forummembers);
    }

    public Forummembers login(String nickname, String password) {
    	Forummembers forummembers = forummemRepos.findByNickname(nickname);
        if (forummembers == null || !forummembers.getPassword().equals(password)) {
            throw new RuntimeException("帳號或密碼錯誤");
        }
        // 登入成功，可在此處進行其他相關處理，如產生 token 等
        return forummembers;
    }
	

}

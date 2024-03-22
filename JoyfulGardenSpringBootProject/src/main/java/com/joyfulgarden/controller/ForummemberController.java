package com.joyfulgarden.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.joyfulgarden.model.Forummembers;
import com.joyfulgarden.service.ForummembersService;

@RestController
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class ForummemberController {

	@Autowired
    private ForummembersService forummembersService;

    @PostMapping("/forum/register")
    public ResponseEntity<Forummembers> register(@RequestBody Forummembers forummembers) {
    	Forummembers registeredMember = forummembersService.register(forummembers);
        return ResponseEntity.ok(registeredMember);
    }

    @PostMapping("/forum/login")
    public ResponseEntity<Forummembers> login(@RequestBody Forummembers forummembers) {
    	Forummembers loggedMember = forummembersService.login(forummembers.getNickname(), forummembers.getPassword());
        return ResponseEntity.ok(loggedMember);
    }
    
//    @PostMapping("/forum/login")
//    public ResponseEntity<Forummembers> login(@RequestBody Forummembers forummembers) {
//        // 從前端接收到的使用者暱稱和密碼
//        String nickname = forummembers.getNickname();
//        String password = forummembers.getPassword();
//        
//        // 在這裡進行登入驗證，例如驗證暱稱和密碼是否正確
//
//        // 假設驗證成功，回傳一個使用者物件，你可以在這個物件中包含任何你想要回傳的使用者資訊
//        User user = new User();
//        user.setNickname(nickname);
//        // 其他相關處理
//
//        return ResponseEntity.ok(user);
//    }
	
}

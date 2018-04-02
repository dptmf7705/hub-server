package com.dankook.hub.controller;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dankook.hub.service.UserService;
import com.dankook.hub.vo.LoginVO;
import com.dankook.hub.vo.UserVO;

@Controller
@RequestMapping("/android/user")
public class UserController {

    @Autowired
    private UserService userService;
    
    @RequestMapping("/login")
    @ResponseBody
    public HashMap<String, Object> login(LoginVO lvo, HttpSession session) {
        System.out.println("UserController.login() called... with " + lvo.toString());
 
        	return userService.login(lvo, session);
    }
    
    @RequestMapping("/join")
    public void join(UserVO uvo) {
        System.out.println("UserController.join() called... with " + uvo.toString());
        
        userService.insertUser(uvo);
    }
    
    @RequestMapping("/overlap")
    @ResponseBody
    public HashMap<String, Object> overlap(String usr_id) {
    	System.out.println("UserController.overlap() called... with "+usr_id);
    	
    	return userService.overlap(usr_id);
    }

    @RequestMapping("/profile/settings")
    @ResponseBody
    public UserVO profileSettings(HttpSession session){
    	String userId = (String) session.getAttribute("userId");
    	System.out.println("UserController.profileSettings() called... with" + userId);
    	
    	return userService.sessionGet(session);
    }
    
    
    @RequestMapping("/profile/update")
    @ResponseBody
    public UserVO profileUpdate(UserVO uvo, HttpSession session){
    	System.out.println("UserController.profileUpdate() called... with" );
    	
    	return userService.updateUser(uvo,session);
    }
    
   
}

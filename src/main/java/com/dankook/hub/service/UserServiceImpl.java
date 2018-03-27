package com.dankook.hub.service;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dankook.hub.dao.UserDAO;
import com.dankook.hub.utils.SHA256Util;
import com.dankook.hub.vo.LoginVO;
import com.dankook.hub.vo.UserVO;

@Service("userService")
public class UserServiceImpl implements UserService {

    private UserDAO dao;
    
    @Autowired
    public UserServiceImpl(SqlSession sqlSession) {
        System.out.println("UserService() called...");
        
        dao = sqlSession.getMapper(UserDAO.class);
    }

    @Override
    public HashMap<String, Object> login(LoginVO lvo) {
        HashMap<String, Object> map = new HashMap<>();
        
        UserVO uvo = dao.selectUser(lvo.getUsr_id());
        /* uvo password 를  hash에서 정상으로 변환*/
        String memberSalt = uvo.getUsr_salt();
        String inputPassword = lvo.getUsr_password();
        String newPassword = SHA256Util.getEncrypt(inputPassword, memberSalt);
        lvo.setUsr_password(newPassword);
        
        if(uvo != null) { // id 議댁옱
            if(uvo.getUsr_password().equals(lvo.getUsr_password())){ // 濡쒓렇�씤 �꽦怨�
                uvo.setUsr_password("");
                map.put("result", true);
                map.put("user", uvo);
                return map;
            } else { // password ��由�
                map.put("result", false);
                map.put("fail", "password");
                return map;
            }
        } else { // id ��由�
            map.put("result", false);
            map.put("fail", "id");
            return map;
        }
    }
    
    @Override
    public void insertUser(UserVO uvo) {
        System.out.println("UserService.addUser() called...");
        
        /* 받아온 password값을 SHA256 으로 암호화*/
        String salt = SHA256Util.generateSalt();
        String newPassword = SHA256Util.getEncrypt(uvo.getUsr_password(), salt);
        uvo.setUsr_password(newPassword);
        uvo.setUsr_salt(salt);
        
        dao.insertUser(uvo);
    }

    @Override
    public UserVO selectUser(String usr_id) {
        System.out.println("UserService.getUser() called...");
        
        return dao.selectUser(usr_id);
    }

    @Override
    public HashMap<String, Object> overlap(String usr_id) {
    	System.out.println("UserService.overlap() called...");
    	HashMap<String, Object> map = new HashMap<>();
    	
    	if(dao.overlap(usr_id)==0) {
    		map.put("result", true);
    		return map;
    	}
    	else {
    		map.put("result", false);
    		return map;
    	}
    }

}

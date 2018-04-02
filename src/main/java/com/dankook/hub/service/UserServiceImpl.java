package com.dankook.hub.service;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

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

    public HashMap<String, Object> login(LoginVO lvo, HttpSession session) {
        HashMap<String, Object> map = new HashMap<String, Object>();
        
        UserVO uvo = dao.selectUser(lvo.getUsr_id());
        /* 안드로이드에서 받아온 패스워드를 해쉬로 변환하여 비교*/
        String memberSalt = uvo.getUsr_salt();
        String inputPassword = lvo.getUsr_password();
        String newPassword = SHA256Util.getEncrypt(inputPassword, memberSalt);
        
        if(uvo != null) { // id 議댁옱
            if(uvo.getUsr_password().equals(newPassword)){ // 濡쒓렇�씤 �꽦怨�
            	session.setAttribute("userId", uvo.getUsr_id());
                session.setAttribute("userPhone",uvo.getUsr_phone());
                session.setAttribute("userPassword", lvo.getUsr_password());
                lvo.setUsr_password("");
                uvo.setUsr_password("");
                map.put("result", true);
                map.put("user", uvo);
                return map;
            } else { // password ��由�.
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
    public UserVO sessionGet(HttpSession session) {
        System.out.println("UserService.sessionGet() called...");
 
        UserVO uvo = new UserVO();
        uvo.setUsr_id((String) session.getAttribute("userId"));
        uvo.setUsr_password((String) session.getAttribute("userPassword"));
        uvo.setUsr_phone((String) session.getAttribute("userPhone"));
        
        return uvo;
    }

    @Override
    public HashMap<String, Object> overlap(String usr_id) {
    	System.out.println("UserService.overlap() called...");
    	HashMap<String, Object> map = new HashMap<String, Object>();
    	
    	if(dao.overlap(usr_id)==0) {
    		map.put("result", true);
    		return map;
    	}
    	else {
    		map.put("result", false);
    		return map;
    	}
    }

	@Override
	public UserVO updateUser(UserVO uvo, HttpSession session) {
		 System.out.println("UserService.updateUser() called...");
	        
	        /* 받아온 password값을 SHA256 으로 암호화*/
		    String inputPassword = uvo.getUsr_password();
	        String salt = SHA256Util.generateSalt();
	        String newPassword = SHA256Util.getEncrypt(inputPassword, salt);
	        uvo.setUsr_password(newPassword);
	        uvo.setUsr_salt(salt);
	        
	        /*id얻기 안드로이드에서 id변경은 불가능하므로 세션으로 얻는다, 
	         * 정보업데이트  원래 updateUser성공여부 확인해야 하나 현재는 안함*/
	        uvo.setUsr_id((String)session.getAttribute("userId"));
	        dao.updateUser(uvo);
	        
	        /* 세션 update */
	        UserVO returnUvo = dao.selectUser(uvo.getUsr_id()); 
	        session.setAttribute("userId", uvo.getUsr_id());
	        session.setAttribute("userPassword", inputPassword);
	        session.setAttribute("userPhone", uvo.getUsr_phone());
	        returnUvo.setUsr_password(inputPassword);
	        
	        return returnUvo;
	}

	@Override
	public UserVO selectUser(String usr_id) {
		// TODO Auto-generated method stub
		
		return null;
	}


}

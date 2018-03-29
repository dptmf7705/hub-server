package com.dankook.hub.service;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dankook.hub.dao.UserDAO;
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
        HashMap<String, Object> map = new HashMap<String, Object>();
        
        UserVO uvo = dao.selectUser(lvo.getUsr_id());
        if(uvo != null) { // id 존재
            if(uvo.getUsr_password().equals(lvo.getUsr_password())){ // 로그인 성공
                uvo.setUsr_password("");
                map.put("result", true);
                map.put("user", uvo);
                return map;
            } else { // password 틀림
                map.put("result", false);
                map.put("fail", "password");
                return map;
            }
        } else { // id 틀림
            map.put("result", false);
            map.put("fail", "id");
            return map;
        }
    }
    
    @Override
    public void insertUser(UserVO uvo) {
        System.out.println("UserService.addUser() called...");
        
        dao.insertUser(uvo);
    }

    @Override
    public UserVO selectUser(String usr_id) {
        System.out.println("UserService.getUser() called...");
        
        return dao.selectUser(usr_id);
    }


}

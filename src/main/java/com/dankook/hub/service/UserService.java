package com.dankook.hub.service;

import java.util.HashMap;

import com.dankook.hub.vo.LoginVO;
import com.dankook.hub.vo.UserVO;

public interface UserService {
    public void insertUser(UserVO uvo);
    public UserVO selectUser(String usr_id);
    public HashMap<String, Object> login(LoginVO lvo);
    public HashMap<String, Object> overlap(String usr_id);
}

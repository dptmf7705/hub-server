package com.dankook.hub.dao;

import com.dankook.hub.vo.UserVO;

public interface UserDAO {
    public void insertUser(UserVO uvo);
    public UserVO selectUser(String usr_id);
    public void updateUser(UserVO uvo);
    public void deleteUser(int usr_key);
    public int overlap(String usr_id);
}

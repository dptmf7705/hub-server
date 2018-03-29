package com.dankook.hub.dao;

import java.util.List;

import com.dankook.hub.vo.StoreFileVO;

public interface StoreFileDAO {
    public StoreFileVO selectFile(int atch_file_id);
    public List<StoreFileVO> listFiles(int atch_file_id);
    public void insertFiles(List<StoreFileVO> fileList);
}

package com.dankook.hub.service;

import java.util.List;

import com.dankook.hub.vo.StoreFileVO;

public interface StoreFileService {
    public StoreFileVO selectFile(int atch_file_id);
    public List<StoreFileVO> listFiles(int atch_file_id);
}

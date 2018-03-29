package com.dankook.hub.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.dankook.hub.vo.StoreFileVO;

public interface StoreFileService {
    public List<StoreFileVO> selectFiles(int atch_file_id);
    public void uploadFiles(int st_key, List<MultipartFile> files);
}

package com.dankook.hub.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dankook.hub.dao.StoreFileDAO;
import com.dankook.hub.vo.StoreFileVO;

@Service("storeFileService")
public class StoreFileServiceImpl implements StoreFileService {

    private StoreFileDAO dao;
    
    @Autowired
    public StoreFileServiceImpl(SqlSession sqlSession) {
        System.out.println("StoreFileService() called...");

        dao = sqlSession.getMapper(StoreFileDAO.class);
    }
    
    @Override
    public StoreFileVO selectFile(int atch_file_id) {
        System.out.println("StoreFileService.selectFile() called... with: " + atch_file_id);

        return dao.selectFile(atch_file_id);
    }

    @Override
    public List<StoreFileVO> listFiles(int atch_file_id) {
        System.out.println("StoreFileService.selectFile() called... with: " + atch_file_id);

        return dao.listFiles(atch_file_id);
    }

}

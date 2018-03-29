package com.dankook.hub.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dankook.hub.dao.StoreDAO;
import com.dankook.hub.vo.StoreAddVO;
import com.dankook.hub.vo.StoreDetailVO;
import com.dankook.hub.vo.StoreVO;

@Service("storeService")
public class StoreServiceImpl implements StoreService {

    private StoreDAO storeDao;
    
    @Autowired
    public StoreServiceImpl(SqlSession sqlSession) {
        storeDao = sqlSession.getMapper(StoreDAO.class);
    }
    
    @Override
    public List<StoreVO> listStores(String cate_name) {
        System.out.println("StoreService.listStores() called... with: " + cate_name);
        
        if("popular".equals(cate_name)) {
        	return storeDao.listAllStores();
        } else {
        	return storeDao.listStores(cate_name);
        }
    }

    @Override
    public StoreDetailVO selectStore(int st_key) {
        System.out.println("StoreService.selectStoreDetail() called... with: " + st_key);
        
        return storeDao.selectStore(st_key);
    }

	@Override
	public int insertStore(StoreAddVO svo) {
		storeDao.insertStore(svo);
		
		return svo.getSt_key();
	}
	
}

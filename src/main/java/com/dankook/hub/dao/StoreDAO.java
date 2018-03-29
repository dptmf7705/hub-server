package com.dankook.hub.dao;

import java.util.List;

import com.dankook.hub.vo.StoreAddVO;
import com.dankook.hub.vo.StoreDetailVO;
import com.dankook.hub.vo.StoreVO;

public interface StoreDAO {
    public List<StoreVO> listStores(String cate_name);
    public List<StoreVO> listAllStores();
    public StoreDetailVO selectStore(int st_key);
    public int insertStore(StoreAddVO svo);
}

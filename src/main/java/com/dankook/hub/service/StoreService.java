package com.dankook.hub.service;

import java.util.List;

import com.dankook.hub.vo.StoreDetailVO;
import com.dankook.hub.vo.StoreVO;

public interface StoreService {
    public List<StoreVO> listStores(String cate_name);
    public StoreDetailVO selectStoreDetail(int st_key);
}

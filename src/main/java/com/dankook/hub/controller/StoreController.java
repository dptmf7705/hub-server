package com.dankook.hub.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.dankook.hub.service.StoreFileService;
import com.dankook.hub.service.StoreService;
import com.dankook.hub.vo.StoreDetailVO;
import com.dankook.hub.vo.StoreFileVO;
import com.dankook.hub.vo.StoreVO;

@Controller
@RequestMapping("/android/store")
public class StoreController {

    @Autowired
    private StoreService storeService;
    
    @Autowired
    private StoreFileService StoreFileService;
    
    @RequestMapping("/list")
    @ResponseBody
    public List<StoreVO> list(@RequestParam("cate_name") String cate_name){
        System.out.println("StoreController.list() called...");
        
        return storeService.listStores(cate_name);
    }
    
    @RequestMapping("/detail")
    @ResponseBody
    public StoreDetailVO detail(@RequestParam("st_key") int st_key) {
        System.out.println("StoreController.detail() called...");

        return storeService.selectStore(st_key);
    }
    
    @RequestMapping("/file/selectFiles")
    @ResponseBody
    public List<StoreFileVO> selectFiles(@RequestParam("atch_file_id") int atch_file_id){
        System.out.println("StoreController.listFiles() called...");
        
        return StoreFileService.selectFiles(atch_file_id);
    }
    
}

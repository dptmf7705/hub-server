package com.dankook.hub.controller;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

import org.imgscalr.Scalr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.dankook.hub.service.StoreFileService;
import com.dankook.hub.service.StoreService;
import com.dankook.hub.vo.StoreAddVO;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private StoreService storeService;
    
    @Autowired
    private StoreFileService storeFileService;
    
    @RequestMapping(value = "/addStore", produces="application/json;charset=utf-8", method = RequestMethod.POST)
    @ResponseBody
    public String addStore(@ModelAttribute("uploadFile") StoreAddVO svo) throws Exception {
    	System.out.println("AdminController.addStore called...");
    	
    	int st_key = storeService.insertStore(svo);
    	System.out.println("insertStore: " + st_key);
    	
    	if(svo.getFiles() != null) {
    		storeFileService.uploadFiles(st_key, svo.getFiles());
    	}
    	return svo.getSt_tell();
    }
    
}

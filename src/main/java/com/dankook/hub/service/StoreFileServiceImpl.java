package com.dankook.hub.service;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.imageio.ImageIO;

import org.apache.ibatis.session.SqlSession;
import org.imgscalr.Scalr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.dankook.hub.dao.StoreFileDAO;
import com.dankook.hub.utils.EncodingUtil;
import com.dankook.hub.utils.ImageUtil;
import com.dankook.hub.vo.StoreFileVO;

@Service("storeFileService")
public class StoreFileServiceImpl implements StoreFileService {

    private StoreFileDAO storeFileDao;
    
    @Autowired
    public StoreFileServiceImpl(SqlSession sqlSession) {
        System.out.println("StoreFileService() called...");

        storeFileDao = sqlSession.getMapper(StoreFileDAO.class);
    }
    
    @Override
    public List<StoreFileVO> selectFiles(int atch_file_id) {
        System.out.println("StoreFileService.selectFile() called... with: " + atch_file_id);

        return storeFileDao.listFiles(atch_file_id);
    }

	@Override
	public void uploadFiles(int st_key, List<MultipartFile> files) {
		// TODO Auto-generated method stub
	    
		List<StoreFileVO> fileVO = new ArrayList<StoreFileVO>();
    	
    	if(files != null && files.size() > 0) {
    		for(int i = 0 ; i < files.size() ; i++) {
    			MultipartFile multipartFile = files.get(i);
    			StoreFileVO fvo = new StoreFileVO();
    			String orignFileName = multipartFile.getOriginalFilename(); //원본 파일 명
    			String fileExtn = orignFileName.substring(orignFileName.indexOf(".") + 1); //파일 확장자
    			String streFileName = UUID.randomUUID().toString(); //저장할 파일 명
    			String path = "/var/lib/tomcat8/webapps/ROOT/image/" + streFileName + "." + fileExtn; //파일 저장 경로
    			orignFileName = EncodingUtil.encoding(orignFileName);
    			fvo.setAtch_file_id(st_key);
    			fvo.setFile_index(i);
    			fvo.setFile_stre_url(path);
    			fvo.setStre_file_name(streFileName);
    			fvo.setOrign_file_name(orignFileName);
    			fvo.setFile_extn(fileExtn);
    			
    			File file = new File(path); //저장 경로에 파일 생성
    			try {
					multipartFile.transferTo(file); //멀티파트 파일을 파일에 저장
					ImageUtil.imageResize(path, path, fileExtn);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
    			fileVO.add(fvo);
    		}
    		storeFileDao.insertFiles(fileVO);
    	}
	}

}

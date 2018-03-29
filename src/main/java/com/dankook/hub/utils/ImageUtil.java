package com.dankook.hub.utils;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.PixelGrabber;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import org.imgscalr.Scalr;
import org.springframework.web.multipart.MultipartFile;

public class ImageUtil{

    public static void imageResize(String orgFilePath, String targetFilePath, String imageType) throws Exception{
    	BufferedImage originalImage = ImageIO.read(new File(orgFilePath));
    	
    	int resizeWidth = originalImage.getWidth();
    	int resizeHeight = originalImage.getHeight();
    	BufferedImage resizedImage = originalImage;
    	
    	if(resizeWidth > 640) {
	    	while(resizeWidth > 640) {
	    		System.out.println("imageResize(original) :" + resizeWidth + ", " +resizeHeight);
	    		resizeWidth = (int) (resizeWidth * 0.8);
	    		resizeHeight = (int) (resizeHeight * 0.8);
	    	}
    		System.out.println("imageResized :" + resizeWidth + ", " +resizeHeight);
	    	resizedImage = Scalr.resize(originalImage, resizeWidth, resizeHeight, null);
    	}
    	ImageIO.write(resizedImage, imageType, new File(targetFilePath));
    }

}
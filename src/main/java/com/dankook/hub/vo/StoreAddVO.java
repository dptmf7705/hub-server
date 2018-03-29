package com.dankook.hub.vo;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.dankook.hub.utils.EncodingUtil;

/**
 * @author yeseul
 *
 */
public class StoreAddVO {
    private List<MultipartFile> files;
    private int st_key;
    private String st_name;
    private String st_address;
    private int atch_file_id;
    private int ownr_key;
    private String st_tell;
    private String st_open_time;
    private String st_close_time;
    private String cate_name;
    private String st_introduction;
    
	public List<MultipartFile> getFiles() {
		return files;
	}
	public void setFiles(List<MultipartFile> files) {
		this.files = files;
	}

	public int getSt_key() {
		return st_key;
	}
	public void setSt_key(int st_key) {
		this.st_key = st_key;
	}
	public String getSt_name() {
		return st_name;
	}
	public void setSt_name(String st_name) {
		this.st_name = EncodingUtil.encoding(st_name);
	}
	public String getSt_address() {
		return st_address;
	}
	public void setSt_address(String st_address) {
		this.st_address = EncodingUtil.encoding(st_address);
	}
	public int getAtch_file_id() {
		return atch_file_id;
	}
	public void setAtch_file_id(int atch_file_id) {
		this.atch_file_id = atch_file_id;
	}
	public int getOwnr_key() {
		return ownr_key;
	}
	public void setOwnr_key(int ownr_key) {
		this.ownr_key = ownr_key;
	}
	public String getSt_tell() {
		return st_tell;
	}
	public void setSt_tell(String st_tell) {
		this.st_tell = EncodingUtil.encoding(st_tell);
	}
	public String getSt_open_time() {
		return st_open_time;
	}
	public void setSt_open_time(String st_open_time) {
		this.st_open_time = EncodingUtil.encoding(st_open_time);
	}
	public String getSt_close_time() {
		return st_close_time;
	}
	public void setSt_close_time(String st_close_time) {
		this.st_close_time = EncodingUtil.encoding(st_close_time);
	}
	public String getCate_name() {
		return cate_name;
	}
	public void setCate_name(String cate_name) {
		this.cate_name = cate_name;
	}
	public String getSt_introduction() {
		return st_introduction;
	}
	public void setSt_introduction(String st_introduction) {
		this.st_introduction = EncodingUtil.encoding(st_introduction);
	}
    
}

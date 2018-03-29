package com.dankook.hub.vo;

public class StoreVO {
    private int st_key;
    private String st_name;
    private String st_tell;
    private String st_address;
    private int atch_file_id;
    private int ownr_key;
    private String st_open_time;
    private String st_close_time;
    private String cate_name;
	private String st_introduction;
    
	@Override
	public String toString() {
		return "StoreVO [st_key=" + st_key + ", st_name=" + st_name + ", st_tell=" + st_tell + ", st_address="
				+ st_address + ", atch_file_id=" + atch_file_id + ", ownr_key=" + ownr_key + ", st_open_time="
				+ st_open_time + ", st_close_time=" + st_close_time + ", cate_name=" + cate_name + ", st_introduction="
				+ st_introduction + "]";
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
		this.st_name = st_name;
	}

	public String getSt_tell() {
		return st_tell;
	}

	public void setSt_tell(String st_tell) {
		this.st_tell = st_tell;
	}

	public String getSt_address() {
		return st_address;
	}

	public void setSt_address(String st_address) {
		this.st_address = st_address;
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

	public String getSt_open_time() {
		return st_open_time;
	}

	public void setSt_open_time(String st_open_time) {
		this.st_open_time = st_open_time;
	}

	public String getSt_close_time() {
		return st_close_time;
	}

	public void setSt_close_time(String st_close_time) {
		this.st_close_time = st_close_time;
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
		this.st_introduction = st_introduction;
	}

    
}

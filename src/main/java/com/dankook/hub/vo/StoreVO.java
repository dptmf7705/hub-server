package com.dankook.hub.vo;

public class StoreVO {
    private int st_key;
    private String st_name;
    private String st_address;
    private int atch_file_id;
    
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
    @Override
    public String toString() {
        return "StoreVO [st_key=" + st_key + ", st_name=" + st_name + ", st_address=" + st_address + ", atch_file_id="
                + atch_file_id + "]";
    }
    
}

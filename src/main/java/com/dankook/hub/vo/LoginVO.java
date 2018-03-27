package com.dankook.hub.vo;

public class LoginVO {
    private String usr_id;
    private String usr_password;
    private String usr_salt;
    
    
	public String getUsr_salt() {
		return usr_salt;
	}
	public void setUsr_salt(String usr_salt) {
		this.usr_salt = usr_salt;
	}
	public String getUsr_id() {
		return usr_id;
	}
	public void setUsr_id(String usr_id) {
		this.usr_id = usr_id;
	}
	public String getUsr_password() {
		return usr_password;
	}
	public void setUsr_password(String usr_password) {
		this.usr_password = usr_password;
	}
    
}

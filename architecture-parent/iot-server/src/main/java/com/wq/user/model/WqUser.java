package com.wq.user.model;

import java.io.Serializable;
import java.util.Map;

import com.alibaba.druid.support.json.JSONUtils;

public class WqUser implements Serializable{

	/**
     * 
     */
    private static final long serialVersionUID = 1L;
    private int userId;
	private String name;
	private String password;
	private int departId;
	private Map<String, Object> hobbies;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getDepartId() {
		return departId;
	}

	public void setDepartId(int departId) {
		this.departId = departId;
	}

	public Map<String, Object> getHobbies() {
		return hobbies;
	}

	public void setHobbies(Map<String, Object> hobbies) {
		this.hobbies = hobbies;
	}

}

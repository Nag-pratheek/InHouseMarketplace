package com.cg.market.entites;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user_Details")

public class User {
@Id
	@Column(name="userid")
	private Integer userId;
	@Column(name="password")
	private String password;
	
	
	public User(String password) {
		super();
		this.password = password;
	}


	public User(Integer userId, String password) {
		super();
		this.userId = userId;
		this.password = password;
	}


	public User() {
		super();

	}


	public Integer getUserId() {
		return userId;
	}


	public void setUserId(Integer userId) {
		this.userId = userId;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


}
	
	

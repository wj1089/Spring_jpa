package com.occamsrazor.web.admin;

import java.util.List;

import com.occamsrazor.web.user.User;

public interface AdminService {

	public void register(Admin admin);

	public List<Admin> findAll();
	
	public Admin findOne(String employNumber);

	public void modify(Admin admin);

	public void remove(Admin admin);
	
	

}

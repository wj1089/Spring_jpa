package com.occamsrazor.web.admin;

import java.util.List;

import com.occamsrazor.web.user.User;

public interface AdminService {

	public void add(Admin admin);

	public int count();

	public Admin login(Admin admin);

	public Admin detail(Admin admin);

	public boolean update(Admin admin);
	public boolean remove(String userid);
	
	public List<Admin> list();

	public void register(Admin admin);

	public List<Admin> findAll();

	public Admin detail(String employNumber);

	public void modify(Admin admin);

	public void remove(Admin admin);
	
}

package com.occamsrazor.web.user;

import java.util.List;

import com.occamsrazor.web.admin.Admin;

public interface UserService {
	
	public List<User> findAll();

	public User findOne(String userid);

	public void modify(User user);

	public void remove(User user);

	public void register(User user);
	
}

































//
//public void add(User user);
//public int count();
//public User login(User user);
//public User detail(User user);
//public boolean update(User user);
//public boolean remove(String userid);
//public List<User> list();
//public boolean idSearch(String user);
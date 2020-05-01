package com.occamsrazor.web.admin;

import java.util.List;

import org.springframework.stereotype.Component;

import com.occamsrazor.web.user.User;
@Component
public interface AdminService {//<이건 타입>AdminService ad = new ASI

	public void register(Admin admin);

	public List<Admin> findAll();
	
	public Admin findOne(String employNumber);

	public void modify(Admin admin);

	public void remove(Admin admin);
	
	

}

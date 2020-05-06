package com.occamsrazor.web.user;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.occamsrazor.web.admin.Admin;
import com.occamsrazor.web.admin.AdminDao;
import com.occamsrazor.web.util.Data;
import javax.swing.JOptionPane;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.occamsrazor.web.util.Data;

@Service
public class UserServiceImpl implements UserService{
	@Autowired UserDao userDao;

	@Override
	public void register(User user) {
		userDao.insert(user);
	}

	@Override
	public List<User> findAll() {
		return userDao.selectAll();	
	
	}

	@Override
	public User findOne(String userid) {
		
		return userDao.selectOne(userid);
	}

	@Override
	public void modify(User user) {
			userDao.update(user);		
	}

	@Override
	public void remove(User user) {
			userDao.remove(user);		
	}

	/*
	 * @Override public User fineOne(String employNumber) { return
	 * userDao.selectOne(employNumber); }
	 * 
	 * @Override public void modify(User user) { userDao.update(user); }
	 * 
	 * @Override public void remove(User user) { userDao.delete(user); }
	 */



}

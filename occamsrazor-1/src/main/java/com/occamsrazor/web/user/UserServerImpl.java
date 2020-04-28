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

import javax.swing.JOptionPane;

import java.util.Set;

import org.springframework.stereotype.Service;

@Service
public class UserServerImpl implements UserServer{
	private Map<String, Object> map;
	public final static String FILE_PATH = "C:\\Users\\bit23\\Spring-workspace\\occamsrazor\\src\\main\\resources\\static\\user\\";
	public UserServerImpl() {
		map = new HashMap<>();
	}
	
	@Override
	public void add(User user) {
		map.put(user.getUserid(),user);
	}
	@Override
	public int count() {
		return map.size();
	}
	@Override
	public User login(User user) {
		User returnUser = null;
		if(map.containsKey(user.getUserid())) {
			System.out.println();
			User u = detail(user.getUserid());
			if(user.getPasswd().equals(u.getPasswd())) {
				return u;
			}
		}
		return returnUser;
	}
	@Override
	public User detail(String userid) {
		System.out.println("서비스 detail 들어온 id : "+userid);
		User t = (User)map.get(userid);
		System.out.println("=================>" +t);
		return t;
	}

	@Override
	public boolean update(User user) {
		map.replace(user.getUserid(),user);
		return true;
	}

	@Override
	public boolean remove(String userid) {
		map.remove(userid);
		return true;
	}
	
	@Override
	public List<User> list() {
		List<User> list = new ArrayList<>();
		@SuppressWarnings("rawtypes")
		Set set = map.entrySet();
		@SuppressWarnings("rawtypes")
		Iterator it = set.iterator();
		while(it.hasNext()) {
			@SuppressWarnings("unchecked")
			Map.Entry<String, User> e = (Entry<String, User>) it.next();
			list.add(e.getValue());
		}
		for(int i=0; i< list.size(); i++) {
			System.out.println(list.get(i));
		}
		return list;
	}
}

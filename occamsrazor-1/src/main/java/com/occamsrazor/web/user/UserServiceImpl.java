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
import com.occamsrazor.web.util.Data;
import javax.swing.JOptionPane;

import java.util.Set;

import org.springframework.stereotype.Service;

import com.occamsrazor.web.util.Data;

@Service
public class UserServiceImpl implements UserService{
	
	@Override
	public void add(User user) {
		try {
			File file = new File(Data.USER_PATH.toString()+Data.LIST+Data.CSV.toString());
			@SuppressWarnings("resource")
			BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));
			String message = user.toString();
			writer.write(message);
			System.out.println(message);
			writer.newLine();
			writer.flush();
			
		}catch(Exception e) {
			
			System.out.println(Data.FILE_READ_ERROR.to+Data.LIST+Data.CSV.toString());
		}
	}

	@Override
	public int count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public User login(User user) {
		User returnUser = null;
		return returnUser;
	}

	@Override
	public User detail(User user) {
		return null;
	}

	@Override
	public boolean update(User user) {
		return true;
	}

	@Override
	public boolean remove(String userid) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<User> list() {
		List<User> userList = new ArrayList();
		List<String> list = new ArrayList();
		try {
			File file = new File(FILE_PATH+Data.LIST+Data.CSV.toString());
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String message = "";
			while((message = reader.readLine()) != null){
				list.add(message);
			}
			reader.close();
		}catch(Exception e) {
			System.out.println("파일 읽기에서 에러 발생");
		}
		User u = null;
		for(int i=0;i<list.size();i++) {
			u = new User();
			String[] arr = list.get(i).split(",");
			u.setUserid(arr[0]);
			u.setPasswd(arr[1]);
			u.setName(arr[2]);
			u.setSsn(arr[3]);
			u.setAddr(arr[4]);
			userList.add(u);
		}
		return userList;
	}

	@Override
	public boolean idSearch(String userid) {
		boolean ok = true;
		List<User> list = list();
		for(int i=0; i<list.size(); i++) {
			if(userid.equals(list.get(i).getUserid())) {
				ok = false;
				break;
			}
		}
		return ok;
	}


}

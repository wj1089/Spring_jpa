package com.occamsrazor.web.user;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.occamsrazor.web.util.Data;
import com.occamsrazor.web.util.Messenger;

@Repository
public class UserDaoImpl implements UserDao{

	@Override
	public void insert(User user) {
		/*
		 * try { BufferedWriter writer = new BufferedWriter( new FileWriter(new
		 * File(Data.USERS.toString()); writer.write(user.toString()); writer.newLine();
		 * writer.flush(); } catch (Exception e) {
		 * System.out.println(Messenger.FILE_WRITE_ERROR); }
		 */
	}		

	
	@Override
	public List<User> selectAll() {
		List<User> list= new ArrayList<>();
		List<String> temp = new ArrayList<>();
		try {
			File file = new File(Data.USERS.toString());
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String message = "";
			while((message = reader.readLine())!=null) {
				temp.add(message);
			}
			reader.close();
		}catch(Exception e) {
			System.out.println(Data.USERS);
			System.out.println("에러");
		}
		User u = null;
		for(String s : temp) {
			u = new User();
			String[] arr = s.split(",");
			u.setUserid(arr[0]);
			u.setPasswd(arr[1]);
			u.setName(arr[2]);
			u.setSsn(arr[3]);
			u.setProfile(arr[4]);
			u.setEmail(arr[5]);
			u.setPhoneNumber(arr[6]);
			u.setRegisterDate(arr[7]);
			list.add(u);
			
		}
		return list;
	}

	
	@Override
	public User selectOne(String userid) {
		List<User> detailList = selectAll();
		User findedUser = null;
		for(User u : detailList) {
			if(userid.equals(u.getUserid())) {
				findedUser=u;
				break;
			}
		}
		return findedUser;
	}

	@Override
	public void update(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove(User user) {
		// TODO Auto-generated method stub
		
	}
	
		

}

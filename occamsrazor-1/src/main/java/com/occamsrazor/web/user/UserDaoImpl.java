package com.occamsrazor.web.user;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.occamsrazor.web.util.Data;

@Repository
public class UserDaoImpl implements UserDao{

	/*
	 * @Override public void insert(User user) { try { BufferedWriter writer = new
	 * BufferedWriter( new FileWriter( new
	 * File(Data.USER_PATH.toString()+Data.LIST+Data.CSV),true));
	 * writer.write(user.toString()); writer.newLine(); writer.flush();
	 * 
	 * }catch(Exception e) {
	 * 
	 * } }
	 */

	@Override
	public List<User> selectAll() {
		List<User> list= new ArrayList<>();
		List<String> temp = new ArrayList<>();
		try {
			File file = new File(Data.USER_PATH+"user_list.csv");
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String message = "";
			while((message = reader.readLine())!=null) {
				temp.add(message);
			}
			reader.close();
					
		}catch(Exception e) {
			System.out.println("에러");
		}
		User u = null;
		for(int i=0;i<temp.size();i++) {
			u=new User();
			String[] arr = temp.get(i).split(",");
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
		
	/*
	 * @Override public User selectOne(String employNumber) { return null; }
	 * 
	 * @Override public void update(User user) { try {
	 * 
	 * }catch(Exception e) {
	 * 
	 * } }
	 * 
	 * @Override public void delete(User user) { try {
	 * 
	 * }catch(Exception e) {
	 * 
	 * } }
	 */

}

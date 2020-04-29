package com.occamsrazor.web.admin;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.occamsrazor.web.user.User;
import com.occamsrazor.web.util.Data;
import com.occamsrazor.web.util.Messenger;

@Service
public class AdminServiceImpl implements AdminService{
	

	@Override
	public void add(Admin admin) {
		try {
			File file = new File(Data.ADMIN_PATH.toString()+Data.LIST+Data.CSV.toString());
			@SuppressWarnings("resource")
			BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));
			String message = admin.toString();
			writer.write(message);
			System.out.println(message);
			writer.newLine();
			writer.flush();
			
		}catch(Exception e) {
			System.out.println(Messenger.FILE_WRITE_ERROR.toString());
		}
	}
	@Override
	public int count() {
		return 0;
	}

	@Override
	public Admin login(Admin admin) {
		Admin returnAdmin = null;
		return returnAdmin;
	}
	@Override
	public Admin detail(Admin admin) {
		return null;
	}

	@Override
	public boolean update(Admin admin) {
		return true;
	}

	@Override
	public boolean remove(String userid) {
		return false;
	}
	@Override
	public List<Admin> list() {
		List<Admin> adminList = new ArrayList();
		List<Admin> list = new ArrayList();
		try {
			File file = new File(Data.ADMIN_PATH.toString()+Data.LIST+Data.CSV.toString());
			BufferedReader reader = new BufferedReader(new FileReader(file));
		}catch(Exception e) {
			System.out.println(Messenger.FILE_READ_ERROR.toString());
		}
		Admin ad = null;
		for(int i=0;i<list.size();i++) {
				ad = new Admin();
				String[] arr = list.get(i).split(",");
				ad.setEmployNumber(arr[0]);
				ad.setPasswd(arr[1]);
				ad.setName(arr[2]);
				ad.setPosition(arr[3]);
				ad.setEmail(arr[4]);
				ad.setPhoneNumber(arr[5]);
				ad.setRegisterDate(arr[6]);
				adminList.add(ad);
			}
			return adminList;
		}
		}
		return null;
	}
}

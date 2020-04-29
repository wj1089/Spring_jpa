package com.occamsrazor.web.admin;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.occamsrazor.web.user.User;
import com.occamsrazor.web.util.Data;
import com.occamsrazor.web.util.Messenger;

@Service
public class AdminServiceImpl implements AdminService{
	@Autowired AdminDao adminDao;
/*employNumber, passwd, <name, position>, profile,<email, phoneNumber>, registerDate;*/
	@Override
	public void register(Admin admin) {
		admin.setEmployNumber(createEmployNumber());//4자리 랜덤
		admin.setPasswd("1");
		admin.setRegisterDate(createCurrentDate()); //찾는것, 자바에서 현재 날짜...로직?
		adminDao.insert(admin);
	}

	private String createCurrentDate() {
        return new SimpleDateFormat("yyyy-MM-dd").format(new Date());
	}

	private String createEmployNumber() {
		String startNum ="";
		for(int i=0;i<4;i++) {
			startNum += String.valueOf((int)(Math.random()*10));
		}
		return startNum;
	}
	@Override
	public List<Admin> findAll() {
		return adminDao.selectAll();
	}
	@Override
	public Admin findOne(String employNumber) {
		return adminDao.selectOne(employNumber);
	}
	@Override
	public void modify(Admin admin) {
		adminDao.update(admin);
	}
	@Override
	public void remove(Admin admin) {
		adminDao.delete(admin);
	}
}

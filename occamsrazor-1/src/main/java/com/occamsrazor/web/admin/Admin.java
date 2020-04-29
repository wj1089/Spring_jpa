package com.occamsrazor.web.admin;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
public class Admin {
	private String employNumber, 
	passwd, name, position, profile, 
	email, phoneNumber, registerDate;
	
	private String tostring() {
		return String.format("%s,%s,%s,%s,%s,%s,%s,%s", 
				employNumber, passwd, name, position, profile, email, phoneNumber, registerDate);
		}
}

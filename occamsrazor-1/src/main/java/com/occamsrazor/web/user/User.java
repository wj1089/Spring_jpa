package com.occamsrazor.web.user;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Data
public class User {
	private String userid,passwd,name,ssn, addr, profile, email, phoneNumber, registerDate;
	
}

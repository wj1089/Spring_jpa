package com.occamsrazor.web.user;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.message.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.occamsrazor.web.admin.Admin;
import com.occamsrazor.web.util.Messenger;
// userid,passwd,name,ssn, addr

@RestController
@RequestMapping("/users")
public class UserController {
	@PostMapping("")
	public Messenger post(@RequestBody User user) {
		return Messenger.SUCCESS;
	}
	@GetMapping("")
	public List<User> list(){
		return null;
	}
	@GetMapping("/{userid}")
	public User detail() {
		return null;
	}
	@PutMapping("/{userid}")
	public Messenger put(@RequestBody User user) {
		return Messenger.SUCCESS;
	}
	@DeleteMapping("/{userid}")
	public Messenger delete(@RequestBody User user) {
		return Messenger.SUCCESS;
	}
}
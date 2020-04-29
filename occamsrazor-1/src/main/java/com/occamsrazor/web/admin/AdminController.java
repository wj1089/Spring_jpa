package com.occamsrazor.web.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.occamsrazor.web.util.Messenger;
//전형적인 restful방식, 다똑같을수있을때는 앞에@~~타입으로 구별한다.
	@RestController
	@RequestMapping("/admins")
	public class AdminController {
		
		@Autowired AdminService adminService;//속성
											 //이하래 전부 기능
		@PostMapping("")
		public Messenger post(@RequestBody Admin admin) {
			System.out.println("1. AdminController post");
			adminService.register(admin);
			System.out.println("5. AdminController post"+admin);
			return Messenger.SUCCESS;
		}
		@GetMapping("")
		public List<Admin> list(){
			return adminService.findAll();
		}
		@GetMapping("/{employNumber}")
		public Admin detail(@PathVariable String employNumber) {
			return adminService.findOne(employNumber);
		}
		@PutMapping("/{employNumber}")
		public Messenger put(@RequestBody Admin admin) {
			adminService.modify(admin);
			return Messenger.SUCCESS;
		}
		@DeleteMapping("/{employNumber}")
		public Messenger delete(@RequestBody Admin admin) {
			adminService.remove(admin);
			return Messenger.SUCCESS;
		}
}

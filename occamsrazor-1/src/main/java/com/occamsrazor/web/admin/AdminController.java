package com.occamsrazor.web.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.occamsrazor.web.util.Messenger;

	@RestController
	@RequestMapping("/member")
	public class AdminController {
		@Autowired AdminService memberService;
		//@service와 연결을위해 new대신에서  @Autowired를 쓰인다
		
		@PostMapping("/join")
		public Messenger add(@RequestBody Admin member) {
			int current = memberService.count();
			String s = "";
			memberService.add(member);
			return (memberService.count()==(current+1))?Messenger.SUCCESS:Messenger.FAIL;
		}
		
		@PostMapping("/login")
		public Messenger login(@RequestBody Admin member) {
			return (memberService.login(member))?Messenger.SUCCESS:Messenger.FAIL;
		}
		@GetMapping("/list")
		public Admin[] list(@RequestBody String name) {
			Admin[] returMember = new Admin[5];
			return returMember;
		}
		@GetMapping("/detail")
		public Admin detail(@RequestBody String name) {
			Admin returnMember = new Admin();
			return returnMember;
		}
		@GetMapping("/count")
		public int count(@RequestBody String name) {
			int count = 0;
			return count;
		}
		@GetMapping("/update")
		public Admin update(@RequestBody Admin member) {
			Admin returnMember = new Admin();
			return returnMember;
		}
		@GetMapping("/delete")
		public Admin delete(@RequestBody Admin member) {
			Admin returnMember = new Admin();
			return returnMember;
		}
}

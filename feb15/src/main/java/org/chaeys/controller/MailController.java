package org.chaeys.controller;

import org.apache.commons.mail.EmailException;
import org.chaeys.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

//2024-02-23 요구사항 확인 psd

@Controller
public class MailController {
	
	@Autowired
	private MailService mailService;
	
	//제작순서
	//menu에다가 추가 -> Controller -> jsp -> 화면구성 -> service
	@GetMapping("/mail")
	public String mail() {
		//로그인한 사용자만 접근가능합니다.
		return "mail";
	}
	
	//jsp -> Controller -> Service 메일 발송
	@PostMapping("/mail")
	public String mail(@RequestParam("email") String email, 
				@RequestParam("title") String title, @RequestParam("content") String content) throws EmailException {
		System.out.println("email : " + email);
		System.out.println("title : " + title);
		System.out.println("content : " + content);
		
		mailService.sendTextMail(email, title, content);
		mailService.sendHTMLMail(email, title, content);
		
		return "redirect:/mail";
	}
}

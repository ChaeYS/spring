package org.chaeys.controller;

import org.apache.ibatis.annotations.Param;
import org.chaeys.dto.BoardDTO;
import org.chaeys.service.BoardService;
import org.chaeys.service.RestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestFullController {
	
	@Autowired
	private BoardService boardService;
	
	@Autowired
	private RestService restService;

	@PostMapping("/restDetail")
	public BoardDTO restDetail(@Param("no") int no) {
		BoardDTO detail = boardService.detail(no);
		return detail;
	}
	
	@PostMapping("/emailAuth")
	public int emailAuth() {
		return restService.sendEmail();
	}
}

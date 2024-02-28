package org.chaeys.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ErrorController {

	//  /error
	@GetMapping("/error")
	public String error() {
		return "error/error"; //  /WEB-INF/views/error/error.jsps
	}
}

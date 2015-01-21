package com.lakmal.jba.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

	@RequestMapping("/index")
	public String index() {
		System.out.println("in index controller....");
		return "/WEB-INF/jsp/index.jsp";
	}
}

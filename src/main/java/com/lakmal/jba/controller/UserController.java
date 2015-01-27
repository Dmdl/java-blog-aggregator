package com.lakmal.jba.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lakmal.jba.entity.Blog;
import com.lakmal.jba.entity.User;
import com.lakmal.jba.service.BlogService;
import com.lakmal.jba.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	@Autowired
	private BlogService blogService;

	@ModelAttribute("user")
	public User construct() {
		return new User();
	}

	@ModelAttribute("blog")
	public Blog constructBlog() {
		return new Blog();
	}

	@RequestMapping("/users")
	public String users(Model model) {
		model.addAttribute("users", userService.findAll());
		return "users";
	}

	@RequestMapping("/users/{id}")
	public String details(Model model, @PathVariable int id) {
		model.addAttribute("user", userService.findOneWithBlog(id));
		return "user-detail";
	}

	@RequestMapping("/register")
	public String showRegister() {
		System.out.println("register get...");
		return "user-register";
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String doRegister(@ModelAttribute("user") User user) {
		System.out.println("register post...");
		userService.save(user);
		return "redirect:/register.html?success=true";
	}

	@RequestMapping("/account")
	public String account(Model model, Principal priciple) {
		String name = priciple.getName();
		System.out.println("Name::::::::::::: " + name);
		model.addAttribute("user", userService.findOneWithBlog(name));
		return "user-detail";
	}

	@RequestMapping(value = "/account", method = RequestMethod.POST)
	public String doAddBlog(@ModelAttribute("blog") Blog blog,
			Principal priciple) {
		String name = priciple.getName();
		blogService.save(blog, name);
		return "redirect:/account.html";
	}

	@RequestMapping("/blog/remove/{id}")
	public String removeBlog(@PathVariable int id) {
		blogService.delete(id);
		return "redirect:/account.html";
	}
}

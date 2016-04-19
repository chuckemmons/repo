package com.cee.webapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cee.webapp.model.User;
import com.cee.webapp.service.UserService;

@Controller
public class UserAdminController {	
	@Autowired
	UserService service;
	
	
	@RequestMapping(path = "/admin/user/list", method = RequestMethod.GET)
	public ModelAndView users(Model model) {
		
		Iterable<User> users = service.findAll();
		
		return new ModelAndView("admin/user/list", "users", users);
	}
	
	@RequestMapping(path = "/admin/user/add", method = RequestMethod.GET)
	public ModelAndView addUser(Model model) {		
				
		return new ModelAndView("admin/user/form", "user", new User());
	}
	
	@RequestMapping(path = "/admin/user/submit", method = RequestMethod.POST)
	public ModelAndView submit(
			@Validated @ModelAttribute("user") User user,
			BindingResult result, ModelMap model) {
		// validate...
		if (result.hasErrors()) {
			return new ModelAndView("admin/user/form", "user", user);
		}
		service.save(user);
		
		Iterable<User> users = service.findAll();
		

		return new ModelAndView("admin/user/list", "users", users);
	}
}

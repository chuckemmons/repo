package com.cee.webapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cee.webapp.model.User;
import com.cee.webapp.service.UserService;

@Controller
public class UserAdminController {	
	@Autowired
	UserService service;
	
	
	@RequestMapping(path = "/admin/users", method = RequestMethod.GET)
	public ModelAndView adminUsers(Model model) {
		
		Iterable<User> users = service.findAll();
		
		return new ModelAndView("admin/users", "users", users);
	}
}

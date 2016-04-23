package com.cee.webapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import com.cee.webapp.model.User;
import com.cee.webapp.service.UserService;

@Controller
@SessionAttributes("userSession")
public class LoginController {
	
	@Autowired
	UserService userService;
	
	
	@RequestMapping(path = "/login", method = RequestMethod.GET)
	public ModelAndView login(ModelAndView model) {
		return new ModelAndView("login/form", "user", new User());
	}
	
	@RequestMapping(path = "/logout", method = RequestMethod.GET)
	public ModelAndView logout(@ModelAttribute User user, WebRequest request, SessionStatus status) {
	    request.removeAttribute("userSession", WebRequest.SCOPE_SESSION);
		//status.setComplete();
	    ModelAndView modelAndView = new ModelAndView("home");
	    modelAndView.getModelMap().remove("userSession");
		return modelAndView;
	}
	
	
	@RequestMapping(path = "/login", method = RequestMethod.POST)
	public ModelAndView submit(@Validated @ModelAttribute("user") User user,
			BindingResult result, ModelMap model) {
		// validate...		
		// TODO: need to add code to check if a user is on this session...
		if (result.hasErrors()) {
			return new ModelAndView("login/form", "user", user);
		}
				
		if (! userService.authenticate(user)) {
			user = new User();
			model.addAttribute("error", "Invalid email address or password.");
			return new ModelAndView("login/form", "user", user);
		}
		
		ModelAndView modelAndView = new ModelAndView("home");
		modelAndView.addObject("userSession", user);
		return modelAndView;
	}
	
}

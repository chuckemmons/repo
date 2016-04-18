package com.cee.webapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cee.webapp.model.User;

@Controller
public class LoginController {
	@RequestMapping(path = "/login", method = RequestMethod.GET)
	public ModelAndView contact(ModelAndView model) {
		return new ModelAndView("login/form", "user", new User());
	}
	
	//@RequestMapping(path = "/login", method = RequestMethod.POST)
	/*public ModelAndView submit(
			@Validated @ModelAttribute("contact") Contact contact,
			BindingResult result, ModelMap model) {
		// validate...
		if (result.hasErrors()) {
			return new ModelAndView("contact/form", "contact", contact);
		}

		if (contact.notSpam()) {
			// send...
			emailService.sendMailFrom(contact);
			// return
			LOG.info("contact message sent..");

		}

		return new ModelAndView("contact/sent", "contact", contact);
	}*/
}

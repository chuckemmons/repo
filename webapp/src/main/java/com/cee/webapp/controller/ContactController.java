package com.cee.webapp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

import com.cee.webapp.model.Contact;
import com.cee.webapp.service.EmailService;

@Controller
public class ContactController {
	private static final Logger LOG = LoggerFactory
			.getLogger(ContactController.class);

	@Autowired
	EmailService emailService;

	@RequestMapping(path = "/contact", method = RequestMethod.GET)
	public ModelAndView contact(Model model) {
		return new ModelAndView("contact/form", "contact", new Contact());
	}

	@RequestMapping(path = "/contact", method = RequestMethod.POST)
	public ModelAndView submit(
			@Validated @ModelAttribute("contact") Contact contact,
			BindingResult result, ModelMap model) {
		
		if (result.hasErrors()) {
			return new ModelAndView("contact/form", "contact", contact);
		}

		if (contact.notSpam()) {
			emailService.sendMailFrom(contact);
			LOG.info("contact message sent..");
		}

		return new ModelAndView("contact/sent", "contact", contact);
	}

}

package com.cee.webapp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

@Controller
public class ContactController {
	private static final Logger LOG = LoggerFactory
			.getLogger(ContactController.class);

	@RequestMapping(path = "/contact", method = RequestMethod.GET)
	public ModelAndView contact(Model model) {
		Contact contact = new Contact("Fred", "Bear", "fred.bear@company.com",
				"1-800-frd-bear",
				"This is an example of a message from Fred Bear.");
		return new ModelAndView("contact/form", "contact", contact);
	}

	@RequestMapping(path = "contact/submit", method = RequestMethod.POST)
	public ModelAndView submit(
			@Validated @ModelAttribute("contact") Contact contact,
			BindingResult result, ModelMap model) {

		LOG.info("contact message sent..");
		return new ModelAndView("contact/sent", "contact", contact);
	}
}

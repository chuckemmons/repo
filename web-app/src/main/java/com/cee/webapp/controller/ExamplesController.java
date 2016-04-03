package com.cee.webapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ExamplesController {

	@RequestMapping(path = "/examples/{example}", method = RequestMethod.GET)
	public String gotoExample(@PathVariable String example, Model model) {

		return "examples/" + example;
	}

}

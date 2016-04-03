package com.cee.webapp.controller;

import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author chuck
 *
 */

@Controller
@RequestMapping(value = "/")
public class HomeController {

	@RequestMapping(method = RequestMethod.GET)
	public String home(ModelAndView model) throws IOException {
		// model.addAttribute("firstPageMessage", "This is the first page");
		return "home";
	}
}

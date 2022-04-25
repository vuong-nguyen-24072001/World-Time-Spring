package com.nguyenvuong.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.nguyenvuong.model.NewModel;

@Controller(value = "homeControllerOfAdmin")
@CrossOrigin(origins = "*", allowedHeaders = "*", allowCredentials = "false")
public class HomeController {
	
	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public ModelAndView homePage(@ModelAttribute(name = "model") NewModel model) {
		ModelAndView mav = new ModelAndView("admin/home");
		return mav;
	}

}

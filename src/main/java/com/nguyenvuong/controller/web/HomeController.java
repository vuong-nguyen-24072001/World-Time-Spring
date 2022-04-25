package com.nguyenvuong.controller.web;

import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.nguyenvuong.dto.NewDTO;
import com.nguyenvuong.service.INewService;

@Controller(value = "homeControllerOfWeb")
@CrossOrigin(origins = "*", allowedHeaders = "*", allowCredentials = "false")
public class HomeController {

	@Autowired
	private INewService newService;
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public ModelAndView homePage() {
		NewDTO model = new NewDTO();
		List<NewDTO> newDtos = newService.findAll();
		model.setListResult(newDtos);
		ModelAndView mav = new ModelAndView("web/home");
		mav.addObject("model", model);
		getTop3News(mav);
		return mav;
	}
	
	@RequestMapping(value = "/home/{categoryCode}", method = RequestMethod.GET)
	public ModelAndView categoryPage(@PathVariable String categoryCode) {
		NewDTO model = new NewDTO();
		model.setListResult(newService.findAllByCode(categoryCode));
		ModelAndView mav = new ModelAndView("web/home");
		mav.addObject("model", model);
		getTop3News(mav);
		return mav;
	}
	
	@RequestMapping(value = "/home/news/{id}", method = RequestMethod.GET)
	public ModelAndView detailNewsPage(@PathVariable Long id) {
		ModelAndView mav = new ModelAndView("web/detailNews");
		mav.addObject("model", newService.findById(id));
		getTop3News(mav);
		return mav;
	}
	
	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public ModelAndView signUp() {
		ModelAndView mav = new ModelAndView("signup");
		return mav;
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView loginPage() {
		ModelAndView mav = new ModelAndView("login");
		return mav;
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public ModelAndView logout(HttpServletRequest request, HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		return new ModelAndView("redirect:/home");
	}
	
	@RequestMapping(value= "/accessDenied", method = RequestMethod.GET)
	public ModelAndView accessDenied() {
		return new ModelAndView("redirect:/login?accessDenied");
	}
	
	private void getTop3News(ModelAndView mav) {
		NewDTO modelNewsTop3 = new NewDTO();
		modelNewsTop3.setListResult(newService.findTop3().stream().limit(3).collect(Collectors.toList()));
		mav.addObject("modelNewsTop3", modelNewsTop3);
	}
	
}

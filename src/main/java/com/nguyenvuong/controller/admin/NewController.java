package com.nguyenvuong.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.nguyenvuong.dto.NewDTO;
import com.nguyenvuong.service.ICategoryService;
import com.nguyenvuong.service.INewService;

@Controller(value = "newControllerOfAdmin")
@CrossOrigin(origins = "*", allowedHeaders = "*", allowCredentials = "false")
public class NewController {
	
	@Autowired
	private INewService newService;
	
	@Autowired
	private ICategoryService categoryService;
	
	@RequestMapping(value = "/admin/new/list", method = RequestMethod.GET)
	public ModelAndView showNews() {
		NewDTO model = new NewDTO();
		model.setListResult(newService.findAll());
		ModelAndView mav = new ModelAndView("admin/new/list");
		mav.addObject("model", model);
		return mav;
	}
	
	@RequestMapping(value = "/admin/new/edit", method = RequestMethod.GET)
	public ModelAndView editNew(@RequestParam(value = "id", required = false) Long id) {
		ModelAndView mav = new ModelAndView("/admin/new/edit");
		NewDTO model = new NewDTO();
		if (id != null) {
			model = newService.findById(id);
		}
		mav.addObject("categories", categoryService.findAll());
		mav.addObject("model", model);
		return mav;
	}

}

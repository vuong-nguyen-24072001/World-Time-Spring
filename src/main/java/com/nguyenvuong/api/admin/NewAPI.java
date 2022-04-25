package com.nguyenvuong.api.admin;

import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.nguyenvuong.dto.NewDTO;
import com.nguyenvuong.service.INewService;
import com.nguyenvuong.util.UploadFileUtil;

@RestController(value = "newApiOfAdmin")
@CrossOrigin(origins = "*", allowedHeaders = "*", allowCredentials = "false")
public class NewAPI {

	@Autowired
	private INewService newService;

	@Autowired
	ServletContext servletContext;

	@PostMapping(value = "/api/new")
	public NewDTO createNew(@RequestParam("file") MultipartFile multipartFile, HttpServletRequest request) {
		NewDTO newDTO = new NewDTO();
		try {
			BeanUtils.populate(newDTO, request.getParameterMap());
			UploadFileUtil.uploadFile(multipartFile, request, "/thumbnail");
			newDTO.setThumbnail(multipartFile.getOriginalFilename());
		} catch (IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		}
		return newService.save(newDTO);
	}

	@DeleteMapping(value = "/api/new")
	public void deleteNew(@RequestBody long[] ids) {
		newService.delete(ids);
	}

}

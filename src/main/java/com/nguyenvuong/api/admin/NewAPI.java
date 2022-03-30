package com.nguyenvuong.api.admin;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.nguyenvuong.dto.NewDTO;
import com.nguyenvuong.service.INewService;
import com.nguyenvuong.util.UploadFileUtil;

@RestController(value = "newApiOfAdmin")
public class NewAPI {
	
	@Autowired
	private INewService newService;
	
	@Autowired
	ServletContext servletContext;

	@PostMapping(value = "/api/new")
	public NewDTO createNew(@RequestParam("file") MultipartFile multipartFile, 
							 @RequestParam("id") String id,
							 @RequestParam("title") String title,
							 @RequestParam("shortDescription") String shortDescription,
							 @RequestParam("content") String content,
							 @RequestParam("categoryCode") String categoryCode, HttpServletRequest request) {
		if (multipartFile != null) {
			NewDTO newDto = new NewDTO(null, title, multipartFile.getOriginalFilename(), shortDescription, content, categoryCode);
			String path = request.getSession().getServletContext().getRealPath("/") + "uploads";
			File uploadRootDir = new File(path);
        	if (!uploadRootDir.exists()) {
                uploadRootDir.mkdirs();
            }
	        try {
	        	String name = multipartFile.getOriginalFilename();
	        	File serverFile = new File(uploadRootDir.getAbsolutePath() + File.separator + name);
	        	BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
                stream.write(multipartFile.getBytes());
                stream.close();
                //
                System.out.println("Write file: " + serverFile);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
			return newService.save(newDto);
		} else {
			NewDTO newDto = new NewDTO(null, title, null, shortDescription, content, categoryCode);
			return newService.save(newDto);
		}
	}
	
	@PutMapping(value = "/api/new")
	public NewDTO updateNew(@RequestBody NewDTO newDto) {
		return newService.save(newDto);
	}
	
	@DeleteMapping(value = "/api/new")
	public void deleteNew(@RequestBody long[] ids) {
		newService.delete(ids);
	}
	
}

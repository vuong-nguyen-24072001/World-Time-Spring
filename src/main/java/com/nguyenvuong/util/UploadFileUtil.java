package com.nguyenvuong.util;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

public class UploadFileUtil {
	
	@Autowired
	static ServletContext servletContext;

	public static void uploadFile(MultipartFile file) {
		System.out.print(servletContext.getRealPath("/"));
		String fileName = servletContext.getRealPath("/") + "resources\\images\\" + file.getOriginalFilename();
        try {
            file.transferTo(new File(fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
	}

}

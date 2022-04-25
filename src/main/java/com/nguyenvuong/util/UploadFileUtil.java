package com.nguyenvuong.util;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

public class UploadFileUtil {
	
	@Autowired
	static ServletContext servletContext;

	public static void uploadFile(MultipartFile multipartFile, HttpServletRequest request, String directory) {
        try {
        	String path = request.getSession().getServletContext().getRealPath("/uploads" + directory);
			File uploadRootDir = new File(path);
			if (!uploadRootDir.exists()) {
				uploadRootDir.mkdirs();
			}
			String name = multipartFile.getOriginalFilename();
			File serverFile = new File(uploadRootDir.getAbsolutePath() + File.separator + name);
			BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
			stream.write(multipartFile.getBytes());
			stream.close();
			System.out.println("Write file: " + serverFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
	}

}

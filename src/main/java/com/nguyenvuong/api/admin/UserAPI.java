package com.nguyenvuong.api.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.nguyenvuong.dto.UserDTO;
import com.nguyenvuong.service.impl.UserService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*", allowCredentials = "false")
public class UserAPI {
	
	@Autowired
	private UserService userService;

	@PostMapping(value = "/api/user")
	public UserDTO createUser(@RequestBody UserDTO userDto) {
		return userService.save(userDto);
	}
	
	@GetMapping(value = "/api/user")
	public UserDTO getUser(@RequestParam(value = "username") String userName) {
		System.out.print(userName);
		return userService.findOneByUserName(userName);
	}
	
}

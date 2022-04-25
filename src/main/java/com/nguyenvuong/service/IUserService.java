package com.nguyenvuong.service;

import com.nguyenvuong.dto.UserDTO;

public interface IUserService {
	
	public UserDTO save(UserDTO user);
	
	public UserDTO findOneByUserName(String userName);
}

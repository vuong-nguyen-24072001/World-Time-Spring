package com.nguyenvuong.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nguyenvuong.converter.RoleConverter;
import com.nguyenvuong.converter.UserConverter;
import com.nguyenvuong.dto.UserDTO;
import com.nguyenvuong.entity.RoleEntity;
import com.nguyenvuong.entity.UserEntity;
import com.nguyenvuong.repository.RoleRepository;
import com.nguyenvuong.repository.UserRepository;
import com.nguyenvuong.service.IUserService;
import com.nguyenvuong.util.SecurityUtil;

@Service
public class UserService implements IUserService {
	
	@Autowired
	private RoleConverter roleConverter;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private UserConverter userConverter;

	@Override
	public UserDTO save(UserDTO user) {
		UserEntity userEntity = userConverter.toEntity(user);
		List<RoleEntity> rolesEntity = new ArrayList<>();
		RoleEntity roleEntity = roleRepository.findOneByCode("USER");
		rolesEntity.add(roleEntity);
		userEntity.setRoles(rolesEntity);
		userEntity.setPassword(SecurityUtil.EncodePassword(userEntity.getPassword()));
		userEntity.setStatus(1);
		userRepository.save(userEntity);
		UserDTO userDto = userConverter.toDto(userEntity);
		roleConverter.addRoleToDto(userDto, rolesEntity);
		return userDto;
	}

	@Override
	public UserDTO findOneByUserName(String userName) {
		UserEntity userEntity = userRepository.findOneByUserName(userName);
		if (userEntity == null) {
			return null;
		}
		UserDTO userDto = userConverter.toDto(userEntity);
		roleConverter.addRoleToDto(userDto, userEntity.getRoles());
		return userDto;
	}

}

package com.nguyenvuong.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nguyenvuong.dto.RoleDTO;
import com.nguyenvuong.dto.UserDTO;
import com.nguyenvuong.entity.UserEntity;

@Component
public class UserConverter {
	
	@Autowired
	private RoleConverter roleConverter;
	
	public UserDTO toDto(UserEntity userEntity) {
		UserDTO userDto = new UserDTO();
		List<RoleDTO> roles = new ArrayList<>();
		userEntity.getRoles().stream().forEach(role -> roles.add(roleConverter.toDto(role)));
		BeanUtils.copyProperties(userEntity, userDto, "roles");
		return userDto;
	}
	
	public UserEntity toEntity(UserDTO userDto) {
		UserEntity userEntity = new UserEntity();
		BeanUtils.copyProperties(userDto, userEntity, "roles");
		return userEntity;
	}

}

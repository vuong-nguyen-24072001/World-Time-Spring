package com.nguyenvuong.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.nguyenvuong.dto.RoleDTO;
import com.nguyenvuong.dto.UserDTO;
import com.nguyenvuong.entity.RoleEntity;

@Component
public class RoleConverter {
	
	public RoleDTO toDto(RoleEntity roleEntity) {
		RoleDTO roleDto = new RoleDTO();
		BeanUtils.copyProperties(roleEntity, roleDto, "users");
		return roleDto;
	}
	
	public void addRoleToDto(UserDTO userDto, List<RoleEntity> rolesEntity) {
		List<RoleDTO> rolesDto = new ArrayList<>();
		rolesEntity.stream().forEach(role -> rolesDto.add(toDto(role)));
		userDto.setRoles(rolesDto);
	}
}

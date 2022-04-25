package com.nguyenvuong.converter;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.nguyenvuong.dto.NewDTO;
import com.nguyenvuong.entity.NewEntity;

@Component
public class NewConverter {
	
	public NewEntity toEntity(NewDTO newDto) {
		NewEntity newEntity = new NewEntity();
		BeanUtils.copyProperties(newDto, newEntity);
		return newEntity;
	}
	
	public NewDTO toDto(NewEntity newEntity) {
		NewDTO newDto = new NewDTO();
		BeanUtils.copyProperties(newEntity, newDto);
		return newDto;
	}
	
}

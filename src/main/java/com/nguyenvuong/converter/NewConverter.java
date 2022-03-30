package com.nguyenvuong.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.nguyenvuong.dto.NewDTO;
import com.nguyenvuong.entity.NewEntity;

@Component
public class NewConverter {
	
	public List<NewDTO> toDto(List<NewEntity> newEntities) {
		List<NewDTO> newDtos = new ArrayList<>();
		newEntities.stream().map((NewEntity newEntity) -> 
			new NewDTO(newEntity.getId(), newEntity.getTitle(), newEntity.getThumbnail(), newEntity.getShortDescription(), newEntity.getContent(), newEntity.getCategory().getCode())
		).forEach((newDto) -> {
			newDtos.add(newDto);
		});
		return newDtos;
	}
	
	public List<NewEntity> toEntity(List<NewDTO> newDtos) {
		List<NewEntity> newEntities = new ArrayList<>();
		newDtos.stream().map((NewDTO newDto) -> new NewEntity(newDto.getTitle(), newDto.getThumbnail(), newDto.getShortDescription(), newDto.getContent())
		).forEach(newEntity -> {
			newEntities.add(newEntity);
		});
		return newEntities;
	}
	
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

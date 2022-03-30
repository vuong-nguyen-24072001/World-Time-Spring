package com.nguyenvuong.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nguyenvuong.converter.NewConverter;
import com.nguyenvuong.dto.NewDTO;
import com.nguyenvuong.entity.CategoryEntity;
import com.nguyenvuong.entity.NewEntity;
import com.nguyenvuong.repository.CategoryRepository;
import com.nguyenvuong.repository.NewRepository;
import com.nguyenvuong.service.INewService;

@Service
public class NewService implements INewService {
	
	@Autowired
	private NewRepository newRepository;
	
	@Autowired
	private NewConverter newConverter;
	
	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public List<NewDTO> findAll() {
		List<NewEntity> newEntities = newRepository.findAll();
		return newConverter.toDto(newEntities);
	}

	@Override
	public NewDTO findById(Long id) {
		List<NewEntity> newEntities = new ArrayList<>();
		newEntities.add(newRepository.findOne(id));
		return newConverter.toDto(newEntities).get(0);
	}

//	@Override
//	@Transactional
//	public NewDTO save(NewDTO newDto) {
//		List<NewDTO> newDtos = new ArrayList<>();
//		newDtos.add(newDto);
//		CategoryEntity category =  categoryRepository.findOneByCode(newDto.getCategoryCode());
//		NewEntity newEntity = newConverter.toEntity(newDtos).get(0);
//		newEntity.setCategory(category);
//		if (newDto.getId() != null) {
//			newEntity.setId(newDto);
//		}
//		List<NewEntity> newEntities = new ArrayList<>();
//		newConverter.toEntity(newDto);
//		newEntities.add(newRepository.save(newEntity));
//		return newConverter.toDto(newEntities).get(0);
//	}
	
	@Override
	@Transactional
	public NewDTO save(NewDTO newDto) {
		CategoryEntity category =  categoryRepository.findOneByCode(newDto.getCategoryCode());
		NewEntity newEntity = newConverter.toEntity(newDto);
		newEntity.setCategory(category);
		if (newDto.getId() != null) {
			newEntity.setId(newDto);
		}
		// return newConverter.toDto(newRepository.save(newEntity));
		return newConverter.toDto(newEntity);
	}

	@Override
	public void delete(long[] ids) {
		for (long id: ids) {
			newRepository.delete(id);
		}
	}

}

package com.nguyenvuong.service;

import java.util.List;

import com.nguyenvuong.dto.NewDTO;

public interface INewService {
	List<NewDTO> findAll();
	List<NewDTO> findAllByCode(String code);
	List<NewDTO> findTop3();
	NewDTO findById(Long id);
	NewDTO save(NewDTO newDto);
	void delete(long[] ids);
}

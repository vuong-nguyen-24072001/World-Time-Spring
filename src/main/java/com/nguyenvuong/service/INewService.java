package com.nguyenvuong.service;

import java.util.List;

import com.nguyenvuong.dto.NewDTO;
import org.springframework.data.domain.Pageable;

public interface INewService {
	List<NewDTO> findAll();
	List<NewDTO> findAllByCode(String code, Pageable pageable);
	List<NewDTO> findTop3();
	int getTotalItem();
	List<NewDTO> findAllPagable(Pageable pageable);
	NewDTO findById(Long id);
	NewDTO save(NewDTO newDto);
	void delete(long[] ids);
}

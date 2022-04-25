package com.nguyenvuong.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nguyenvuong.entity.NewEntity;

public interface NewRepository extends JpaRepository<NewEntity, Long> {
	
	List<NewEntity> findAllByOrderByCreatedDateDesc();
	
	List<NewEntity> findTop3ByOrderByCreatedDateDesc();
	
}

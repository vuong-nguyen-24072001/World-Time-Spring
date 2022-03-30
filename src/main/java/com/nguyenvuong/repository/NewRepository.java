package com.nguyenvuong.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nguyenvuong.entity.NewEntity;

public interface NewRepository extends JpaRepository<NewEntity, Long> {
	
}

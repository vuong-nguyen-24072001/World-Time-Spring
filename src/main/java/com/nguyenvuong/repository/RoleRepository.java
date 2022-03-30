package com.nguyenvuong.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nguyenvuong.entity.RoleEntity;

public interface RoleRepository extends JpaRepository<RoleEntity, Long> {
	
	RoleEntity findOneByCode(String code);

}

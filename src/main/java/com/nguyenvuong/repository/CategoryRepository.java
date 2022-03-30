package com.nguyenvuong.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nguyenvuong.entity.CategoryEntity;

public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {

	CategoryEntity findOneByCode(String categoryCode);

}

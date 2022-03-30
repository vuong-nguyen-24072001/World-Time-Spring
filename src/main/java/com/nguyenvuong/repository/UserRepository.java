package com.nguyenvuong.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nguyenvuong.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
	
	UserEntity findOneByUserNameAndStatus(String name, int status);
	
	UserEntity findOneByUserName(String userName);

}

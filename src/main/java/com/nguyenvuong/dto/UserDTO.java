package com.nguyenvuong.dto;import java.util.ArrayList;
import java.util.List;

public class UserDTO extends AbstractDTO<UserDTO> {

	private String userName;
	
	private String password;
	
	private String fullName;
	
	private Integer status;
	
	private List<RoleDTO> roles = new ArrayList<>();
	
	public UserDTO() {
		
	}

	public UserDTO(Long id, String userName, String password, String fullName, Integer status, List<RoleDTO> roles) {
		super.setId(id);
		this.userName = userName;
		this.password = password;
		this.fullName = fullName;
		this.status = status;
		this.roles = roles;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public List<RoleDTO> getRoles() {
		return roles;
	}

	public void setRoles(List<RoleDTO> roles) {
		this.roles = roles;
	}
	
}

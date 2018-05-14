package com.zubala.rafal.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="authorities")
public class UserRole {
	
    @Id
    @GeneratedValue
    private Long id;
	
    @ManyToOne
	@JoinColumn(name="user_id")
	private UserDO user;

	@Column(name="authority")
	private String role;

	public UserDO getUser() {
		return user;
	}

	public void setUser(UserDO user) {
		this.user = user;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
}

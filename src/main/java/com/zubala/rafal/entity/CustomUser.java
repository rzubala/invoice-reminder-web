package com.zubala.rafal.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class CustomUser {

    @Id
    @GeneratedValue
    private Long id;
    private String username;
    private String password;
    private Boolean enabled; 
    private String email;
   
	@OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
	private List<UserRole> roles;
	
    public Long getId() {
        return id;
    }

    public CustomUser setId(Long id) {
        this.id = id;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public CustomUser setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public CustomUser setPassword(String password) {
        this.password = password;
        return this;
    }

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public List<UserRole> getRoles() {
		return roles;
	}

	public void setRoles(List<UserRole> roles) {
		this.roles = roles;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
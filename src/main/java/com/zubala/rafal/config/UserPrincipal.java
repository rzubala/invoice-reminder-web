package com.zubala.rafal.config;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import com.zubala.rafal.entity.UserDO;

public class UserPrincipal extends User {

	private static final long serialVersionUID = 1L;
	
	private final UserDO user;

    public UserPrincipal(UserDO user, Collection<? extends GrantedAuthority> authorities) {
        super(user.getUsername(), user.getPassword(), authorities);
        this.user = user;
    }

    public UserPrincipal(UserDO user, boolean accountNonExpired, boolean credentialsNonExpired, boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities) {
        super(user.getUsername(), user.getPassword(), user.getEnabled(), accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
        this.user = user;
    }
    
    public UserDO getUser() {
        return this.user;
    }
}
package com.zubala.rafal.config;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import com.zubala.rafal.entity.CustomUser;

public class UserPrincipal extends User {

	private static final long serialVersionUID = 1L;
	
	private final CustomUser user;

    public UserPrincipal(CustomUser user, Collection<? extends GrantedAuthority> authorities) {
        super(user.getUsername(), user.getPassword(), authorities);
        this.user = user;
    }

    public UserPrincipal(CustomUser user, boolean accountNonExpired, boolean credentialsNonExpired, boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities) {
        super(user.getUsername(), user.getPassword(), user.getEnabled(), accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
        this.user = user;
    }
    
    public CustomUser getUser() {
        return this.user;
    }
}
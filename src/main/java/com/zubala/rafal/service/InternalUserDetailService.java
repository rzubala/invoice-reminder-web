package com.zubala.rafal.service;

import java.util.LinkedList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.zubala.rafal.config.UserPrincipal;
import com.zubala.rafal.dao.UserDAO;
import com.zubala.rafal.entity.CustomUser;
import com.zubala.rafal.entity.UserRole;

@Service
@Transactional
public class InternalUserDetailService implements UserDetailsService {

	public final static String DEMO_LOGIN = "demo"; 
	
	@Autowired
	private UserDAO userRepository;

    @Override public UserPrincipal loadUserByUsername(String username) throws UsernameNotFoundException {
        CustomUser user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("Unknown User");
        }
        boolean accountNonExpired = true;
        boolean credentialsNotExpired = true;
        boolean accountNonLocked = true;
        UserPrincipal principal = new UserPrincipal(user, accountNonExpired, credentialsNotExpired, accountNonLocked, getAuthorities(user.getRoles()));
        return principal;
    }

    private List<GrantedAuthority> getAuthorities(List<UserRole> roles) {
    	List<GrantedAuthority> result = new LinkedList<>();
    	for (UserRole ur : roles) {
    		result.add(new SimpleGrantedAuthority(ur.getRole()));
    	}
    	return result;
    }
}
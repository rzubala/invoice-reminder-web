package com.zubala.rafal.dao;

import com.zubala.rafal.entity.CustomUser;

public interface UserDAO {
	 CustomUser findByUsername(String username);
}

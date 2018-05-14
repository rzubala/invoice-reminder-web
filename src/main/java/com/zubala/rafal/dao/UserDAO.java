package com.zubala.rafal.dao;

import com.zubala.rafal.entity.UserDO;

public interface UserDAO {
	 UserDO findByUsername(String username);
}

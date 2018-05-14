package com.zubala.rafal.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zubala.rafal.entity.UserDO;

@Repository
public class UserDAOImpl implements UserDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public UserDO findByUsername(String username) {
		Session currentSession = sessionFactory.getCurrentSession();				
		Query<UserDO> query = currentSession.createQuery("from UserDO where username = :name", UserDO.class);
		query.setParameter("name", username);
		query.setMaxResults(1);
		List<UserDO> users = query.getResultList();
		if (users == null || users.isEmpty()) {
			return null;
		}
		UserDO user = users.get(0);
		return user;
	}
}

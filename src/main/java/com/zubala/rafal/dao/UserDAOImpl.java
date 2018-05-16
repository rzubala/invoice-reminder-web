package com.zubala.rafal.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zubala.rafal.entity.CustomUser;

@Repository
public class UserDAOImpl implements UserDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public CustomUser findByUsername(String username) {
		Session currentSession = sessionFactory.getCurrentSession();				
		Query<CustomUser> query = currentSession.createQuery("from CustomUser where username = :name", CustomUser.class);
		query.setParameter("name", username);
		query.setMaxResults(1);
		List<CustomUser> users = query.getResultList();
		if (users == null || users.isEmpty()) {
			return null;
		}
		CustomUser user = users.get(0);
		return user;
	}
}

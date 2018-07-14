package com.zubala.rafal.dao;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zubala.rafal.entity.SettingsMail;

@Repository
public class SettingsDAOImpl implements SettingsDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public SettingsMail getSettingsMail() {
		Session currentSession = sessionFactory.getCurrentSession();				
		String queryStr = "select p from SettingsMail p where p.id = :id";
		TypedQuery<SettingsMail> query = currentSession.createQuery(queryStr, SettingsMail.class);
		query.setMaxResults(1);
		query.setParameter("id", SETTINGS_MAIL_ID);
		return query.getSingleResult();
		
	}
}

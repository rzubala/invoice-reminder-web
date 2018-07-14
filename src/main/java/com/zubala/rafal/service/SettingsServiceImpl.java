package com.zubala.rafal.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zubala.rafal.dao.SettingsDAO;
import com.zubala.rafal.entity.SettingsMail;

@Service
public class SettingsServiceImpl implements SettingsService {
	
	@Autowired
	private SettingsDAO settingsDAO;
	
	@Override
	@Transactional
	public SettingsMail getSettingsMail() {
		return settingsDAO.getSettingsMail();
	}
}

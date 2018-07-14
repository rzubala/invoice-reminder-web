package com.zubala.rafal.dao;

import com.zubala.rafal.entity.SettingsMail;

public interface SettingsDAO {
	public static final int SETTINGS_MAIL_ID = 1;

	SettingsMail getSettingsMail();
}

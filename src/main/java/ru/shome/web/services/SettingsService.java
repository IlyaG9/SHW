package ru.shome.web.services;

import java.util.List;

import ru.shome.web.beans.Setting;


public interface SettingsService {

	List<Setting> getAllSettings();
	
	void save(Setting setting);
}

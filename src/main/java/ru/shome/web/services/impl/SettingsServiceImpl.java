package ru.shome.web.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ru.shome.web.beans.Setting;
import ru.shome.web.dao.SettingsDao;
import ru.shome.web.services.SettingsService;

@Service
public class SettingsServiceImpl implements SettingsService {

	@Autowired
	SettingsDao settingsDao;

	@Override
	public List<Setting> getAllSettings() {
		List<Setting> all = settingsDao.getAll();
		for (Setting setting : all) {
			Object value = setting.getValue().getValue();
			if (value instanceof Boolean) {
				System.out.println("Boolean");
			} else if (value instanceof String) {
				System.out.println("String");
			} else if (value instanceof Integer) {
				System.out.println("Integer");
			} else if (value instanceof Double) {
				System.out.println("Double");
			}
		}
		return all;
	}

	@Override
	public void save(Setting setting) {
		String type = setting.getValue().getValue().getClass()
				.getCanonicalName();
		setting.setType(type);
		settingsDao.createOrUpdate(setting);

	}

}

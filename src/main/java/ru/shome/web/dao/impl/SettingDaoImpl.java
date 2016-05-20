package ru.shome.web.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import ru.shome.web.beans.Setting;
import ru.shome.web.dao.AbstractDao;
import ru.shome.web.dao.SettingsDao;

@Repository
public class SettingDaoImpl  extends AbstractDao<Setting> implements SettingsDao{



	public SettingDaoImpl() {
		super(Setting.class);
	}

	@Override
	public List<Setting> getWithPagination(int start, int max) {
		return getAll();
	}


}

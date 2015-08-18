package ru.shome.web.dao;

import java.util.List;


public interface BaseDao<T> {
	void save(Object objeect);
	List<T> getWithPagination(int start,int max);
}

package ru.shome.web.dao;

import java.util.List;


public interface BaseDao<T> {
	public void createOrUpdate(T object);
	List<T> getWithPagination(int start,int max);
	List<T> getAll();
	T getById(Long id);
}

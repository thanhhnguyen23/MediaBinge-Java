package com.revature.dao;

import java.util.List;

public interface DAO <T>{

	List<T> getAll();
	T add(T obj);
	T update(T updatedObj);
	boolean delete (int id);
}

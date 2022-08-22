package login.services;

import java.util.List;


import login.model.Entity_;

public interface CrudService <T extends Entity_> {
	
	
	T read(long id);
	
	T update(T e);
	
	boolean delete(long id);
	
	List<T> getAll();
	
	List<Long> getIds();

	T getById(long id);

	boolean getContainsKey(long id);
		
}
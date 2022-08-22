package login.services;

import java.util.ArrayList;
import java.util.List;

import login.model.Entity_;
import login.repository.EntityRepository;

public class EntityService<T extends Entity_, U extends EntityRepository<T>> implements CrudService<T> {
	protected U repository;

	

	public T read(long id) {
		// TODO Auto-generated method stub
		return repository.getById(id);
	}

	public T update(T e) {
		// TODO Auto-generated method stub
		return repository.updateEntity(e.getId(),e);

	}

	public boolean delete(long id) {
		// TODO Auto-generated method stub
		repository.removeEntity(id);

		return repository.getContainsKey(id);

	}

	public List<T> getAll() {
		// TODO Auto-generated method stub
		return new ArrayList<T>(repository.getAll());
	}

	public List<Long> getIds() {
		// TODO Auto-generated method stub
		return new ArrayList<Long>(repository.getAllIds());
	}

	public T getById(long id) {
		// TODO Auto-generated method stub
		return repository.getById(id);
	}

	public boolean getContainsKey(long id) {
		return repository.getContainsKey(id);
	}

	

	


}

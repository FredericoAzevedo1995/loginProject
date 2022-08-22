package login.repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import login.model.Entity_;

public class EntityRepository<T extends Entity_> {
	Map<Long, T> db = new HashMap<Long, T>();
	private long currentId = 1;
	

	// Add user
	public void addEntity(T entity) {
		entity.setId(currentId);
		currentId++;
		db.put(entity.getId(), entity);
	}

	// Remove user
	public void removeEntity(long id) {
		if (db.containsKey(id)) {
			db.remove(id);
		}
	}

	// Update user
	public T updateEntity(long id, T entity) {
		if (db.containsKey(id)) {
			db.put(id, entity);
		}
		return entity;
	}

	// Get All
	public Collection<T> getAll() {
		return db.values();
	}

	public T getById(long id) {
		// TODO Auto-generated method stub
		return db.get(id);
	}
	
	public boolean getContainsKey(long id) {
		return db.containsKey(id);
	}

	//
	public Collection<Long> getAllIds() {
		// TODO Auto-generated method stub
		return db.keySet();
	}
	
	
}

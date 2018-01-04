package com.mona.makeup.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public abstract class BaseDao {

	@PersistenceContext
	protected EntityManager em;

	protected EntityManager getEm() {
		return em;
	}

	protected void setEm(EntityManager em) {
		this.em = em;
	}

	/**
	 * Insert an entity to database
	 * @param obj The entity object
	 * @return True if save successfully, otherwise false.
	 */
	public <T> boolean save(T obj) {
		em.persist(obj);
		em.flush();
		return true;
	}
	
	/**
	 * Update entity object to database
	 * @param obj The entity object
	 * @return True if update successfully, otherwise false.
	 */
	public <T> boolean update(T obj) {
		em.merge(obj);
		em.flush();
		return true;
	}
	/**
	 * merge entity object to database
	 * @param obj The entity object
	 * @return True if update successfully, otherwise false.
	 */
	public <T> boolean merge(T obj) {
		em.merge(obj);
		em.flush();
		return true;
	}
	
	/**
	 * Get entity object by id
	 * @param clazz The class type of entity
	 * @param id The object id
	 * @return The entity object
	 */
	public <T> T get(Class<T> clazz, Object id) {
		T obj = em.find(clazz, id);
		return obj;
	}

	/**
	 * Delete entity object from database
	 * @param obj The entity object that will be deleted
	 * @return True if delete successfully, otherwise false.
	 */
	public <T> boolean delete(T obj) {
		obj = em.merge(obj);
		em.remove(obj);
		em.flush();
		return true;
	}

	/**
	 * Delete the list of entity objects
	 * @param entities
	 * @return True if delete successfully, otherwise false.
	 */
	public boolean batchDelete(List<?> entities){
		for(int i = 0; i<entities.size(); i++){
			em.remove(em.merge(entities.get(i)));
		}
		em.flush(); 
	    em.clear(); 
		return true;
	}
	/**
	 * Delete entity object by id
	 * @param id The object id
	 * @param clazz The entity class
	 * @return True if delete successfully, otherwise false.
	 */
	public <T> boolean delete(Object id, Class<T> clazz) {
		T obj = this.get(clazz, id);
		if (obj != null) {
			this.delete(obj);
			return true;
		}
		return false;
	}
	
	/**
	 * Insert a list of object to database
	 * @param entityName
	 * @param list
	 */
	public void batchInsert(List<?> list) {  
       for(int i = 0; i < list.size(); i++) {  
    	   em.persist(list.get(i));
	   }
       em.flush();  
       em.clear();  
   }  
}

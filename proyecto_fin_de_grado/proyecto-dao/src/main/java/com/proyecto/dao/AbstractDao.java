package com.proyecto.dao;

import java.io.Serializable;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import com.proyecto.model.Car;

public abstract class AbstractDao<PK extends Serializable, T> {

	private final Class<T> persistentClass;

	@SuppressWarnings("unchecked")
	public AbstractDao() {
		this.persistentClass = (Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass())
				.getActualTypeArguments()[1];
	}

	@PersistenceContext
	EntityManager entityManager;

	protected EntityManager getEntityManager() {
		return this.entityManager;
	}

	protected T getByKey(PK key) {
		return (T) entityManager.find(persistentClass, key);
	}

	@Transactional
	protected T persist(T entity) {
		entityManager.persist(entity);
		return entity;
	}

	@Transactional
	protected T update(T entity) {
		entityManager.merge(entity);
		return entity;
	}

	@Transactional
	protected void delete(T entity) {
		entityManager.remove(entity);
	}

	public List<Car> findPaginationCars(int pageSize) {
		return null;
	}

}
package hu.zerotohero.example.javaee.dao;

import hu.zerotohero.example.javaee.model.BaseEntity;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class BaseDao {
	@PersistenceContext
	private EntityManager entityManager;

	public <E extends BaseEntity> List<E> query(Class<E> entityClass, String queryName) {
		return entityManager.createNamedQuery(queryName, entityClass).getResultList();
	}

	public <E extends BaseEntity> E save(E entity) {
		if (entity.getId() == null) {
			entityManager.persist(entity);
			return entity;
		} else {
			return entityManager.merge(entity);
		}
	}
}

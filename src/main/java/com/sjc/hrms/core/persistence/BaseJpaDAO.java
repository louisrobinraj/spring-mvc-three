package com.sjc.hrms.core.persistence;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

public abstract class BaseJpaDAO<EntityType> implements JpaDAO<EntityType> {

	@PersistenceContext
	protected EntityManager em;

	protected Class<EntityType> entityClass;

	protected BaseJpaDAO(Class<EntityType> entityClass) {
		this.entityClass = entityClass;
	}

	public EntityType findOne(String ID) {
		return em.find(entityClass, ID);
	}

	public EntityType findByName(String name) {
		return em.find(entityClass, name);
	}

	protected List<EntityType> queryForList(String query, Object... args) {
		TypedQuery<EntityType> q = em.createQuery(query, entityClass);
		if (args != null)
			for (int i = 0; i < args.length; i++) {
				q.setParameter(1 + i, args[i]);
			}
		return q.getResultList();
	}
}
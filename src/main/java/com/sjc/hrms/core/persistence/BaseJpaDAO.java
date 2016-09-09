package com.sjc.hrms.core.persistence;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;


public abstract class BaseJpaDAO<EntityType> implements JpaDAO<EntityType>{

	@PersistenceContext
	protected EntityManager em;
	
	protected Class<EntityType> entityClass;
	
	protected BaseJpaDAO(Class<EntityType> entityClass){
		this.entityClass = entityClass;
	}
	
	public EntityType findOne(String ID){
		return em.find(entityClass, ID);
	}
	
	public EntityType findByName(String name){
		return em.find(entityClass, name);
	}


	@Override
	public void delete(List<EntityType> entities) {
		for (EntityType e:entities)
			em.remove(e);
	}
	
	@Override
	public void delete(EntityType e) {		
			em.remove(e);
	}
	
	@Override
	public void deleteAll() {
		List<EntityType> results = findAll();
		for (EntityType e:results)
			em.remove(e);
	}
	
	@Override
	public EntityType saveAndFlush(EntityType entity){
		em.persist(entity);
		em.flush();
		return entity;
	}
	
	protected List<EntityType> queryForList(String query, Object...args){
		TypedQuery<EntityType> q = em.createQuery(query, entityClass);
		if (args!=null)
			for (int i=0;i<args.length;i++){
				q.setParameter(1+i, args[i]);
			}
		return q.getResultList();
	}

	protected EntityType queryFor(String query, Object...args){
		List<EntityType> list = queryForList(query, args);
		if (list.isEmpty())
			return null;
		if (list.size()>1){
			StringBuilder message = new StringBuilder();
			message.append("Expected single entry for  ");
			message.append(query);
			message.append(", found ");
			message.append(list.size());
			throw new RuntimeException(message.toString());
			
		}
		return list.get(0);
	}
	
	@Override
	public List<EntityType> findAll() {
		return em.createQuery("from "+entityClass.getName(), entityClass).getResultList();
	}
		
	public CriteriaBuilder createCriteriaBuilder() {
		CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
		return criteriaBuilder;
	}

	public List<EntityType> executeCriteriaQuery(
			CriteriaQuery<EntityType> criteriaQuery) {
		List<EntityType> resultList = em.createQuery(criteriaQuery)
				.getResultList();
		return resultList;
	}
	
	public List<String> executeQueryForStringResult(
			CriteriaQuery<String> criteriaQuery) {
		List<String> resultList = em.createQuery(criteriaQuery)
				.getResultList();
		return resultList;
	}
	
	@Override
	public EntityType saveOrUpdate(EntityType entity){
		return em.merge(entity);
	}
}

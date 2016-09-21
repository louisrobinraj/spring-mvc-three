package com.sjc.hrms.core.persistence;

import java.util.List;

public interface JpaDAO<EntityType> {

	EntityType findOne(String ID);

	void delete(List<EntityType> entities);

	void deleteAll();

	EntityType saveAndFlush(EntityType entity);

	List<EntityType> findAll();

	EntityType saveOrUpdate(EntityType entity);

	void delete(EntityType e);

	public EntityType findByName(String name);
}

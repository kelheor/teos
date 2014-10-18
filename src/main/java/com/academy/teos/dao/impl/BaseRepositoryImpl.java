package com.academy.teos.dao.impl;

import com.academy.teos.dao.BaseRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository("TeosBaseRepository")
public class BaseRepositoryImpl implements BaseRepository {

	private EntityManager entityManager;

	@Override
	public EntityManager getEntityManager() {
		return entityManager;
	}

    public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

}

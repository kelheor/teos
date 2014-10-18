package com.academy.teos.dao;


import javax.persistence.EntityManager;

public interface BaseRepository {

	EntityManager getEntityManager();

}

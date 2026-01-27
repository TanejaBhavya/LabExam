package com.traineeManagement.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.traineeManagement.dto.Trainee;
import com.traineeManagement.util.EmFactory;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.PersistenceException;

public class TraineeDaoJpaImpl implements TraineeDao {
	private EntityManagerFactory entityManagerFactory;
	
	public TraineeDaoJpaImpl() {
		entityManagerFactory=EmFactory.getEntityManagerFactory();
	}
	
	@Override
	public Trainee findTrainee(int id) throws TraineeDataAccessException {
	Trainee t1 = null;
		
		try(EntityManager em = entityManagerFactory.createEntityManager();){
			t1 = em.find(Trainee.class, id);
			
		}catch(PersistenceException e) {
			throw new TraineeDataAccessException("Failed to find trainee with id : " + id,e);
		}

		return t1;
	}

	@Override
	public Trainee addTraniee(Trainee trainee) throws TraineeDataAccessException {

	    EntityManager em = null;
	    EntityTransaction tx = null;

	    try{
	        em = entityManagerFactory.createEntityManager();
	        tx = em.getTransaction();
	        tx.begin();
	        em.persist(trainee);
	        tx.commit();
	        return trainee;       

	    } catch (PersistenceException e) {

	        if (tx != null && tx.isActive()) {
	            tx.rollback();
	        }

	        throw new TraineeDataAccessException(
	            "Trainee can't be added (JPA)", e);

	    } finally {
	        if (em != null) {
	            em.close();
	        }
	    }
	}

	
	
	
	
}

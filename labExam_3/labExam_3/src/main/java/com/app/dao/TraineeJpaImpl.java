package com.app.dao;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import com.app.entity.Trainee;
import com.app.exception.TraineeDataAcessException;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository 
//@ConditionalOnProperty(name = "trainee.dao.type", havingValue = "jpa")
@Profile("Product")
public class TraineeJpaImpl implements TraineeDao {

	
    @PersistenceContext
    private EntityManager entityManager;
    
    
	@Override
	public void addTrainee(Trainee trainee) throws TraineeDataAcessException {
	
		try {
			entityManager.persist(trainee);			
		}catch(Exception e) {
			throw new TraineeDataAcessException("JPA persist is not working",e);
		}
		
	}

	@Override
	public Trainee findById(int traineeId) throws TraineeDataAcessException {
		try {
			return entityManager.find(Trainee.class, traineeId);
		}catch(Exception e) {
			throw new TraineeDataAcessException("JPA find is not working",e);
		}
	}
		
}

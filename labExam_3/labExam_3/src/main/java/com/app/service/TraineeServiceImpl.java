package com.app.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.TraineeDao;
import com.app.entity.Trainee;
import com.app.exception.TraineeDataAcessException;
@Service
@Transactional
public class TraineeServiceImpl implements TraineeService{
	private TraineeDao traineeDao;

	public TraineeServiceImpl(TraineeDao traineeDao) {
	
		this.traineeDao = traineeDao;
	}
	
	@Override
	public void addTrainee(Trainee trainee)  {
		try {
			traineeDao.addTrainee(trainee);
		} catch (TraineeDataAcessException e) {
			
			throw new RuntimeException("Unable to add trainee", e);
		}
		
	}

	@Override
	public Trainee findById(int traineeId)  {
		try {
			return traineeDao.findById(traineeId);
		} catch (TraineeDataAcessException e) {
			System.out.println("Not found!");
			throw new RuntimeException("Trainee witht he requested id was not fouund ", e);
		}
	}
	
	
}

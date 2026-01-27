package com.traineeManagement.dao;

import com.traineeManagement.dto.Trainee;

public interface TraineeDao {
	public  Trainee addTraniee (Trainee traniee) throws TraineeDataAccessException;
	public Trainee findTrainee(int id)throws TraineeDataAccessException;
}

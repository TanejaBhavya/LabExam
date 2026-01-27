package com.traineeManagement.service;

import com.traineeManagement.dao.TraineeDao;
import com.traineeManagement.dao.TraineeDaoJdbcImpl;
import com.traineeManagement.dao.TraineeDaoJpaImpl;
import com.traineeManagement.dao.TraineeDataAccessException;
import com.traineeManagement.dto.Trainee;

public class TraineeServiceImpl implements TraineeService {
	
	private TraineeDao traineeDao;

    public TraineeServiceImpl(TraineeDao traineeDao) {
        this.traineeDao = traineeDao;
    }


//public TraineeServiceImpl() {
//	try {
//		traineeDao = new TraineeDaoJdbcImpl();
//	} catch (TraineeDataAccessException e) {
//		throw new RuntimeException("Service can't be initiated",e);
//	}
//}

public TraineeServiceImpl() {
	traineeDao = new TraineeDaoJpaImpl();
}

	@Override
	public Trainee addTraniee(Trainee trainee) {
		validateBranch(trainee.getBranch());
		try {
			return traineeDao.addTraniee(trainee);
		}catch( TraineeDataAccessException e){
			throw new RuntimeException("Trainee can't be added",e);
		}
	}

	@Override
	public Trainee findTrainee(int id) {
		if(id<=0) {
			throw new IllegalArgumentException("Invalid Id");
		}
		try {
			return traineeDao.findTrainee(id);
		}catch(TraineeDataAccessException e) {
			throw new RuntimeException("Unable to return trainee with the given id",e);
		}
			
	}
	
	public void validateBranch(String branch) {
	    if (branch == null) {
	        throw new IllegalArgumentException("Branch cannot be null");
	    }

	    if (!(branch.equalsIgnoreCase("java") || branch.equalsIgnoreCase("oracle") || branch.equalsIgnoreCase("php") ||
	          branch.equalsIgnoreCase("dotnet"))) {

	        throw new IllegalArgumentException(
	            "Invalid branch. Allowed values: java, oracle, php, dotnet"
	        );
	    }

	}

}

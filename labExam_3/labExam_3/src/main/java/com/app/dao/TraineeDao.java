package com.app.dao;

import com.app.entity.Trainee;
import com.app.exception.TraineeDataAcessException;

public interface TraineeDao {
    void addTrainee(Trainee trainee) throws TraineeDataAcessException ;
    Trainee findById(int traineeId) throws TraineeDataAcessException ;
}

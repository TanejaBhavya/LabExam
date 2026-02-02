package com.app.service;

import com.app.entity.Trainee;
import com.app.exception.TraineeDataAcessException;

public interface TraineeService {
    void addTrainee(Trainee trainee)  ;
    Trainee findById(int traineeId) ;
}

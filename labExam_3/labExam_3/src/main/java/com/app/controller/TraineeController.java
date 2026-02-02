package com.app.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.entity.Trainee;
import com.app.service.TraineeService;

@RestController
@RequestMapping("/api")
public class TraineeController {
	private TraineeService traineeService;

    public TraineeController(TraineeService traineeService) {
        this.traineeService = traineeService;
    }
    
    @PostMapping("/trainees")
    public ResponseEntity<String> addTrainee(@RequestBody Trainee trainee) {
        traineeService.addTrainee(trainee);
        return new ResponseEntity<>("Trainee added successfully", HttpStatus.CREATED);
    }
    
    
    @GetMapping("trainees/{id}")
    public ResponseEntity<Trainee> getTrainee(@PathVariable int id) {
        Trainee trainee = traineeService.findById(id);
        return ResponseEntity.ok(trainee);
    }
}

package com.traineeManagement.controller;

import java.util.Scanner;

import com.traineeManagement.dto.Trainee;
import com.traineeManagement.service.TraineeService;
import com.traineeManagement.service.TraineeServiceImpl;

public class TraineeController {
	public static void main(String[] args) {
		TraineeService ts = new TraineeServiceImpl();
		
		Scanner sc = new Scanner(System.in);
		System.out.println("1. Add a new Trainee");
		System.out.println("2. Find trianee by id");
		int choice = sc.nextInt();
		
		switch(choice) {
		case 1:
			System.out.println("name: ");
			String name = sc.next();
	        System.out.print("Branch: ");
	        String branch = sc.next();
	        System.out.print("Percentage: ");
	        double percentage = sc.nextDouble();
	
	        Trainee t = new Trainee(name, branch, percentage);
	        ts.addTraniee(t);
	        System.out.println("Trainee added: " + t);
            break;
		
		
		case 2:
           System.out.println("Enter ID: ");
            int id = sc.nextInt();

            Trainee t1 = ts.findTrainee(id);
            System.out.println(t1);
            break;
		}
		
		sc.close();
	}

}

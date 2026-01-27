package com.traineeManagement.util;


import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EmFactory {

	private static EntityManagerFactory entityManagerFactory;

	public static EntityManagerFactory getEntityManagerFactory() {
		entityManagerFactory = Persistence.createEntityManagerFactory("db1_pu");
		return entityManagerFactory;
	}
}

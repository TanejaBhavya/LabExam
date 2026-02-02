package com.app.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.app.entity.Trainee;
import com.app.exception.TraineeDataAcessException;
@Repository
//@ConditionalOnProperty(name = "trainee.dao.type", havingValue = "")
@Profile("dev")
public class TraineeJdbcImpl implements TraineeDao {
	
	private JdbcTemplate jdbcTemplate;


	@Autowired
	public TraineeJdbcImpl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	
	@Override
	public void addTrainee(Trainee trainee) throws TraineeDataAcessException {
		try {
			jdbcTemplate.update("INSERT into trainees_table(name,age,marks) Values (?,?,?)",
					trainee.getName(),trainee.getAge(), trainee.getMarks());
		}catch(Exception e) {
			throw new TraineeDataAcessException("Jdbc insert in not working",e);
		}
	
	}

	
	
//	
//	
//	@Override
//	public Trainee findById(int traineeId) throws TraineeDataAcessException {
//		
//		try {
//			return jdbcTemplate.queryForObject("select * form trainees_table where id = ? ",   new BeanPropertyRowMapper<>(Trainee.class),traineeId);
//		}catch(Exception e) {
//			throw new TraineeDataAcessException("Jdbc insert in not working",e);
//		}
//		
	@Override
	public Trainee findById(int traineeId) throws TraineeDataAcessException {
	    try {
	        return jdbcTemplate.queryForObject(
	            "SELECT * FROM trainees_table WHERE id = ?",
	            new BeanPropertyRowMapper<>(Trainee.class),
	            traineeId
	        );
	    } catch (Exception e) {
	        throw new TraineeDataAcessException("Jdbc findById is not working", e);
	    }
	}

	
	}


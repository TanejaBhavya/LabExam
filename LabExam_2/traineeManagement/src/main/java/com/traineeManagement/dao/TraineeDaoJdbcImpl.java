package com.traineeManagement.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.traineeManagement.dto.Trainee;
import com.traineeManagement.util.ConnectionFactory;

public class TraineeDaoJdbcImpl implements TraineeDao {
	
	private Connection connection;
	
	
	
	public TraineeDaoJdbcImpl() throws TraineeDataAccessException  {
		connection = ConnectionFactory.getConnection();
	}
	
////	
//	public TraineeDaoJdbcImpl() throws TraineeDataAccessException  {
//		try {
//			connection = ConnectionFactory.getConnection();
//		} catch (SQLException e) {
//			throw new TraineeDataAccessException("connection can't be established",e);
//		}
//	}

	@Override
	public Trainee addTraniee(Trainee t1) throws TraineeDataAccessException {
		try(PreparedStatement psmt = connection.prepareStatement("INSERT INTO trainee(trainee_name,branch,percentage) values (?,?,?)",Statement.RETURN_GENERATED_KEYS);
				) {
			
			psmt.setString(1, t1.getName());
			psmt.setString(2, t1.getBranch());
			psmt.setDouble(3, t1.getPercentage());
			psmt.executeUpdate();
			
			ResultSet rs = psmt.getGeneratedKeys();
			if(rs.next()) {
				t1.setId(rs.getInt(1));
			}
		}catch(SQLException e) {
			throw new TraineeDataAccessException("Traniee can't be added",e);
		}
		return t1;
	}

	@Override
	public Trainee findTrainee(int id) throws TraineeDataAccessException {
	Trainee t1 = null;
		
		try(PreparedStatement psmt = connection.prepareStatement("SELECT * FROM trainee WHERE trainee_id = ? ");){
			
			psmt.setInt(1, id);
			
			ResultSet rs = psmt.executeQuery();
			
			if(rs.next()) {
				t1 = new Trainee(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4));
			}
			
			
		}catch(SQLException e) {
			throw new TraineeDataAccessException("Failed to find trainee with id : " + id,e);
		}

		return t1;
	}
	
	
}

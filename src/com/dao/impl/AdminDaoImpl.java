package com.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.dao.AdminDao;
import com.entity.Admin;
import com.util.JDBCUtils;

public class AdminDaoImpl implements AdminDao {

	@Override
	public int insert(Admin admin) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Admin admin) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Integer adminId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Admin> queryAll() {
		// TODO Auto-generated method stub
		return null;
	}
	  @Override
	    public Admin login(Admin admin) {
	        String sql = "SELECT * FROM `Admin` WHERE `username` = ? AND `password` = ?";
	        Connection connection = JDBCUtils.getConnection();
	        PreparedStatement preparedStatement = null;
	        ResultSet resultSet = null;
	        try {
	            preparedStatement = connection.prepareStatement(sql);
	            preparedStatement.setString(1, admin.getUsername());
	            preparedStatement.setString(2, admin.getPassword());

	            resultSet = preparedStatement.executeQuery();
	            if (resultSet.next()) {
	                admin.setId(resultSet.getInt(1));
	                admin.setUsername(resultSet.getString(2));
	                admin.setPassword(resultSet.getString(3));
	            } else {
	                admin = null;
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	            try {
	                resultSet.close();
	                preparedStatement.close();
	                connection.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	        return admin;
	    }

	}

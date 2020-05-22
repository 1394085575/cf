package com.service.impl;

import com.dao.AdminDao;
import com.dao.impl.AdminDaoImpl;
import com.entity.Admin;
import com.service.AdminService;

public class AdminServiceImpl implements AdminService {

	  AdminDao adminDao = new AdminDaoImpl();

	    @Override
	    public Admin login(Admin admin) {
	        return adminDao.login(admin);
	    }

	}

package com.niitconnect.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.niitconnect.dao.UserNameDao;
import com.niitconnect.model.Users;

@Service
public class UserNameDaoServiceImpl implements UserNameDaoService
{
	@Autowired
	UserNameDao dao;
	public Users getUserNameByEmail(String username) {
		return dao.getUserNameByEmail(username);
	}
	

}

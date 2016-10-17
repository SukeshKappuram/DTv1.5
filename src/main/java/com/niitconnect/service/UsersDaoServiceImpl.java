package com.niitconnect.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.niitconnect.dao.UsersDao;
import com.niitconnect.model.Users;
@Service
public class UsersDaoServiceImpl implements UserDaoService{
	@Autowired
	private UsersDao dao;

	public void signUp(Users user) {
		dao.signUp(user);
		
	}
	public boolean emailIdCheck(Users u) {
		return dao.emailIdCheck(u);
	}
	public List<Users> viewUsers() {
		return dao.viewUsers();
	}
	public void deactivateUser(int id) {
		dao.deactivateUser(id);
		
	}
	public void activateUser(int id) {
		dao.activateUser(id);
		
	}
	public void makeAdmin(int id)
	{
		dao.makeAdmin(id);
	}

}

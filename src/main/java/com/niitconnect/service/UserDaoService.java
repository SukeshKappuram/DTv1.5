package com.niitconnect.service;

import java.util.List;

import com.niitconnect.model.Users;

public interface UserDaoService {
	public abstract void signUp(Users user);
	public boolean emailIdCheck(Users u);
	public List<Users> viewUsers();
	public void deactivateUser(int id);
	public void activateUser(int id);
	public void makeAdmin(int id);

}

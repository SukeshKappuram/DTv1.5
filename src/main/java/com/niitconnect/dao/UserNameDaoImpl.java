package com.niitconnect.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niitconnect.model.Users;

@Repository
public class UserNameDaoImpl implements UserNameDao {

	@Autowired
	SessionFactory factory;
	public Users getUserNameByEmail(String username) {
		System.out.println("inside the getusernamebyemail");
		Session session=factory.getCurrentSession();
		Transaction tx=session.beginTransaction();
		String hql="from Users where email='"+username+"'";
		Query query=session.createQuery(hql);
		query.setMaxResults(1);
		Users users=(Users)query.uniqueResult();
		System.out.println("First name:"+users.getFirstName());
		return users;
	}

}

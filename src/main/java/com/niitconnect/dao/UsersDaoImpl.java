package com.niitconnect.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niitconnect.model.UserRole;
import com.niitconnect.model.Users;

@Repository
public class UsersDaoImpl implements UsersDao {
	@Autowired
	private SessionFactory factory;
	 @Transactional
	public void signUp(Users user) {
			System.out.println(" I am in user's sign up");
			Session session=factory.getCurrentSession();
			  Transaction tx=session.beginTransaction();
			  user.setEnabled(true);
			 session.saveOrUpdate(user);
			
			UserRole userRole=new UserRole();
			userRole.setUser_role_id(user.getUser_id());
			userRole.setAuthority("ROLE_USER");
			session.saveOrUpdate(userRole);
			tx.commit();
		}
	 public boolean emailIdCheck(Users u) {
			
			String email=u.getEmail();
			Session s=factory.getCurrentSession();
			Transaction t=s.beginTransaction();
			System.out.println("in sign in ");
			Query q=s.createQuery("select password from Users where email='"+email+"'");
			System.out.println("In Query");
			 List l= q.list();
			q.setMaxResults(1);
			String db=(String)q.uniqueResult();
			System.out.println("in userdao password:"+db);
			if(db!=null)
				return true;
			else
		return false;
		}
	public List<Users> viewUsers() {
		   Session session=factory.getCurrentSession();
		   Transaction tx=session.beginTransaction();
		   List<Users> u=session.createCriteria(Users.class).list();
		   tx.commit();
		   return u;
		
	}
	public void deactivateUser(int id) {
		Session session=factory.getCurrentSession();
		Transaction tx=session.beginTransaction();
		Object o=session.load(Users.class,new Integer(id));
		Users user=(Users)o;
		
		user.setEnabled(false);
		tx.commit();
		
	}
	public void activateUser(int id) {
		Session session=factory.getCurrentSession();
		Transaction tx=session.beginTransaction();
		Object o=session.load(Users.class,new Integer(id));
		Users user=(Users)o;
		
		user.setEnabled(true);
		tx.commit();
		
	}
	public void makeAdmin(int id) {
		Session session=factory.getCurrentSession();
		Transaction tx=session.beginTransaction();
		Object o=session.load(UserRole.class,new Integer(id));
		UserRole user=(UserRole)o;
		user.setAuthority("ROLE_ADMIN");
		tx.commit();
		
	}
	
		
	}


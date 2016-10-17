
package com.niitconnect.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niitconnect.model.Blog;
import com.niitconnect.model.Forum;
import com.niitconnect.model.Users;

@Repository
public class ForumDaoImpl implements ForumDao{

	@Autowired
	private SessionFactory factory;
	public void addQuestion(Forum question) {
		
		System.out.println(" I am in add question");
		Session session=factory.getCurrentSession();
		  Transaction tx=session.beginTransaction();
		 session.saveOrUpdate(question);
		 tx.commit();
		
	}
	public List<Forum> viewForum() {
		Session session=factory.getCurrentSession();
		   Transaction tx=session.beginTransaction();
		   List<Forum> question=session.createCriteria(Forum.class).list();
		   tx.commit();
		   return question;
	}
	public boolean deleteQuestion(int id) {
		Session session=factory.getCurrentSession();
	    Transaction tx=session.beginTransaction();
	    tx.begin();
	    Query query=session.createQuery("delete from Forum where id=:status");
	    query.setInteger("status",id);
	    int rowsDeleted=query.executeUpdate();
	    tx.commit();
	    System.out.println("Rows deleted:"+rowsDeleted);
	    if(rowsDeleted!=1)
	    	return true;
	    else
	    	return false;
	}
	@Transactional
	public Forum getQuestion(int id) {
		Session session=factory.getCurrentSession();
		Transaction tx=session.beginTransaction();
		Object o=session.get(Forum.class,new Integer(id));
		Forum question=(Forum)o;
		return question;
	}

}

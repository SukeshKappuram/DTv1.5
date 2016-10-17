package com.niitconnect.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niitconnect.model.Blog;
import com.niitconnect.model.Users;

@Repository
public class BlogDaoImpl implements BlogDao {
	@Autowired
	SessionFactory factory;
	public void addBlog(Blog blog) {
		System.out.println(" I am in addblog");
		Session session=factory.getCurrentSession();
		  Transaction tx=session.beginTransaction();
		 session.saveOrUpdate(blog);
		 tx.commit();
		
	}
	public List<Blog> viewBlogs() {
		Session session=factory.getCurrentSession();
		   Transaction tx=session.beginTransaction();
		   List<Blog> u=session.createCriteria(Blog.class).list();
		   tx.commit();
		   return u;
	}
	public boolean deleteBlog(int id) {
		Session session=factory.getCurrentSession();
	    Transaction tx=session.beginTransaction();
	    tx.begin();
	    Query query=session.createQuery("delete from Blog where id=:status");
	    query.setInteger("status",id);
	    int rowsDeleted=query.executeUpdate();
	    tx.commit();
	    System.out.println("Rows deleted:"+rowsDeleted);
	    if(rowsDeleted!=1)
	    	return true;
	    else
	    	return false;
		
	}

}

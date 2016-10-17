package com.niitconnect.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.niitconnect.dao.BlogDao;
import com.niitconnect.model.Blog;

@Service
public class BlogDaoServiceImpl implements BlogDaoService {
	@Autowired
	private BlogDao dao;
	public void addBlog(Blog blog) {
		
		dao.addBlog(blog);
	}
	public List<Blog> viewBlogs() {
		return  dao.viewBlogs();
	}
	public boolean deleteBlog(int id) {
		return dao.deleteBlog(id);
	}

}

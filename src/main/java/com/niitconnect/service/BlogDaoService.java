package com.niitconnect.service;

import java.util.List;

import com.niitconnect.model.Blog;


public interface BlogDaoService {
	public abstract void addBlog(Blog blog);
	public List<Blog> viewBlogs();
	public abstract boolean deleteBlog(int id);
}

package com.niitconnect.dao;

import java.util.List;

import com.niitconnect.model.Blog;
import com.niitconnect.model.Users;

public interface BlogDao {
	public abstract void addBlog(Blog blog);
	public List<Blog> viewBlogs();
	public abstract boolean deleteBlog(int id);
	
}

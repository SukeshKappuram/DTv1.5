package com.niitconnect.dao;

import java.util.List;

import com.niitconnect.model.Blog;
import com.niitconnect.model.Forum;

public interface ForumDao {
	public abstract void addQuestion(Forum question);
	public List<Forum> viewForum();
	public abstract boolean deleteQuestion(int id);
	public Forum getQuestion(int id);
}

package com.niitconnect.service;

import java.util.List;

import com.niitconnect.model.Blog;
import com.niitconnect.model.Forum;

public interface ForumDaoService {
	public abstract void addQuestion(Forum question);
	public List<Forum> viewForum();
	public abstract boolean deleteQuestion(int id);
	public Forum getQuestion(int id);
}

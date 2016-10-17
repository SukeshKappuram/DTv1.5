package com.niitconnect.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.niitconnect.dao.ForumDao;
import com.niitconnect.model.Forum;

@Service
public class ForumDaoServiceImpl implements ForumDaoService{
	@Autowired
	ForumDao dao;
	public void addQuestion(Forum question) {
		dao.addQuestion(question);
	}
	public List<Forum> viewForum() {
		return dao.viewForum();
	}
	public boolean deleteQuestion(int id) {
		return dao.deleteQuestion(id);
	}
	public Forum getQuestion(int id) {
		return dao.getQuestion(id);
	}

}

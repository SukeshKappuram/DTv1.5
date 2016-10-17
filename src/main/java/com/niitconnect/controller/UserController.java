package com.niitconnect.controller;

import java.io.IOException;
import java.security.Principal;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niitconnect.model.Blog;
import com.niitconnect.model.Forum;
import com.niitconnect.model.Message;
import com.niitconnect.model.OutputMessage;
import com.niitconnect.model.ProfilePicChange;
import com.niitconnect.model.Users;
import com.niitconnect.service.BlogDaoService;
import com.niitconnect.service.ForumDaoService;
import com.niitconnect.service.UserNameDaoService;

@Controller
public class UserController {
	@Autowired
	UserNameDaoService userNameService;
	@Autowired
	BlogDaoService service;
	@Autowired
	ForumDaoService forumService;
   private String username;
	@RequestMapping("/blog")
	public ModelAndView blog()
	{
		return new ModelAndView("blog");
	}
	@RequestMapping("/addBlog")
	public ModelAndView addBlog()
	{
		System.out.println("hello i am in add blog");
		return new ModelAndView("addBlog","blogmodel",new Blog());
	}
	
	@RequestMapping("/viewBlogsAdmin")
	 public ModelAndView viewBlogsAdmin()
	 {
		List<Blog> blogs=service.viewBlogs();
	    ObjectMapper mapper=new ObjectMapper();
	    String jsonData="";
	    try {
			jsonData=mapper.writeValueAsString(blogs);
		} catch (JsonGenerationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
			return new ModelAndView("viewBlogsAdmin","blogs",jsonData);

		 
	 }
	@RequestMapping("/deleteBlog")
	public String deleteBlog(@RequestParam("id") int id)
	{
		ModelAndView mav;
	
		System.out.println("id:"+id);
		boolean result=service.deleteBlog(id);
		return "redirect:/viewBlogsAdmin";

	}
	@RequestMapping("/UserCheck")
	public ModelAndView userCheck(ModelMap model,Principal principal,ProfilePicChange pic)
	{
		System.out.println("in customer");
		String email=principal.getName();
		//username=name;
		Users u=userNameService.getUserNameByEmail(email);
	String firstname=u.getFirstName();
	username=firstname;
		System.out.println("User's first name:"+firstname);
		System.out.println("name:"+firstname);
		model.addAttribute("username",firstname);
		model.addAttribute("useremail",email);
		return new ModelAndView("userHome");
		
	}
	@RequestMapping("/submitBlog")
	public String submitBlog(HttpServletRequest request,ModelMap model,@Valid @ModelAttribute("blogmodel") Blog blog,BindingResult result)
	{
		System.out.println("in submit blog");
		System.out.println("title:"+blog.getTitle());
	blog.setDate(new java.util.Date().toString());
		System.out.println("date:"+blog.getDate());
		blog.setPostedBy(username);
	
		if(result.hasErrors())
		{
			System.out.println("has errors");
			System.out.println("error:"+result);
			return "addBlog";
		}
		service.addBlog(blog);
		System.out.println("after submit blog");
		return "redirect:/addBlog?info=blog added successfully";
	}
	@RequestMapping("/viewBlogs")
	public ModelAndView viewBlogs()
	{ 
		List<Blog> blogs=service.viewBlogs();
    ObjectMapper mapper=new ObjectMapper();
    String jsonData="";
    try {
		jsonData=mapper.writeValueAsString(blogs);
	} catch (JsonGenerationException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (JsonMappingException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
		return new ModelAndView("viewBlogs","blogs",jsonData);
	}
	@RequestMapping("/forum")
	public String forum()
	{
		System.out.println("I am in forum");
		return "forum";
	}
	@RequestMapping("/startDiscussion")
	public ModelAndView startDiscussion()
	{
		return new ModelAndView("startDiscussion","forum",new Forum());
	}
	@RequestMapping("/postQuestion")
	public String postQuestion(@Valid @ModelAttribute("forum") Forum forum,BindingResult result )
	{
		System.out.println("Data:"+forum.getCategory()+"\t"+forum.getQuestion()+"\t"+forum.getTitle());
		if(result.hasErrors())
		{
			return "startDiscussion";
		}
		forum.setDate(new java.util.Date().toString());
		forum.setPostedBy(username);
		forumService.addQuestion(forum);
		
		return "redirect:/startDiscussion?info=Question Successfully Posted";
	}
	@RequestMapping("/viewDiscussion")
	public ModelAndView viewDiscussion()
	{
		List<Forum> forum=forumService.viewForum();
	    ObjectMapper mapper=new ObjectMapper();
	    String jsonData="";
	    try {
			jsonData=mapper.writeValueAsString(forum);
		} catch (JsonGenerationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
			return new ModelAndView("viewDiscussion","discussion",jsonData);
	}
	@RequestMapping("/answer")
	public ModelAndView getQuestion(@RequestParam("id") int id)
	{
		System.out.println("id:"+id);
		Forum forum=forumService.getQuestion(id);
		System.out.println("Question:"+forum.getQuestion());
		ObjectMapper mapper=new ObjectMapper();
	    String jsonData="";
	    try {
			jsonData=mapper.writeValueAsString(forum);
			System.out.println("json data:"+jsonData);
		} catch (JsonGenerationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			return new ModelAndView("discussions","data",jsonData);
		
		
	}
	
	@RequestMapping("/chats")
	  public ModelAndView viewApplication() {
	    return new ModelAndView("chat");
	  }
	    
	  @MessageMapping("/chat")
	  @SendTo("/topic/message")
	  public OutputMessage sendMessage(Message message,Principal principal) {
	    return new OutputMessage(message, new Date(),principal.getName());
	  }
	
}

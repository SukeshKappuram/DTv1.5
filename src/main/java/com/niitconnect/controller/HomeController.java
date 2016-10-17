package com.niitconnect.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.Principal;
import java.util.List;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.niitconnect.model.ProfilePicChange;
import com.niitconnect.model.Users;
import com.niitconnect.service.EmailService;
import com.niitconnect.service.UserDaoService;

@Controller
public class HomeController {
	Path path;
	@Autowired
	UserDaoService service;
	@Autowired
	EmailService emailService;
	@RequestMapping("/")
	public ModelAndView home()
	{
		System.out.println("I am in home");
		return new ModelAndView("index");
	}
	@RequestMapping("/SignUp")
	public ModelAndView signUp()
	{
		return new ModelAndView("SignUp", "user", new Users());
	}
	@RequestMapping("/userSignUp")
	public String userSignUp(HttpServletRequest request,ModelMap model,@RequestParam("file") MultipartFile file, @Valid @ModelAttribute("user") Users user,BindingResult result)
	{
		if(result.hasErrors())
		{
			return "SignUp";
		}
		boolean b=service.emailIdCheck(user);
		System.out.println("boolean value:"+b);
		if(b==true)
		{
			return "redirect:/SignUp?dat=Email id already exists";
		}
		service.signUp(user);
		MultipartFile image=user.getFile();
		path=Paths.get("D://niitconnect//niitconnect//src//main//webapp//resources//images//"+user.getEmail()+".jpg");
		if (image != null && !image.isEmpty()) {
            try {
            	image.transferTo(new File(path.toString()));
                       	
            	System.out.println("Image Saved");
            } catch (Exception e) {
                e.printStackTrace();
                throw new RuntimeException(" image saving failed.", e);
            }
        }
		String subject="Thanks for Registering with NIIT CONNECT";
		String body="This is a greeting mail from NIIT Connect";
		try {
			emailService.send(user, subject,body);
			System.out.println("mail sent");
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
   	return "redirect:/SignUp?data=successfully registered";
	}
	
	
	@RequestMapping("/login")
	public String loginMethod()
	{
		return "login";
	}

	@RequestMapping("/logout")
	public String logout(HttpServletRequest request)
	{
		request.getSession().invalidate();
		System.out.println("logout page called");

		return "logout";
		
	}
	/*@RequestMapping("/UserCheck")
	public ModelAndView userCheck(ModelMap model,Principal principal,ProfilePicChange pic)
	{
		System.out.println("in customer");
		String name=principal.getName();
		System.out.println("name:"+name);
		model.addAttribute("username",name);
		return new ModelAndView("userHome");
		
	}
	*/
	
	@RequestMapping("/AdminCheck")
	public String adminCheck(ModelMap model,Principal principal)
	{
		System.out.println("in admin");
		String name=principal.getName();
		System.out.println("name:"+name);
		model.addAttribute("username",name);
		model.addAttribute("message","spring security custom example");
		return "adminHome";
	}
	@RequestMapping("/ViewUsers")
	public ModelAndView viewUsers()
	{
      List<Users> users=service.viewUsers();
      ObjectMapper mapper=new ObjectMapper();
      String jsonData="";
      try {
		jsonData=mapper.writeValueAsString(users);
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
		return new ModelAndView("ViewUsers","usersdata",jsonData);
	}
	
	@RequestMapping("/userHome")
	public String userHome(ProfilePicChange pic)
	{
		return "userHome";
	}
	
	@RequestMapping("/deactivateUser")
	public String deactivateUser(@RequestParam("id") int id,@RequestParam("name") String name)
	{
		System.out.println("id value:"+id);
		System.out.println("DeActivate User");
		service.deactivateUser(id);
		
	return "redirect:/ViewUsers?res="+name+" is Deactivated";	
	}
	@RequestMapping("/activateUser")
	public String activateUser(@RequestParam("id") int id,@RequestParam("name") String name)
	{
		System.out.println("id value:"+id);
		System.out.println("Activate User");
		service.activateUser(id);
	        return "redirect:/ViewUsers?res="+name+" is Activated";	
	}
	@RequestMapping("/makeAdmin")
	public String makeAdmin(@RequestParam("id") int id,@RequestParam("name") String name)
	{
		System.out.println("id value:"+id);
		System.out.println("Activate User");
		service.makeAdmin(id);
	        return "redirect:/ViewUsers?res="+name+" is also Admin Now";	
	}
	
	@RequestMapping("/changePro")
	public String changeProfilePicture(@RequestParam("file") MultipartFile file, @RequestParam("name") String email,@ModelAttribute("profilePicChange") ProfilePicChange pic,BindingResult result)
	{
		MultipartFile image=pic.getFile();
		path=Paths.get("D://niitconnect//niitconnect//src//main//webapp//resources//images//"+email+".jpg");
		if (image != null && !image.isEmpty()) {
            try {
            	image.transferTo(new File(path.toString()));
                       	
            	System.out.println("Image Saved");
            } catch (Exception e) {
                e.printStackTrace();
                throw new RuntimeException(" image saving failed.", e);
            }
        }
		
		return "redirect:/userHome";
	}

}

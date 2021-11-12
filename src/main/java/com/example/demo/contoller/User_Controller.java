package com.example.demo.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.DAO.User_DAO;
import com.example.demo.model.Transfer_to_DB;

@Controller
public class User_Controller {
 
	@Autowired
	User_DAO user_dao;
	
	@RequestMapping("index")
	public String user()
	{
		
		return "index.jsp";
	}
	@RequestMapping("adduser")
	public String adduser(Transfer_to_DB user)
	{
		user_dao.save(user);
		return "index.jsp";
	}
	@RequestMapping("getuser")
	public ModelAndView getuser(@RequestParam int id)
	{
		ModelAndView mav=new ModelAndView("showUser.jsp");
		//suppose user id illa na excaption throw aagu
		//aaana ipo java 8 kumela below la irrkara mari pannalam
		Transfer_to_DB user=user_dao.findById(id).orElse(null);
		mav.addObject(user);
		return mav;
	}
	
	@RequestMapping("deleteuser")
	public ModelAndView deleteuser(@RequestParam int id)
	{
		ModelAndView mav=new ModelAndView("deleteuser.jsp");
		Transfer_to_DB user=user_dao.findById(id).orElse(null);
		user_dao.deleteById(id);
		mav.addObject(user);
		return mav;
	}
	
	
	@RequestMapping("updateuser")
	public ModelAndView deleteuser(Transfer_to_DB user)
	{
		ModelAndView mav=new ModelAndView("updateuser.jsp");
		user=user_dao.findById(user.getId()).orElse(null);
		user_dao.deleteById(user.getId());
		mav.addObject(user);
	//	mav.getViewName();
		return mav;
	}
}

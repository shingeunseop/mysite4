package com.mysite.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.mysite.service.UserService;
import com.mysite.vo.UserVo;

@Controller
@RequestMapping("/user")//return 값에서는 /user을 일일이써줘야 된다
public class UserController {
	
	@Autowired
	private UserService userService;
		
	
	
	@RequestMapping(value="/joinform",method=RequestMethod.GET)
	public String joinform() {
		
		return "user/joinform";
	}
	
	@RequestMapping(value="/join",method=RequestMethod.POST)
	public String join(@ModelAttribute UserVo uservo) {
		
		System.out.println(uservo.toString());
		userService.join(uservo);
		return"user/joinsuccess";
		
	}
	
	
	
	
	@RequestMapping(value="/loginform",method=RequestMethod.GET)
	public String loginform() {
		
		return "user/loginform";
	}
	
	
	
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String login(@RequestParam("email") String email,@RequestParam("password") String password,
			              HttpSession session) {
		
		UserVo authUser=userService.getUser(email,password);
		if(authUser!=null) {
			session.setAttribute("authUser", authUser);//다른 패이지에서 이 값을 사용하기 위해
			return "redirect:/main";
		}else {
			return "redirect:/user/loginform?result=fail";
		}
			
	}
	
	
	
	
	@RequestMapping(value="/logout",method=RequestMethod.GET)
	public String logout(HttpSession session) {
		session.removeAttribute("authUser");
		session.invalidate();//두개의 라인을 잘 기억
		return "redirect:/main";
	}
	
	
	
	
	@RequestMapping(value="/modifyform",method=RequestMethod.GET)//get주소로 오기 떄문에
	public String modifyform(HttpSession session,Model model) {
		
		UserVo authUser=(UserVo)session.getAttribute("authUser");
		int no=authUser.getNo();
		
		
		UserVo userVo=userService.getUser(no);
		
		model.addAttribute("UserVo",userVo);//밖으로 보일때는 "UserVo로 사용"
		
		
		return "/user/modifyform";
	}
	
	
	
	@RequestMapping(value="/modify",method=RequestMethod.GET)
	public String modify(@ModelAttribute UserVo userVo,HttpSession session) {
		UserVo authUser=(UserVo)session.getAttribute("authUser");
		int no=authUser.getNo();
		System.out.println(authUser.toString());
		userVo.setNo(no);
		
		userService.updateUser(userVo);
		
		authUser.setName(userVo.getName());
		
		
		return "redirect:/main";
	}
	
	

}

package com.mysite.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.mysite.service.GuestbookService;
import com.mysite.vo.GuestbookVo;

@Controller
@RequestMapping(value="/guestbook")
public class GuestbookController {

	@Autowired
	private GuestbookService guestbookService;
	
	@RequestMapping(value="/list-ajax",method=RequestMethod.GET)
	public String listAjax() {
		return "guestbook/list-ajax";
	}
	

	@RequestMapping(value="/list")
	public String list(@ModelAttribute GuestbookVo guestbookvo,Model model) {

		List<GuestbookVo> list =guestbookService.getlist(guestbookvo);
		model.addAttribute("list",list);
		return "guestbook/list";
	}
	
	@RequestMapping(value="/insert",method=RequestMethod.POST)
	public String insert(GuestbookVo guestbookVo) {
		guestbookService.insert(guestbookVo);
		
		return "redirect:/guestbook/list";
	}
	
	@RequestMapping(value="/deleteform")
	public String deleteform() {
		
		
		return "/guestbook/deleteform";
	}
	@RequestMapping(value="/delete",method=RequestMethod.POST)
	public String delete(GuestbookVo vo,@RequestParam("no") int no,String password) {
		
		
		vo.setNo(no);
		vo.setPassword(password);
		guestbookService.delete(vo);
		System.out.println(vo.toString());
		
		return "redirect:/guestbook/list";
	}
	
	@RequestMapping(value="/bootstrap")
	public String bootstrap() {
		
		return "/guestbook/bootstrap";
	}
	

}

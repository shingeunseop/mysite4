package com.mysite.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mysite.service.GuestbookService;
import com.mysite.vo.GuestbookVo;

@Controller

@RequestMapping(value="/api/guestbook")
public class ApiGuestbookController {
	
	@Autowired
	private GuestbookService guestbookService;
	
	@ResponseBody//body로 보내겠다는 뜻
	@RequestMapping(value="/list",method=RequestMethod.POST)
	public  List<GuestbookVo> list(GuestbookVo guestbookvo) {
		
		
	
		List<GuestbookVo> list=guestbookService.getlist(guestbookvo);
		
		
		
		return list;//반환형이 list 타입으로 보내 지므로 public List<GuestbookVo>형태로 된다.
	}
	

}

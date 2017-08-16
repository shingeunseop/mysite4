package com.mysite.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.mysite.service.ReplyBoardService;
import com.mysite.vo.ReplyBoardVo;
import com.mysite.vo.UserVo;

@Controller
@RequestMapping("/replyboard")
public class ReplyBoardController {
	
	
	@Autowired
	private ReplyBoardService rbs;
	
	@RequestMapping(value="/list")
	public String list(@ModelAttribute ReplyBoardVo rbv, Model model) {
		
		List<ReplyBoardVo> list = rbs.getlist(rbv);
		
				
		model.addAttribute("list", list);
		
		return "/replyboard/list";
	
	}
	
	@RequestMapping(value = "/read")
	public String read(ReplyBoardVo rbv, HttpSession session, @RequestParam("no") int no,
			@RequestParam("groupNo") int groupNo,@RequestParam("orderNo") int orderNo
			,@RequestParam("depthNo") int depthNo,Model model) {
		
		rbv.setNo(no);
		rbv.setGroupNo(groupNo);
		rbv.setOrderNo(orderNo);
		rbv.setDepthNo(depthNo);
		rbv = rbs.getread(no);

		

		model.addAttribute("rbv", rbv);

		return "/replyboard/read";
	}
	
	@RequestMapping(value = "/writeform")
	public String writeform() {

		return "/replyboard/writeform";
	}
	
	@RequestMapping(value ="/write", method = RequestMethod.POST)
	public String write(@ModelAttribute // 입력된 파라미터를 가져와라
			ReplyBoardVo rbv, HttpSession session) {

		UserVo authUser = (UserVo) session.getAttribute("authUser");
		int no = authUser.getNo();
		
		rbv.setUserNo(no);

		rbs.insert(rbv);
		rbv.toString();

		return "redirect:/replyboard/list";
	}
	
	@RequestMapping(value = "/datform")
	public String datform(ReplyBoardVo rbv,@RequestParam("groupNo") int groupNo,@RequestParam("orderNo") int orderNo
			,@RequestParam("depthNo") int depthNo,Model model) {
		
		rbv.setGroupNo(groupNo);
		rbv.setOrderNo(orderNo);
		rbv.setDepthNo(depthNo);
		
		System.out.println(rbv.toString());

		model.addAttribute("rbv",rbv);
		
		return "/replyboard/datform";
	}
	
	@RequestMapping(value ="/writedat", method = RequestMethod.POST)
	public String writedat(@ModelAttribute ReplyBoardVo rbv,HttpSession session,Model model) {
		
		

		UserVo authUser = (UserVo) session.getAttribute("authUser");
		int no = authUser.getNo();
		
		
		rbv.setUserNo(no);
		
		
		rbs.datwrite(rbv);
		
		
		model.addAttribute(rbv);

		
		return "redirect:/replyboard/list";
	}
	
	@RequestMapping(value = "/delete")
	public String delte(ReplyBoardVo rbv,@RequestParam("no") int no,Model model) {
		rbv.setNo(no);
		
		rbs.getdelete(rbv);
		
		model.addAttribute("rbv", rbv);

		return "redirect:/replyboard/list";
	}
	
	

}

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

import com.mysite.service.BoardService;
import com.mysite.vo.BoardVo;
import com.mysite.vo.UserVo;

@Controller
@RequestMapping("/board")
public class BoardController {

	@Autowired
	private BoardService boardService;

	@RequestMapping(value = "/list")
	public String list(@ModelAttribute BoardVo boardVo, Model model) {

		List<BoardVo> list = boardService.getlist(boardVo);
		
		
		model.addAttribute("list", list);
		
		return "/board/list";
	}

	@RequestMapping(value = "/writeform")
	public String writeform() {

		return "/board/writeform";
	}

	@RequestMapping(value = "/write", method = RequestMethod.POST)
	public String write(@ModelAttribute // 입력된 파라미터를 가져와라
	BoardVo boardVo, HttpSession session) {

		UserVo authUser = (UserVo) session.getAttribute("authUser");
		int no = authUser.getNo();
		System.out.println(boardVo.toString());

		boardVo.setUserNo(no);

		boardService.insert(boardVo);

		return "redirect:/board/list";
	}

	@RequestMapping(value = "/read")
	public String read(BoardVo boardVo, UserVo userVo, HttpSession session, @RequestParam("no") int no, Model model) {
		boardVo.setNo(no);
		boardVo = boardService.getread(no);

		System.out.println(boardVo.toString());

		model.addAttribute("boardVo", boardVo);

		return "/board/read";
	}

	@RequestMapping(value = "/modifyform")
	public String modifyform(BoardVo boardVo, @RequestParam("no") int no, Model model) {

		model.addAttribute("boardVo", boardVo);
		return "/board/modifyform";
	}

	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public String modify(@ModelAttribute BoardVo boardVo, @RequestParam("no") int no, Model model) {
		boardVo.setNo(no);

		boardService.getupdate(boardVo);

		model.addAttribute("boardVo", boardVo);
		return "redirect:/board/list";
	}

	@RequestMapping(value = "/delete")
	public String delte(BoardVo boardVo,@RequestParam("no") int no,Model model) {
		boardVo.setNo(no);
		
		boardService.getdelete(boardVo);
		
		model.addAttribute("boardVo", boardVo);

		return "redirect:/board/list";
	}
	
	/*@RequestMapping(value="/search",method=RequestMethod.POST)
	public String search(@ModelAttribute BoardVo boardVo,Model model) {
		
		
		boardService.getsearch(boardVo);
		model.addAttribute("boardVo",boardVo);
		return "redirect:/board/list";
	}*/

}

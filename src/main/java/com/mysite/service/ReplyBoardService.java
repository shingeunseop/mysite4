package com.mysite.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mysite.repository.ReplyBoardDao;
import com.mysite.vo.ReplyBoardVo;

@Service
public class ReplyBoardService {
	
	@Autowired
	private ReplyBoardDao rbd;
	
	public List<ReplyBoardVo> getlist(ReplyBoardVo rbv) {
		return rbd.getlist(rbv);
		
	}
	
	public ReplyBoardVo getread(int no) {
		return rbd.getread(no);
	}
	
	public int insert(ReplyBoardVo rbv) {
		return rbd.insert(rbv);
	}
	
	public int datinsert(ReplyBoardVo rbv) {
		return rbd.datinsert(rbv);
	}
}

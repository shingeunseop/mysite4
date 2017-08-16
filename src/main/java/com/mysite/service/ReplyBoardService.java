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
	
	public int datwrite(ReplyBoardVo rbv) {
		
		rbv.setDepthNo(rbv.getDepthNo()+1);
		rbv.setOrderNo(rbv.getOrderNo()+1);
		rbd.datupdate(rbv);
		
		
		return rbd.datinsert(rbv);
	}
	public int getdelete(ReplyBoardVo rbv) {
		return rbd.delete(rbv);
	}
	
	public int getupdate(ReplyBoardVo rbv) {
		return rbd.update(rbv);
	}
	
}

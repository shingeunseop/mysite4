package com.mysite.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mysite.repository.GuestbookDao;
import com.mysite.vo.GuestbookVo;

@Service
public class GuestbookService {
	
	@Autowired
	private GuestbookDao guestbookDao;
	
	public List<GuestbookVo> getlist(GuestbookVo guestbookvo) {
				
		return guestbookDao.getlist(guestbookvo);
	}
	
	public int insert(GuestbookVo guestbookVo) {
		
		return guestbookDao.insert(guestbookVo);
	}
	
	public GuestbookVo insertVo(GuestbookVo guestbookVo) {
		int no=guestbookDao.insertVo(guestbookVo);//no를 가져온 다음에
		guestbookVo=guestbookDao.selectByNo(no);
		
		return guestbookVo;
	}
	
	public int delete(GuestbookVo vo) {
		return guestbookDao.delete(vo);
	}

}

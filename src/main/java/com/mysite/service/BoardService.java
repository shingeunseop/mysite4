package com.mysite.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mysite.repository.BoardDao;
import com.mysite.vo.BoardVo;

@Service
public class BoardService {
	
	@Autowired
	private BoardDao boardDao;
	
	public List<BoardVo> getlist(BoardVo boardVo) {
		return boardDao.getlist(boardVo);
		
	}
	
	public BoardVo getread(int no) {
		return boardDao.getread(no);
	}
	
	public int insert(BoardVo boardVo) {
		return boardDao.insert(boardVo);
	}
	
	public int getupdate(BoardVo boardVo) {
		return boardDao.update(boardVo);
	}
	
	public int getdelete(BoardVo boardVo) {
		return boardDao.delete(boardVo);
	}

}

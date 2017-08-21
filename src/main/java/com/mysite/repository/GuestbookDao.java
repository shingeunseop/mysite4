package com.mysite.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mysite.vo.GuestbookVo;

@Repository
public class GuestbookDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	public List<GuestbookVo> getlist(GuestbookVo guestbookvo) {
		
			
		return sqlSession.selectList("guestbook.getByteNo",guestbookvo);
	}
	
	public int insert(GuestbookVo guestbookVo) {
		
		return sqlSession.insert("guestbook.insert",guestbookVo);
		
	}
	public int delete(GuestbookVo vo) {
		
		return sqlSession.delete("guestbook.delete",vo);
	}
	public int insertVo(GuestbookVo guestbookVo) {
		System.out.println("전: "+guestbookVo.toString());
		sqlSession.insert("guestbook.insertNo",guestbookVo);
		System.out.println("후: "+guestbookVo.toString());
		return guestbookVo.getNo();
	}
	
	public GuestbookVo selectByNo(int no) {
		return sqlSession.selectOne("guestbook.selectByno",no);
		
	}

}

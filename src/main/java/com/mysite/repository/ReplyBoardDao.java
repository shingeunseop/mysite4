package com.mysite.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mysite.vo.ReplyBoardVo;

@Repository
public class ReplyBoardDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	public List<ReplyBoardVo> getlist(ReplyBoardVo rbv){
		return sqlSession.selectList("replyboard.list");
	}
	
	public  ReplyBoardVo getread(int no) {
		
		return sqlSession.selectOne("replyboard.read",no);
	}
	
	public int insert(ReplyBoardVo rbv) {
		rbv.toString();
		return sqlSession.insert("replyboard.insert",rbv);
	}
	
	

}
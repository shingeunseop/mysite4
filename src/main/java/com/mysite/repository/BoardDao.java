package com.mysite.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mysite.vo.BoardVo;

@Repository
public class BoardDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	public List<BoardVo> getlist(BoardVo boardVo){
		return sqlSession.selectList("board.list");
	}
	
	public  BoardVo getread(int no) {
	
		return sqlSession.selectOne("board.read",no);
	}
	
	public int insert(BoardVo boardVo) {
		boardVo.toString();
		return sqlSession.insert("board.insert",boardVo);
	}
	
	public int update(BoardVo boardVo) {
		return sqlSession.update("board.update",boardVo);
		
	}
	
	public int delete(BoardVo boardVo) {
		return sqlSession.delete("board.delete",boardVo);
		
	}
	
	/*public String search(BoardVo boardVo) {
		return sqlSession.selectList("board.search",boardVo);
		
	}*/

}

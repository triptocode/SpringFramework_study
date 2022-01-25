package com.kk.spring10_2.repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kk.spring10_2.entity.BoardDto;

@Repository
public class BoardDaoImpl implements BoardDao{

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public int write(BoardDto boardDto) 
	{
		int no = sqlSession.selectOne("mnBoard.selectSeq");
		boardDto.setBoard_no(no);
		sqlSession.insert("mnBoard.insertWrite", boardDto);
		return no;
	}

	// 상세보기 + 조회수증가 x
	@Override 
	public BoardDto view(int board_no)  
	{   // DB 조회수증가 코드 x  
		BoardDto boardDto = sqlSession.selectOne("mnBoard.selectView", board_no);
		return boardDto;
	}

	// 상세보기 + 조회수증가 o
	@Override
	public BoardDto viewUp(int board_no) 
	{
		// DB 조회수증가 코드 o - 아래 한줄 추가
		sqlSession.update("mnBoard.updateViewUp", board_no); 
		BoardDto boardDto = sqlSession.selectOne("mnBoard.selectView", board_no);
		return boardDto;
	}


}







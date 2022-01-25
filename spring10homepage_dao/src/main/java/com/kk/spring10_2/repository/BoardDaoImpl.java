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

	// �󼼺��� + ��ȸ������ x
	@Override 
	public BoardDto view(int board_no)  
	{   // DB ��ȸ������ �ڵ� x  
		BoardDto boardDto = sqlSession.selectOne("mnBoard.selectView", board_no);
		return boardDto;
	}

	// �󼼺��� + ��ȸ������ o
	@Override
	public BoardDto viewUp(int board_no) 
	{
		// DB ��ȸ������ �ڵ� o - �Ʒ� ���� �߰�
		sqlSession.update("mnBoard.updateViewUp", board_no); 
		BoardDto boardDto = sqlSession.selectOne("mnBoard.selectView", board_no);
		return boardDto;
	}


}







package com.kk.spring10_2.repository;

import com.kk.spring10_2.entity.BoardDto;

public interface BoardDao {
	//글 등록 기능
	// - 필요데이터 : BoardDto
	// - 결과데이터 : 게시글 번호(int)
	int write(BoardDto boardDto);

	BoardDto view(int board_no);
	BoardDto viewUp(int board_no);
}

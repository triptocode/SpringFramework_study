package com.kk.spring10_2.repository;

import com.kk.spring10_2.entity.BoardDto;

public interface BoardDao {
	
	int write(BoardDto boardDto);

	BoardDto get(int board_no);
	BoardDto read(int board_no);
}

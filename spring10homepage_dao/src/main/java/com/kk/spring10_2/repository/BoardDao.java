package com.kk.spring10_2.repository;

import com.kk.spring10_2.entity.BoardDto;

public interface BoardDao {
	//�� ��� ���
	// - �ʿ䵥���� : BoardDto
	// - ��������� : �Խñ� ��ȣ(int)
	int write(BoardDto boardDto);

	BoardDto view(int board_no);
	BoardDto viewUp(int board_no);
}

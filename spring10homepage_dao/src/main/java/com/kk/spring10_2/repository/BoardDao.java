package com.kk.spring10_2.repository;

import com.kk.spring10_2.entity.BoardDto;

public interface BoardDao {
	//�� ��� ���
	// - �ʿ䵥���� : BoardDto
	// - ��������� : �Խñ� ��ȣ(int)
	
	int write(BoardDto boardDto); // �� �ۼ� �޼��� 
	BoardDto view(int board_no);   // �󼼺��� + ��ȸ������ x
	BoardDto viewUp(int board_no); // �󼼺��� + ��ȸ������ o
}

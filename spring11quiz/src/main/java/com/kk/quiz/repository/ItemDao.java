package com.kk.quiz.repository;

import java.util.List;

import com.kk.quiz.entity.ItemDto;

public interface ItemDao {
	void insert(ItemDto itemDto);
	List<ItemDto> getList();
	List<ItemDto> getList(String col, String order);
	ItemDto get(int no);
	void delete(int no);
}

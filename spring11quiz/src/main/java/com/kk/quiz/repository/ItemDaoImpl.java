package com.kk.quiz.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kk.quiz.entity.ItemDto;

@Repository
public class ItemDaoImpl implements ItemDao{

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public void insert(ItemDto itemDto) {
		sqlSession.insert("item.add", itemDto);
	}

	@Override
	public List<ItemDto> getList() {
//		List<ItemDto> list = sqlSession.selectList("구문ID");
//		return list;
		return sqlSession.selectList("item.getList");
	}

	@Override
	public List<ItemDto> getList(String col, String order) {
		Map<String, Object> map = new HashMap<>();
		map.put("col", col);      // ���ı��� �׸� 
		map.put("order", order);  // ���� : ��������, �������� 
		List<ItemDto> list = sqlSession.selectList("item.getList2", map);
		return list;
	}
	
	@Override
	public ItemDto get(int no) {
		return sqlSession.selectOne("item.get", no);
	}

	@Override
	public void delete(int no) {
		sqlSession.delete("item.del", no);
	}
	
}




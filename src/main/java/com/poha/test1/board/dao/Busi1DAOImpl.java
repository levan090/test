package com.poha.test1.board.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import com.poha.test1.board.vo.Busi1VO;

@Service
public class Busi1DAOImpl implements Busi1DAO {

	@Inject
	private SqlSession sql;
	
	private static String namespace="test1";
	
	public List<Busi1VO> list() throws Exception{
		return sql.selectList(namespace+".ubi_select");
	}

	@Override
	public void insert(Busi1VO vo) throws Exception {
		sql.insert(namespace+".ubi_insert",vo);
		
	}
}

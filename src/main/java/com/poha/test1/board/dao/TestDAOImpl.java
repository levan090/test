package com.poha.test1.board.dao;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.poha.test1.board.vo.testVO;

@Service
public class TestDAOImpl implements TestDAO{

	@Inject
	private SqlSession sql;
	private static String namespace="com.poha.test1.board.vo.testVO";
//	private static String namespace="test1";
	
	public List<testVO> list() throws Exception {
		return sql.selectList(namespace+".list");
	}
	
	public void insertTest(testVO vo) throws Exception{
		sql.insert(namespace + ".write",vo);
	}
	
	
	
	public void modifty(testVO vo) throws Exception{}
	
	public void delete(int testId) throws Exception{
		sql.delete(namespace + ".delete",testId);
		
	}

	@Override
	public void modify(testVO vo) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public testVO view(int testId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int count() throws Exception {
		return sql.selectOne(namespace + ".count");
	}
	
	@Override
	public List listPage(int displayPost, int postNum) throws Exception {

	 HashMap data = new HashMap();
	  
	 data.put("displayPost", displayPost);
	 data.put("postNum", postNum);
	  
	 return sql.selectList(namespace + ".listPage", data);
	}
}

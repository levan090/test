package com.poha.test1.board.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.poha.test1.board.dao.TestDAO;
import com.poha.test1.board.vo.testVO;

@Service
public class TestServiceImpl implements TestService {
	
	@Inject
	private TestDAO dao;
	
	//게시글 목록
	@Override
	public List<testVO> list() throws Exception {
			return dao.list();
	}
	
	//게시글 작성
	@Override
	public void insert(testVO vo) throws Exception{
			dao.insertTest(vo);
	}

	//게시글 삭제 
	@Override
	public void delete(int testId) throws Exception {
		dao.delete(testId);
		
	}
	
	// 게시글 수정
	@Override
	public void modify(testVO vo) throws Exception{
		dao.modify(vo);	
	}
	@Override
	public int count() throws Exception {
		return dao.count();
	}
	
	@Override
	public List listPage(int displayPost, int postNum) throws Exception {
	 return dao.listPage(displayPost, postNum);
	}

	@Override
	public void merge(testVO vo) throws Exception{
		dao.merge(vo);	
	}
	
}

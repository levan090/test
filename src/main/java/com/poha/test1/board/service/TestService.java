package com.poha.test1.board.service;

import java.util.List;

import com.poha.test1.board.vo.testVO;

public interface TestService {

		// 게시물 목록
		public List<testVO> list() throws Exception;
		
		//게시물 작성
		public void insert(testVO vo) throws Exception;
		
		// 게시물 삭제
		public void delete(int testId) throws Exception;
		
		public void modify(testVO vo) throws Exception;
		// 게시물 총 갯수
		public int count() throws Exception;
		
		public List listPage(int displayPost, int postNum) throws Exception;
		
		// 게시물 갱신
		public void merge(String testId,String content) throws Exception;
}

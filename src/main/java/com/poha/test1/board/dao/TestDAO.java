package com.poha.test1.board.dao;

import java.util.List;

import com.poha.test1.board.vo.testVO;

public interface TestDAO {

		// 게시판 목록
		public List<testVO> list() throws Exception;
		
		// 게시판 작성
		public void insertTest(testVO vo) throws Exception;
		
		// 게시판 조회
		public testVO view(int testId) throws Exception;
		
		// 게시물 수정
		public void modify(testVO vo) throws Exception;
		
		// 게시물 삭제
		public void delete(int testId) throws Exception;
		
		// 게시물 총 갯수
		public int count() throws Exception;
		
		// 게시물 + 페이징
		public List listPage(int displayPost, int postNum) throws Exception;
		
		// 게시물 갱신
		public void merge(testVO vo) throws Exception;
}

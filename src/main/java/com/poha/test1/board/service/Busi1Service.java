package com.poha.test1.board.service;

import java.util.List;

import com.poha.test1.board.vo.Busi1VO;

public interface Busi1Service {

	// 게시물 목록
			public List<Busi1VO> list() throws Exception;
			
	// 게시물 작성
			public void insert(Busi1VO vo) throws Exception;
			
	// 게시물 갱신
			public void merge(String pro_code,String pro_name,String brand_code, String pro_category,String pro_year, String pro_price) throws Exception;
			
	// 게시물 상세 조회
			public Busi1VO view(int pro_code) throws Exception;
			
	// 게시물 수정
			public void modify(Busi1VO vo) throws Exception;
}

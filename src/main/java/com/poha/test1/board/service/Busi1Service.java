package com.poha.test1.board.service;

import java.util.List;

import com.poha.test1.board.vo.Busi1VO;

public interface Busi1Service {

	// 게시물 목록
			public List<Busi1VO> list() throws Exception;
			
	// 게시물 작성
			public void insert(Busi1VO vo) throws Exception;
			
	// 게시물 갱신
			public void merge(String pro_code,String pro_name,String brand_code, String pro_category,String pro_year, String pro_price, String store_id) throws Exception;
			
	// 게시물 상세 조회
			public Busi1VO view(int pro_code) throws Exception;
			

	
	// 게시물 삭제
			public void delete(int pro_code) throws Exception;
			
	// 가게 전체 조회
			public List<Busi1VO> list_store() throws Exception;		
			
	// 가게에서 판매중인 bike 조회
			public List<Busi1VO> list_bike(int store_id) throws Exception;
			
			public void clear() throws Exception;
}

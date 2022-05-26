package com.poha.test1.board.dao;

import java.util.List;

import com.poha.test1.board.vo.Busi1VO;


public interface Busi1DAO {

	// 게시물 전체 목록 
	public List<Busi1VO> list() throws Exception;
	
	// 게시물 작성
	public void insert(Busi1VO vo) throws Exception;
	// 게시물 merge
	public void merge(String pro_code,String pro_name,String brand_code, String pro_category,String pro_year, String pro_price) throws Exception;
	
	public void modify(Busi1VO vo) throws Exception;
	// 게시물 상세 조회
	public Busi1VO view(int pro_code) throws Exception;
	// 삭제
	public void delete(int pro_code) throws Exception;
}

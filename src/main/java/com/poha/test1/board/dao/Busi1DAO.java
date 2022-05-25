package com.poha.test1.board.dao;

import java.util.List;

import com.poha.test1.board.vo.Busi1VO;


public interface Busi1DAO {

	// 목록 
	public List<Busi1VO> list() throws Exception;
	
//	// 작성
//	public void insert(Busi1VO vo) throws Exception;
//	// 수정
//	public void merge(String pro_code,String pro_name,String brand_code, String pro_category,String pro_year, String pro_price) throws Exception;
//	
//	// 삭제
//	public void delete(int pro_code) throws Exception;
}

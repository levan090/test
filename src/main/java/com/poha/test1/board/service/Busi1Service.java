package com.poha.test1.board.service;

import java.util.List;

import com.poha.test1.board.vo.Busi1VO;

public interface Busi1Service {

	// 게시물 목록
			public List<Busi1VO> list() throws Exception;
			
	// 게시물 작성
			public void insert(Busi1VO vo) throws Exception;
			
			
}

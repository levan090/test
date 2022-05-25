package com.poha.test1.board.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.poha.test1.board.dao.Busi1DAO;
import com.poha.test1.board.vo.Busi1VO;

@Service
public class Busi1ServiceImpl implements Busi1Service {
	
	@Inject
	private Busi1DAO dao;
	
	@Override				// 게시물 목록
	public List<Busi1VO> list() throws Exception{
		return dao.list();
	}
}

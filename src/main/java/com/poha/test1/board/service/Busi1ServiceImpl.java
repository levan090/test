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

	@Override
	public void insert(Busi1VO vo) throws Exception {
		dao.insert(vo);
		
	}

	@Override
	public void merge(String pro_code, String pro_name, String brand_code, String pro_category, String pro_year,
			String pro_price, String store_id) throws Exception {
		dao.merge(pro_code, pro_name,brand_code, pro_category, pro_year, pro_price, store_id);
		
	}

	@Override
	public Busi1VO view(int pro_code) throws Exception {
		return dao.view(pro_code);
	}

	

	@Override
	public void delete(int pro_code) throws Exception {
		dao.delete(pro_code);
		
	}

	@Override
	public List<Busi1VO> list_store() throws Exception {
		return dao.list_store();
	}

	@Override
	public List<Busi1VO> list_bike(int store_id) throws Exception {
		return dao.list_bike(store_id);
	}

	@Override
	public void clear() throws Exception {
		dao.clear();
	}
}

package com.poha.test1.board.dao;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import com.poha.test1.board.vo.Busi1VO;

@Service
public class Busi1DAOImpl implements Busi1DAO {

	@Inject
	private SqlSession sql;
	
	private static String namespace="test1";
	
	public List<Busi1VO> list() throws Exception{
		return sql.selectList(namespace+".ubi_select");
	}

	@Override
	public void insert(Busi1VO vo) throws Exception {
		sql.insert(namespace+".ubi_insert",vo);
		
	}

	@Override
	public void merge(String pro_code, String pro_name, String brand_code, String pro_category, String pro_year,
			String pro_price, String store_id) throws Exception {
		
		HashMap data = new HashMap();
		  
		 data.put("pro_code", pro_code);
		 data.put("pro_name", pro_name);
		 data.put("brand_code", brand_code);
		 data.put("pro_category", pro_category);
		 data.put("pro_year", pro_year);
		 data.put("pro_price", pro_price);
		 data.put("store_id",store_id );
		 
		sql.insert(namespace + ".ubi_merge", data);
		
	}

	@Override
	public Busi1VO view(int pro_code) throws Exception {
		
		return sql.selectOne(namespace+".ubi_view",pro_code);
	}

	

	@Override
	public void delete(int pro_code) throws Exception {
		sql.delete(namespace + ".ubi_delete",pro_code);
		
	}

	@Override
	public List<Busi1VO> list_store() throws Exception {
		return sql.selectList(namespace+".ubi_store_select");
	}

	@Override
	public List<Busi1VO> list_bike(int store_id) throws Exception {
		return sql.selectList(namespace+".ubi_bike_select",store_id);
	}
}

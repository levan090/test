package com.poha.test1.board.controller;

import java.util.List;
import java.util.Locale;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.poha.test1.board.service.Busi1Service;
import com.poha.test1.board.vo.Busi1VO;
import com.poha.test1.board.vo.testVO;

@Controller
public class Busi1Controller {

	@Inject
	private Busi1Service B_service;
	
	@Autowired
	private SqlSession sqlSession;
	
	
	// ubi 게시판 조회
	@RequestMapping(value="/ubirep.do")
	public String ubirep(Locale locale,Model model) {
		List<Busi1VO> list = sqlSession.selectList("test1.ubi_select");
		

		model.addAttribute("list", list);
		return "ubi_main";
	}
	// ubi bike store목록 조회
		@RequestMapping(value="/bikestore.do")
		public String bikeStore(Locale locale,Model model) {
			List<Busi1VO> list_store = sqlSession.selectList("test1.ubi_store_select");
			
		
			model.addAttribute("list", list_store);
			return "Store";
		}
		
	// ubi 특정 가게의 판매물품리스트
		@RequestMapping(value="/bikelist.do")
		public String bikelist(HttpServletRequest httpServletRequest,Model model) {
			String id = httpServletRequest.getParameter("store_id");
			int store_id = Integer.parseInt(id);
			List<Busi1VO> list_bike = sqlSession.selectList("test1.ubi_bike_select",store_id);
			
			
			model.addAttribute("list", list_bike);
			return "ubi_main";
		}
	// ubi 게시판 작성 요청
	@RequestMapping(value="/ubi_write.do")
	public String ubiInsert(Busi1VO vo) throws Exception{
		
		return "ubi_write";
	}
	// ubi 게시판 작성 동작
	@RequestMapping(value="/ubi_write_proc.do")
	public String ubiInsert_proc(Busi1VO vo) throws Exception{
		
		B_service.insert(vo);
		
		return "redirect:/ubirep.do";
	}
	
	//ubi 게시판 수정
	@RequestMapping(value="/ubi_modify_proc.do")
	public String ubiModify(HttpServletRequest httpServletRequest)throws Exception {
		
		String pro_code = httpServletRequest.getParameter("pro_code");
	    String pro_name = httpServletRequest.getParameter("pro_name");
	    String brand_code = httpServletRequest.getParameter("brand_code");
	    String pro_category = httpServletRequest.getParameter("pro_category");
	    String pro_year = httpServletRequest.getParameter("pro_year");
	    String pro_price = httpServletRequest.getParameter("pro_price");
	    String store_id = httpServletRequest.getParameter("store_id");
	    
	    B_service.merge(pro_code,pro_name,brand_code,pro_category,pro_year,pro_price,store_id);
		
		return "redirect:/ubirep.do";
	}
	
	@RequestMapping(value="/ubi_modify.do")
	public String ubimodify(HttpServletRequest httpServletRequest,Model model) throws Exception {
		
		String code = httpServletRequest.getParameter("pro_code");
		int pro_code = Integer.parseInt(code);
		Busi1VO vo = B_service.view(pro_code);
		
		model.addAttribute("view",vo);
		
		return "ubi_modify";
		
	}

	//ubi 게시판 상세 조회
	@RequestMapping(value="/ubi_view.do")
	public void ubiView(HttpServletRequest httpServletRequest, Model model) throws Exception{
		String code = httpServletRequest.getParameter("pro_code");
		int pro_code = Integer.parseInt(code);
		Busi1VO vo = B_service.view(pro_code);
		
		model.addAttribute("view",vo);
		
	}
	
	//ubi 게시판 삭제
	@RequestMapping(value="/ubi_delete.do")
	public String udidelete(HttpServletRequest httpServletRequest) throws Exception {
		String code = httpServletRequest.getParameter("pro_code");
		int pro_code = Integer.parseInt(code);
		B_service.delete(pro_code);
		
		return "redirect:/ubirep.do";
	}
	
}

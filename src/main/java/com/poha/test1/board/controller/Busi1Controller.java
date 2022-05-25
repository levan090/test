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
		
		for (int i = 0; i < list.size(); i++) {
			Busi1VO testSelect = (Busi1VO)list.get(i);
			
		}
		model.addAttribute("list", list);
		return "ubi_main";
	}
	
//	@RequestMapping(value="/ubiinsert.do")
//	public String ubiInsert(HttpServletRequest httpServletRequest) throws Exception{
//		String proc_name = httpServletRequest.getParameter("proc_name");
//		String brand_code = httpServletRequest.getParameter("brand_code");
//		String pro_category = httpServletRequest.getParameter("pro_category");
//		String pro_year = httpServletRequest.getParameter("pro_year");
//		String pro_price = httpServletRequest.getParameter("pro_price");
//
//		Busi1VO Busi1VO = new Busi1VO();
//		
//
//		Busi1VO.setPro_name(proc_name);
//		Busi1VO.setBrand_code(Integer.parseInt(brand_code));
//		Busi1VO.setPro_category(pro_category);
//		Busi1VO.setPro_year(pro_year);
//		Busi1VO.setPro_price(Integer.parseInt(pro_price));
//
//		sqlSession.insert("test1.ubi_insert",proc_name,brand_code);
//			
//		return "redirect:/";
//	}
	
//	@RequestMapping(value="/ubiinsert_proc.do")
//	public String ubiInsert_proc() {
//		
//		return "";
//	}
	
	@RequestMapping(value="/ubi_write.do")
	public String ubiInsert(Busi1VO vo) throws Exception{
		
		return "ubi_write";
	}
	
	@RequestMapping(value="/ubi_write_proc.do")
	public String ubiInsert_proc(Busi1VO vo) throws Exception{
		B_service.insert(vo);
		
		return "redirect:/ubirep.do";
	}
}

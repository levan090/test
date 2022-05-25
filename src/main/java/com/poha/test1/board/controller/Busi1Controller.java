package com.poha.test1.board.controller;

import java.util.List;
import java.util.Locale;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.poha.test1.board.service.Busi1Service;
import com.poha.test1.board.vo.Busi1VO;

@Controller
public class Busi1Controller {

	@Inject
	private Busi1Service service;
	
	@Autowired
	private SqlSession sqlSession;
	
	
	@RequestMapping(value="/ubirep.do")
	public String ubirep(Locale locale,Model model) {
		List<Busi1VO> list = sqlSession.selectList("test1.select");
		
		for (int i = 0; i < list.size(); i++) {
			Busi1VO testSelect = (Busi1VO)list.get(i);
			
		}
		model.addAttribute("list", list);
		return "ubi_main";
	}
	
	
}

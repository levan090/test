package com.poha.test1.board;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.poha.test1.board.vo.testVO;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static int no;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}	
	
	@Autowired
	private SqlSession sqlSession;
	
	@RequestMapping(value = "/inserttest.do", method = RequestMethod.GET)
	public String inserttest(Locale locale, Model model) {
		testVO testVO = new testVO();
		
		testVO.setContent("테스트내용"+(no++));
		
		sqlSession.insert("test1.insertTest", testVO);
		
		
		return "redirect:dbtest.do";
	}
	
	@RequestMapping(value = "/dbtest.do", method = RequestMethod.GET)
	public String dbtest(Locale locale, Model model) {
		List<testVO> list = sqlSession.selectList("test1.selectTest");
		
		for (int i = 0; i < list.size(); i++) {
			testVO testSelect = (testVO)list.get(i);
			
			logger.info("testSelect.gettestId : {}",testSelect.gettestId());
			logger.info("testSelect.getContent : {}",testSelect.getContent());
		}
		
		model.addAttribute("list", list);
		
		return "dbtest";
	}
 }
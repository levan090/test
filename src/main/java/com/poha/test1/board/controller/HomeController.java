package com.poha.test1.board.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.poha.test1.board.CommonUtil;
import com.poha.test1.board.service.MemberService;
import com.poha.test1.board.service.TestService;
import com.poha.test1.board.vo.MemberVO;
import com.poha.test1.board.vo.testVO;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@Inject
	private TestService service;

	@Autowired
	private SqlSession sqlSession;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	// 기본 홈
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		Object session = CommonUtil.getMemberSession();		// getMemberSession()을 사용해 session의 member를 구함
		
		if(session != null) {								// session이 null값이 아니라면  member에 session을 넣음
			model.addAttribute("member",session);
		}		
		
		return "home";
	}	

		@RequestMapping(value="/main.do")
		public String include_main(Model model) {
			Object session = CommonUtil.getMemberSession();		// getMemberSession()을 사용해 session의 member를 구함
			
			if(session != null) {								// session이 null값이 아니라면  member에 session을 넣음
				model.addAttribute("member",session);
			}		
			return "main";
		}
	
}
	
	
package com.poha.test1.board;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.poha.test1.board.service.TestService;
import com.poha.test1.board.vo.testVO;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@Inject
	private TestService service;
	
	private static int no;
	

	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	// 기본 홈
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
	

	// 테이블 조회한 곳에서 insert
		@RequestMapping(value = "/inserttest.do")
		public String inserttest(HttpServletRequest httpServletRequest, Model model) {
			
			String param = httpServletRequest.getParameter("content");
			testVO testVO = new testVO();
			
			testVO.setContent(param);
			
//			sqlSession.insert("test1.insertTest", testVO);
			sqlSession.insert("test1.insertTest", param);	//한글깨짐현상있어서 변경
			
			return "redirect:listPage?num=1";
			
		}
	
	
	
	// 기존에 있던 테이블 조회
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
	
//	// 게시물 자세히
//	@RequestMapping(value="/dbtest.do", method=RequestMethod.GET)
//	public void getList(Model model) throws Exception {
//		
//			List<testVO> list = null;
//			list = service.list();
//			
//			model.addAttribute("list",list);
//	}
	
	// 데이터 삭제
	@RequestMapping(value = "/delete",method = RequestMethod.GET)
	public String delete(@RequestParam("testId") int testId) throws Exception{
			
		service.delete(testId);
		
		return "redirect:dbtest.do";
	}
	
	// 게시물 수정
	@RequestMapping(value="/modify",method = RequestMethod.GET)
	public void getModify(@RequestParam("testId") int testId, Model model) throws Exception{
		List<testVO> list = sqlSession.selectList("test1.selectTest");
		
		for (int i = 0; i < list.size(); i++) {
			testVO testSelect = (testVO)list.get(i);
			logger.info("testSelect.gettestId : {}",testSelect.gettestId());
			logger.info("testSelect.getContent : {}",testSelect.getContent());
		}
		
		model.addAttribute("list", list);
		
	}
	// 게시물 수정2
	@RequestMapping(value="/modify",method = RequestMethod.POST)
	public String getModify(testVO vo) throws Exception{
		service.modify(vo);
		return "redirect:dbtest.do";
	}
	
	

	//게시물 목록+ 페이징 추가
	@RequestMapping(value="/listPage", method = RequestMethod.GET)
	public void getListPage(Model model, @RequestParam("num") int num) throws Exception{

		
		// 게시물 총 갯수
		int count = service.count();
		
		// 한 페이지에 출력할 게시물갯수
		int postNum=10;
		// 하단 페이징 번호 (게시물 총갯수 / 한 페이지에 출력할 갯수 )
		int pageNum=(int)Math.ceil((double)count/postNum);
			
	
		int displayPost = (num-1) * postNum;
		
		List<testVO> list = null;
		list = service.listPage(displayPost, postNum);
		model.addAttribute("list",list);
		model.addAttribute("pageNum",pageNum);
	}
	
	
 }
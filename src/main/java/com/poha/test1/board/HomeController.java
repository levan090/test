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
	
	private static int no;		// 페이지 마지막
	private static int cou;		// 게시물의 총 갯수


	// 한 페이지에 출력할 게시물갯수
	int postNum=5;
	// 한번에 표시할 페이징 번호의 갯수
	int pageNum_cnt = 5;

	
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
		public String inserttest(HttpServletRequest httpServletRequest, Model model) throws Exception {
			
			String param = httpServletRequest.getParameter("content");
			testVO testVO = new testVO();
			
			testVO.setContent(param);
			
//			sqlSession.insert("test1.insertTest", testVO);
			sqlSession.insert("test1.insertTest", param);	//한글깨짐현상있어서 변경
				
			if(cou%postNum == 0) { no = no+1;}			// 새로운 페이지가 생길 경우
			
			return "redirect:listPage?num=" + no;
			
			
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
	
	// 데이터 삭제
	@RequestMapping(value = "/delete",method = RequestMethod.GET)
	public String delete(@RequestParam("testId") int testId) throws Exception{
			
		service.delete(testId);
		
		return "redirect:listPage?num=1";
		
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
	
		return "redirect:listPage?num=1";
	}
	
	
	

	//게시물 목록+ 페이징 추가
	@RequestMapping(value="/listPage", method = RequestMethod.GET)
	public void getListPage(Model model, @RequestParam("num") int num) throws Exception{

		
		// 게시물 총 갯수
		int count = service.count();
		cou = count;
		// 하단 페이징 번호 (게시물 총갯수 / 한 페이지에 출력할 갯수 )
		int pageNum=(int)Math.ceil((double)count/postNum);
			
		// 출력할 게시물
		int displayPost = (num-1) * postNum;

				

		// 표시되는 페이지 번호 중 마지막 번호
		int endPageNum = (int)(Math.ceil((double)num / (double)pageNum_cnt) * pageNum_cnt);
		
		// 표시되는 페이지 번호 중 첫번 째 번호
		int startPageNum = endPageNum - (pageNum_cnt - 1);
		
		// 마지막 번호 재계산
		int endPageNum_tmp = (int)(Math.ceil((double)count / (double)pageNum_cnt));
		
		if(endPageNum > endPageNum_tmp) {
			endPageNum = endPageNum_tmp;
		}
		no = endPageNum_tmp;  // 마지막페이지
		
		boolean prev = startPageNum == 1? false : true;
		boolean next = endPageNum * pageNum_cnt >= count ? false : true;
		
		List<testVO> list = null;
		list = service.listPage(displayPost, postNum);
		model.addAttribute("list",list);
		model.addAttribute("pageNum",pageNum);
		
		// 시작 및 끝 번호
		model.addAttribute("startPageNum", startPageNum);
		model.addAttribute("endPageNum", endPageNum);
		
		// 이전 및 다음
		model.addAttribute("prev",prev);
		model.addAttribute("next",next);
		
		// 현재페이지
		model.addAttribute("select", num);
		
		
	}
}
	
	
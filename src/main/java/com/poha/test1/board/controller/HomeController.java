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
	
	
	private static int no;		// 페이지 마지막
	private static int cou;		// 게시글의 총 갯수

	int num = 1;
	// 한 페이지에 출력할 게시글갯수
	int postNum=5;
	// 한번에 표시할 페이징 번호의 갯수
	int pageNum_cnt = 5;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	// 기본 홈
	@RequestMapping(value = "/")
	public String home(Locale locale, Model model) throws Exception {
		logger.info("Welcome home! The client locale is {}.", locale);
		
//		Date date = new Date();					기존 시간을 나타내던 부분
//		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
//		
//		String formattedDate = dateFormat.format(date);
//		
//		model.addAttribute("serverTime", formattedDate );
		
					// 게시글 총 갯수
					int count = service.count();
					cou = count;
					// 하단 페이징 번호 (게시글 총갯수 / 한 페이지에 출력할 갯수 )
					int pageNum=(int)Math.ceil((double)count/postNum);
						
					// 출력할 게시글
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
			return "/";
		}
	
}
	
	
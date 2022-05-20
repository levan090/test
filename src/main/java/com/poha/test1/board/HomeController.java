package com.poha.test1.board;

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
	
	@Inject
	MemberService M_service;
	
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
		
		Object session = CommonUtil.getMemberSession();		// getMemberSession()을 사용해 session의 member를 구함
		
		if(session != null) {								// session이 null값이 아니라면  member에 session을 넣음
			model.addAttribute("member",session);
		}		
		
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
			
			logger.info("insert data");
			return "redirect:listPage?num=" + no;
			
			
		}
	
	
	
	// 기존에 있던 테이블 조회
	@RequestMapping(value = "/dbtest.do")
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
	@RequestMapping(value = "/delete.do")
	public String delete(@RequestParam("testId") int testId) throws Exception{
			
		service.delete(testId);
		
		return "redirect:listPage?num=1";
		
	}
	
	// 게시물 수정
	@RequestMapping(value="/modify",method = RequestMethod.GET)
	public void getModify(@RequestParam("testId") int testId, Model model) throws Exception{
		List<testVO> list = sqlSession.selectList("test1.selectTest");
		logger.info("get.register");
		for (int i = 0; i < list.size(); i++) {
			testVO testSelect = (testVO)list.get(i);

		}
		
		model.addAttribute("list", list);
		
	}
	// 게시물 수정2
	@RequestMapping(value="/modify",method = RequestMethod.POST)
	public String getModify(testVO vo) throws Exception{
		logger.info("post.register");
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
		
		
		//회원가입 view
		@RequestMapping(value="/register.do")
		public String postRegister(MemberVO vo) throws Exception {
		
			logger.info("member.register");
			
			// 회원가입 처리로 이동
			return "/member/register";			
		}
		
		//회원가입 처리
		@RequestMapping(value="/register_proc.do")		
		public String postRegisterProc(MemberVO vo) throws Exception {
		
			logger.info("member.register_proc");
			M_service.register(vo);				// 입력받은 회원가입정보(vo)을 M_serivce.register로 db에 저장 
			
			return "login";
		}

		// 로그인 요청을 받음
		@RequestMapping(value = "/login.do")			
		public String login(MemberVO vo, HttpServletRequest req) throws Exception{
			
			logger.info("post login");
			
			
			return "login";
		}
		
		// 로그인을 처리함
		@RequestMapping(value = "/login_proc.do")		
		public String login_proc(MemberVO vo, HttpServletRequest req) throws Exception{
			
			logger.info("login");
			
			HttpSession session = req.getSession();		// 전달받은 세션을 session에 저장
			MemberVO login = M_service.login(vo);		// 입력한 값을 vo를 통해 login 쿼리 진행 후 login에 저장
			
			if(login == null) {							// login이 실패했다면 세션의 member값을 null으로 저장
				session.setAttribute("member", null);
				
			}else {	
				session.setAttribute("member",login);	// login이 성공했다면 세션의 member에 login으로 저장
			}
			return "redirect:/";		
		}
		
		//로그아웃
		@RequestMapping(value="/logout.do")
		public String logout(HttpSession session) throws Exception {
			logger.info("logout");
			
			session.setAttribute("member",null);	//조건을 구별하지 않고 세션의 member값을 null로 바꿈
			
			return "redirect:/";		
		}
	
}
	
	
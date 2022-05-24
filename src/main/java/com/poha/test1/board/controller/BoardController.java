package com.poha.test1.board.controller;
import java.util.List;
import java.util.Locale;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.poha.test1.board.service.TestService;
import com.poha.test1.board.vo.MemberVO;
import com.poha.test1.board.vo.testVO;

@Controller
public class BoardController {
	
	@Inject
	private TestService service;
	
	@Autowired
	private SqlSession sqlSession;
	
	private static int no;		// 페이지 마지막
	private static int cou;		// 게시글의 총 갯수


	// 한 페이지에 출력할 게시글갯수
	int postNum=5;
	// 한번에 표시할 페이징 번호의 갯수
	int pageNum_cnt = 5;
	
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	
	// insert 기능
			@RequestMapping(value = "/inserttest.do")
			public String inserttest(HttpServletRequest httpServletRequest, Model model) throws Exception {
				
				String param = httpServletRequest.getParameter("content");
				testVO testVO = new testVO();
				
				testVO.setContent(param);
				
//				sqlSession.insert("test1.insertTest", testVO);	//한글깨짐현상있어서 변경
				sqlSession.insert("test1.insertTest", param);
					
				if(cou%postNum == 0) { no = no+1;}			// 새로운 페이지가 생길 경우
				
				logger.info("insert data");
				//return "redirect:listPage.do?num=" + no;
				return "redirect:/";
				
			}
		
		// 게시글 테이블 조회
		@RequestMapping(value = "/dbtest.do")
		public String dbtest(Locale locale, Model model) {
			List<testVO> list = sqlSession.selectList("test1.selectTest");
			
			for (int i = 0; i < list.size(); i++) {
				testVO testSelect = (testVO)list.get(i);
				
				logger.info("testSelect.gettestId : {}",testSelect.gettestId());
				logger.info("testSelect.getContent : {}",testSelect.getContent());
			}
			
			model.addAttribute("list", list);
			logger.info("search data");
			return "dbtest";
		}
		
		// 게시글 삭제
		@RequestMapping(value = "/delete.do")
		public String delete(@RequestParam("testId") int testId) throws Exception{
				
			service.delete(testId);
			logger.info("delete data");
			//return "redirect:listPage.do?num=1";
			return "redirect:/";
		}
		
//		// 게시글 수정		 기존 코드 get과 post형식에서 변경필요함
//		@RequestMapping(value="/modify",method = RequestMethod.GET)
//		public void getModify(@RequestParam("testId") int testId, Model model) throws Exception{
//			List<testVO> list = sqlSession.selectList("test1.selectTest");
//			logger.info("get.register");
//			for (int i = 0; i < list.size(); i++) {
//				testVO testSelect = (testVO)list.get(i);
//			}
//			model.addAttribute("list", list);
//		}
//		// 게시글 수정2
//		@RequestMapping(value="/modify",method = RequestMethod.POST)
//		public String getModify(testVO vo) throws Exception{
//			logger.info("post.register");
//			service.modify(vo);
//		
//			return "redirect:listPage?num=1";
//		}
		
		
		// 게시글 수정요청 받음					새로 만들었으나 동작하지 않음. modify 부분에서 값이 진행하는 것은 확인했으나 업데이트 되지않음.
			@RequestMapping(value="/modify.do")
			public String modify(@RequestParam("testId") int testId, Model model) throws Exception{
				List<testVO> list = sqlSession.selectList("test1.selectTest");
				for (int i = 0; i < list.size(); i++) {
					testVO testSelect = (testVO)list.get(i);
				}
				model.addAttribute("list", list);
				logger.info("modify.do");
				return "modify";
				
			}
			// 게시글 수정을 처리함
			@RequestMapping(value="/modify_proc.do")			
			public String modify_Proc(testVO vo) throws Exception{
			
				service.modify(vo);
				logger.info("modify_proc.do");
				return "redirect:listPage?num=1";
			}
		
		// merge
			@RequestMapping(value="/modify2.do")
			public String Modify2(@ModelAttribute("vo") testVO vo,Model model) throws Exception{
					return "modify2";
			}
			@RequestMapping(value="modify2_proc.do")
			public String Modify2_proc(@ModelAttribute("vo") testVO vo,Model model) throws Exception{
				service.merge(vo);
				
				return "redirect:listPage?num=1";
			}

		//게시글 목록+ 페이징 추가
		@RequestMapping(value="/listPage.do")
		public void getListPage(Model model, @RequestParam("num") int num) throws Exception{

			
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
			
			
		}
}

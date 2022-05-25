package com.poha.test1.board.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.poha.test1.board.service.MemberService;
import com.poha.test1.board.vo.MemberVO;

@Controller
public class MemberController {

	
	@Inject
	MemberService M_service;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
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

			// 로그인 요청을 받음 (jsp화면을 보여준다)
			@RequestMapping(value = "/login.do")			
			public String login(MemberVO vo, HttpServletRequest req) throws Exception{
				
				logger.info("post login");
				
				
				return "login";
			}
			
			// 로그인을 처리함 (로그인을 실제로 처리하는부분)
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
				return "redirect:/";				// 임시로 main으로 이동하게 변경
			}
			
			//로그아웃
			@RequestMapping(value="/logout.do")
			public String logout(HttpSession session) throws Exception {
				logger.info("logout");
				
				session.setAttribute("member",null);	//조건을 구별하지 않고 세션의 member값을 null로 바꿈
				
				return "redirect:/";		
			}
}

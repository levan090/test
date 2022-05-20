package com.poha.test1.board.service;

import com.poha.test1.board.vo.MemberVO;

public interface MemberService {

		public void register(MemberVO vo) throws Exception;
		
		public MemberVO login(MemberVO vo) throws Exception;
}

package com.poha.test1.board.dao;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.poha.test1.board.vo.MemberVO;

@Repository
public class MemberDAOImpl implements MemberDAO{

		@Inject SqlSession sql;
		
		private static String namespace="test1";
		
		@Override
		public void register(MemberVO vo) throws Exception {
			sql.insert(namespace + ".register", vo);
		}
		
		@Override
		public MemberVO login(MemberVO vo) throws Exception{
			return sql.selectOne(namespace + ".login", vo);
		}
}

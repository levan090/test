package com.poha.test1.board;

import java.util.List;			
import java.util.Locale;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.poha.test1.board.vo.testVO;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/rest")
@Slf4j
public class SampleRestController {				//사용하지않는 컨트롤러

	@GetMapping(value = "/getText", produces = "text/plain; charset=UTF-8")
	public String getText() {

		log.info("MIME TYPE : " + MediaType.TEXT_PLAIN_VALUE);

		return "안녕하세요";
	}

	@Autowired
	private SqlSession sqlSession;

	@RequestMapping(value = "/getBoard", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
	public List<testVO> getBoard() {
		List<testVO> list = sqlSession.selectList("test1.selectTest");
		
		for (int i = 0; i < list.size(); i++) { 
			testVO testSelect = (testVO)list.get(i);
		  
			log.info("testSelect.getId : {}",testSelect.gettestId());
			log.info("testSelect.getContent : {}",testSelect.getContent()); 
		}
		
		return list;
	}
}

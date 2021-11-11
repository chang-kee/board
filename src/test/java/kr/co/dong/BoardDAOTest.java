package kr.co.dong;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import kr.co.dong.board.BoardDAO;
import kr.co.dong.board.BoardDTO;
import kr.co.dong.board.Criteria;

public class BoardDAOTest {
	@Inject
	BoardDAO dao;
	
	private static final Logger logger = LoggerFactory.getLogger(BoardDAOTest.class);
	
	@Test
	public void testListPage() throws Exception {
		int page =3;
		
		List<BoardDTO> list = dao.listPage(page);
		
		for (BoardDTO boardTO : list) {
			logger.info(boardTO.getBno()+":" + boardTO.getTitle());
		}
	}
	@Test
	public void testListCriteria() throws Exception {
		Criteria cri = new Criteria();
		cri.setPage(2);
		cri.setPerPageNum(20);
		
		List<BoardDTO> list = dao.listCriteria(cri);
		
		for (BoardDTO boardTO : list) {
			logger.info(boardTO.getBno()+":" + boardTO.getTitle());
		}
	}
}

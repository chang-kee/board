package kr.co.dong.board;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;


@Service
public class BoardServiceImp implements BoardService {

	@Inject
	BoardDAO boardDAO;

	@Override
	public Map login(Map<String, Object> map) throws Exception {
		return boardDAO.login(map);
	}
	@Override
	public List<BoardDTO> list() throws Exception {
		return boardDAO.list();
	}
	@Override
	public BoardDTO getDetail(int bno) throws Exception {
		return boardDAO.getDetail(bno);
	}
	@Override
	public int updateReadCnt(int bno) throws Exception {
		return boardDAO.updateReadCnt(bno);
	}
	@Override
	public int register(BoardDTO boardDTO) throws Exception {
		return boardDAO.register(boardDTO);
	}
	@Override
	public int update(BoardDTO boardDTO) throws Exception {
		return boardDAO.update(boardDTO);
	}
	@Override
	public int delete(int bno) throws Exception {
		return boardDAO.delete(bno);
	}
	@Override
	public int reply(BoardReply boardReply) throws Exception {
		return boardDAO.reply(boardReply);
	}
	@Override
	public List<BoardReply> getDetail1(int bno) throws Exception {
		return boardDAO.getDetail1(bno);
	}
	@Override
	public BoardReply detailreply(int reno) throws Exception {
		return boardDAO.detailreply(reno);
	}
	@Override
	public int replyupdate(BoardReply boardReply) throws Exception {
		return boardDAO.replyupdate(boardReply);	
	}
	@Override
	public int replyDelete(int reno) throws Exception {
		return boardDAO.replyDelete(reno);
	}
	@Override
	public List<BoardDTO> listCriteria(Criteria cri) throws Exception {
		return boardDAO.listCriteria(cri);
	}
	@Override
	public int listCountCriteria(Criteria cri) throws Exception {
		return boardDAO.countPaging(cri);
	}
}

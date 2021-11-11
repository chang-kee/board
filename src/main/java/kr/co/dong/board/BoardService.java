package kr.co.dong.board;

import java.util.List;
import java.util.Map;

public interface BoardService {

	public Map login(Map<String, Object> map) throws Exception;
	public List<BoardDTO> list() throws Exception;
	public int register(BoardDTO boardDTO) throws Exception;
	public BoardDTO getDetail(int bno) throws Exception;
	public int update(BoardDTO boardDTO) throws Exception;
	public int delete(int bno) throws Exception;
	public int updateReadCnt(int bno) throws Exception;
	public int reply(BoardReply boardReply) throws Exception;
	public List<BoardReply> getDetail1(int bno) throws Exception;
	public BoardReply detailreply(int reno) throws Exception;
	public int replyupdate(BoardReply boardReply)throws Exception;
	public int replyDelete(int reno)throws Exception;
	public List<BoardDTO> listCriteria(Criteria cri) throws Exception;
	public int listCountCriteria(Criteria cri) throws Exception;
	
}

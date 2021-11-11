package kr.co.dong.board;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDAOImp implements BoardDAO {
	
	private static final String nameSpace = "kr.co.dong.boardMapper";
	
	@Inject
	SqlSession sqlSession;

	@Override
	public Map login(Map<String, Object> map) {
		return sqlSession.selectOne(nameSpace+".login", map);
	}
	@Override
	public List<BoardDTO> list() {
		return sqlSession.selectList(nameSpace+".list");
	}
	@Override
	public int register(BoardDTO boardDTO) {
		return sqlSession.insert(nameSpace+".register", boardDTO);
	}
	@Override
	public int update(BoardDTO boardDTO) {
		return sqlSession.update(nameSpace+".update", boardDTO);
	}
	@Override
	public BoardDTO getDetail(int bno) {
		return sqlSession.selectOne(nameSpace+".detail", bno);
	}
	@Override
	public int delete(int bno) {
		return sqlSession.delete(nameSpace+".delete", bno);
	}
	@Override
	public int updateReadCnt(int bno) {
		return sqlSession.update(nameSpace+".updataReadCnt", bno);
	}
	@Override
	public int reply(BoardReply boardReply) throws Exception {
		return sqlSession.insert(nameSpace+".reply", boardReply);
	}
	@Override
	public List<BoardReply> getDetail1(int bno) throws Exception {
		return sqlSession.selectList(nameSpace+".detail1", bno);
	}
	@Override
	public BoardReply detailreply(int reno) throws Exception {
		return sqlSession.selectOne(nameSpace+".detailreply", reno);
	}
	@Override
	public int replyupdate(BoardReply boardReply) throws Exception {
		return sqlSession.update(nameSpace+".replyupdate", boardReply);
	}
	@Override
	public int replyDelete(int reno) throws Exception {
		return sqlSession.delete(nameSpace+".replyDelete", reno);
	}
	@Override
	public List<BoardDTO> listPage(int page) throws Exception {
		
		if (page <= 0) {
			page = 1;
		}
		page = (page -1) * 10;
	
		return sqlSession.selectList(nameSpace+".listPage", page);
	}
	@Override
	public List<BoardDTO> listCriteria(Criteria cri) throws Exception {
		return sqlSession.selectList(nameSpace+".listCriteria", cri);
	}
	@Override
	public int countPaging(Criteria cri) throws Exception {
		return sqlSession.selectOne(nameSpace+".countPaging", cri);
	}
}

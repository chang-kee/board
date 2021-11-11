package kr.co.dong.emp;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class EmpDAOImp implements EmpDAO {
	
	@Inject
	private SqlSession session;
	
	private static final String nameSpace = "kr.co.dong.empMapper";

	@Override
	public int empCount() throws Exception {
		
		return session.selectOne(nameSpace+".empCount");
		
	}
	

}

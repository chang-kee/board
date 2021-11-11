package kr.co.dong.emp;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public class EmpServiceImp implements EmpService {
	
	@Inject
	private EmpDAO dao;

	@Override
	public int empCount() throws Exception {
		
		return dao.empCount();
	}
}
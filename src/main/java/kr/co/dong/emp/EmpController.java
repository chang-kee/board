package kr.co.dong.emp;

import javax.inject.Inject;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.co.dong.controller.LoginController;

@Controller
public class EmpController {
	
	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(EmpController.class);
	
	@Inject
	private EmpService service;
	
	@RequestMapping(value="/empCount")
	public String empCount(Model model)  throws Exception {
		int empCount = service.empCount();
		model.addAttribute("empCount", empCount);
		
		return "emp/empCount";
	}
	@RequestMapping(value="/board/empCount")
	public String empCount2(Model model)  throws Exception {
		int empCount = service.empCount();
		model.addAttribute("empCount", empCount);
		
		return "emp/empCount";
	}
}

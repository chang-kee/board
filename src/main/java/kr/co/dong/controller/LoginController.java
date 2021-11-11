package kr.co.dong.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController{
	
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String login() {
		
		return "loginForm";
	}
//	@RequestMapping(value="board/login", method=RequestMethod.POST)
//	public String login2() {
//	
//		return "redirect:/";
//	}
	@RequestMapping(value="/login", method=RequestMethod.POST)
		public ModelAndView login3() throws Exception {
			
		ModelAndView mav = new ModelAndView();
			mav.setViewName("redirect:/");
			return mav;
		
	}
}

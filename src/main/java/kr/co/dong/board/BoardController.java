package kr.co.dong.board;

import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class BoardController {

	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);

	@Inject
	BoardService boardService;

	@RequestMapping(value = "/board/login", method = RequestMethod.GET)
	public String login() {
		logger.info("login view 이동");

		return "login";
	}

	@RequestMapping(value = "/board/login", method = RequestMethod.POST)
	public String login(@RequestParam Map<String, Object> map, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) throws Exception {
		// start
		request.setCharacterEncoding("utf-8");
		logger.info("요청정보 받아서 보내기");
		Map user = boardService.login(map);

		if (user == null) { // 로그인 실패
			logger.info("로그인 안됨");
			return "redirect:login";
		} else { // 로그인 성공
			// 세션부여 : 서버가 보관하는 전역 변수(속성)
			logger.info("로그인 성공");

			session.setAttribute("user", user);
			logger.info("name :" + user.get("name"));
			return "home";
		}
		// end
	}

	@RequestMapping(value = "/board/logout", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		session.invalidate();// 세션 해제
		return "redirect:/";
	}

	@RequestMapping(value = "/board/list", method = RequestMethod.GET)
	public ModelAndView list() throws Exception {
		ModelAndView mav = new ModelAndView();

		List<BoardDTO> list = boardService.list();

		// view 전달
		mav.addObject("list", list);
		mav.setViewName("list");
		return mav;

	}

	@RequestMapping(value = "/board/register", method = RequestMethod.GET)
	public String register() {
		logger.info("글쓰기 이동");
		return "register";
	}

	@RequestMapping(value = "/board/register", method = RequestMethod.POST)
	public String register(BoardDTO boardDTO, HttpServletRequest request, RedirectAttributes rttr) throws Exception {
		request.setCharacterEncoding("UTF-8");

		logger.info("내용" + boardDTO);
		int r = boardService.register(boardDTO);

		if (r > 0) {
			rttr.addFlashAttribute("msg", "추가에 성공하였습니다.");
		}
		return "redirect:listPage";

	}

	@RequestMapping(value = "/board/update", method = RequestMethod.GET)
	public String update(@RequestParam("bno") int bno, Model model) throws Exception {
		BoardDTO board = boardService.getDetail(bno);
		model.addAttribute("board", board);

		return "update";
	}

	@RequestMapping(value = "/board/update", method = RequestMethod.POST)
	public String update(BoardDTO boardDTO, RedirectAttributes attr, HttpServletRequest request) throws Exception {
		request.setCharacterEncoding("utf-8");
		int r = boardService.update(boardDTO);
		// 수정에 성공하면 목록보기로 이동
		if (r > 0) {
			attr.addFlashAttribute("msg", "수정에 성공 하였습니다.");
			return "redirect:listPage";
		}
		// 수정에 실패하면 수정보기 화면으로 이동
		return "redirect:update?bno=" + boardDTO.getBno();

	}

	@RequestMapping(value = "/board/detail", method = RequestMethod.GET)
	public String detail(@RequestParam("bno") int bno, Model model) throws Exception {

		// 비지니스모델 , 서비스
		BoardDTO boardDTO = boardService.getDetail(bno);
		boardService.updateReadCnt(bno); // 조회수
		model.addAttribute("board", boardDTO);

		// 해당글에 대한 댓글 가져오기
		List<BoardReply> replylist = boardService.getDetail1(bno); 
		model.addAttribute("list", replylist);  // 댓글목록

		return "detail";
	}

	@RequestMapping(value = "/board/delete", method = RequestMethod.GET)
	public String delete(@RequestParam("bno") int bno, RedirectAttributes rttr) throws Exception {
		int r = boardService.delete(bno);

		if (r > 0) {
			rttr.addFlashAttribute("msg", "글삭제에 성공하였습니다.");
			return "redirect:listPage";
		}
		return "redirect:detail?bno=" + bno;

	}

	@RequestMapping(value = "/board/reply", method = RequestMethod.GET)
	public String reply() {
		return "reply";
	}

	@RequestMapping(value = "/board/reply", method = RequestMethod.POST)
	public String reply(BoardReply boardReply) throws Exception {
		int r = boardService.reply(boardReply);
		if (r > 0) {
			return "redirect:detail?bno=" + boardReply.getBno();
		}
		return "reply";
	}

	// ajax 쓰기 구현
		@ResponseBody	
		@RequestMapping(value="/board/reply2", method = RequestMethod.POST)
		public int reply2(BoardReply boardReply) throws Exception {
			
			return boardService.reply(boardReply);
		}
		
		// 댓글 목록 조회
		@ResponseBody
		@RequestMapping(value="/board/replylist", method = RequestMethod.POST)
		public List<BoardReply> replylist(@RequestParam("bno") int bno) throws Exception{
			return boardService.getDetail1(bno);  
		}
		
		@ResponseBody
		@RequestMapping(value="/board/replyupdate2", method = RequestMethod.POST)
		public Map<String,Object> replyupdate2(BoardReply boardReply){
			Map<String,Object> result = new HashMap<String, Object>();
			try {
				boardService.replyupdate(boardReply);
				result.put("status","OK");
			}catch(Exception e) {
				e.printStackTrace();
				result.put("status","Fail");
			}
			
			return result;
		}
		//ajax 삭제 구현
		@ResponseBody
		@RequestMapping(value="/board/replyDelete2", method = RequestMethod.POST)
//		public int replyDelete2(@RequestParam("reno")int reno) {
//				return boardService.replyDelete(reno);
//		}
		public Map<String,Object> replyDelete2(@RequestParam("reno")int reno) {
			Map<String, Object> result = new HashMap<String, Object>();	
			try {
				boardService.replyDelete(reno);
				result.put("status","OK");
			}
			catch(Exception e) {
				e.printStackTrace();
				result.put("status","Fail");
			}
			return result;
		}
		//페이징 처리
		@RequestMapping(value="/board/listCri", method=RequestMethod.GET)
		public String listAll(Criteria cri, Model model) throws Exception {
			logger.info("show list page with Criteria----------");
			
			
			model.addAttribute("list", boardService.listCriteria(cri));
		
			return "listCri";
		}
		@RequestMapping(value="/board/listPage", method=RequestMethod.GET)
		public String listPage(@ModelAttribute("cri")Criteria cri, Model model) throws Exception {
			logger.info(cri.toString());
			
			model.addAttribute("list", boardService.listCriteria(cri));
			PageMaker pageMaker = new PageMaker();
			pageMaker.setCri(cri);
			//pageMaker.setTotalCount(2005);
			
			pageMaker.setTotalCount(boardService.listCountCriteria(cri));
			
			model.addAttribute("pageMaker", pageMaker);
			return "listPage";
		}
		
}

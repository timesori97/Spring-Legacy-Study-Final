package www.silver.hom;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import www.silver.VO.BBSVO;
import www.silver.VO.PageVO;
import www.silver.service.IF_bbsService;
import www.silver.util.FileDataUtil;

@Controller
public class BBSController {
	@Inject
	IF_bbsService bbssrc;
	
	@Inject
	FileDataUtil filedatautil;
	
	@RequestMapping(value = "/wrf", method = RequestMethod.GET)
	public String memberjoind() {
		return "/bbs/wrf";
	}
	@RequestMapping(value = "/saved", method = RequestMethod.POST)
	public String saved(@ModelAttribute BBSVO bbsvo, MultipartFile[] filename) throws Exception{
		String[] fnams = filedatautil.fileUpload(filename);
		
		bbsvo.setFnames(fnams);
		System.out.println("Controller "+fnams[0]+"/"+fnams[1]);
		bbssrc.inserbbs(bbsvo);
		return "/bbs/wrf";
	}
	
	@RequestMapping(value = "/bbslist", method = RequestMethod.GET)
	public String bbslist(Model model, @ModelAttribute PageVO pagevo) throws Exception{
	
		// 서비스  > dao > select * from kbbs~~~  쿼리문 분석
		//List<BBSVO> bbslist = bbssrc.selectall();
		
		//model.add
		// paging 
		/*
		 * select t.* from (select sub.*, rownum as rnum from (select * from
		kbbs order by no DESC) sub) t
		where rnum between 11 and 20

		 *   페이지가 1     1  10
		 *   페이지가 2     11  20
		 *   페이지가 3     21  30
		 *   
		 *   현제 페이지는 클라이언트로 부터 받는다..
		 */
		if(pagevo.getPage()==null) {
			pagevo.setPage(1);
		}
		System.out.println("현재 page "+pagevo.getPage());
		pagevo.setTotalCount(bbssrc.getTotalCnt());
		System.out.println("현재 page 시작 번호 :"+pagevo.getStartNo());
		System.out.println("현재 page 끝 번호 :"+pagevo.getEndNo());
		System.out.println("현재 page가 속한 그룹의 시작번호 :"+pagevo.getStartPage());
		System.out.println("현재 page가 속한 그룹의 끝번호 :"+pagevo.getEndPage());
		
		List<BBSVO> bbslist = bbssrc.selectall(pagevo);
		model.addAttribute("bbslist", bbslist);
		return "/bbs/bbslist";
	}
	@RequestMapping(value = "/del", method = RequestMethod.GET)
	public String delete(@RequestParam("no") String no,
			HttpSession session) {
		// 컨틀롤러 진입 후 세션을 검사하여 권한을 주는 코드인데.. 이렇게 코드를 작성하면 매핑 마다 반복된 코드를 작성해야 한다..
		// 이를 해결하기 위해서 여러 방법도 있지만..ㅇ 인터셉터를 이용해서 해결해 보려고 합니다..
		//  인터셉터는 컨트롤러 진입 전 .. 진입 후 거쳐가는 것이다.. 
		// 필터랑 인터셉터의 차이? 위치 설명.. 
//		Object o = session.getAttribute("userid");
//		System.out.println(o +"  user");
//		if(o == null) {
//			System.out.println("비회원");
//		}else {
//			bbssrc.delete(no);
//		}
		bbssrc.delete(no);
		return "redirect:/bbslist";
	}
	
	@RequestMapping(value = "/mod", method = RequestMethod.GET)
	public String mod(@RequestParam("no") String no, Model model) {
		
		BBSVO bbsvo = bbssrc.mod(no);
		model.addAttribute("bbsvo", bbsvo);		
		return "bbs/modf";
	}
	
	@RequestMapping(value = "/mod", method = RequestMethod.POST)
	public String modsave(@ModelAttribute BBSVO bbsvo) {
		System.out.println(bbsvo.getNo() +"글 저장");
		bbssrc.update(bbsvo);
		return "redirect:/bbslist";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
